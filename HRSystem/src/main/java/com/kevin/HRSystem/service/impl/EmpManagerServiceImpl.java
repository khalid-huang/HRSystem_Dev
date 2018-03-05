package com.kevin.HRSystem.service.impl;

import com.kevin.HRSystem.dao.*;
import com.kevin.HRSystem.model.*;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.vo.AttendVo;
import com.kevin.HRSystem.vo.PaymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.kevin.HRSystem.constant.ConstantManager.*;

@Service("EmpManagerService")
public class EmpManagerServiceImpl implements EmpManagerService {
    @Resource
    private ApplicationDao applicationDao;
    @Resource
    private AttendDao attendDao;
    @Resource
    private AttendTypeDao attendTypeDao;
    @Resource
    private CheckbackDao checkbackDao;
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private ManagerDao managerDao;
    @Resource
    private PaymentDao paymentDao;


    public int validLogin(Employee employee) {
        if(null != managerDao.findByNameAndPass(employee.getName(), employee.getPassword())) {
            return LOGIN_MGR;
        }

        if(null != employeeDao.findByNameAndPass(employee.getName(), employee.getPassword())) {
            return LOGIN_EMP;
        }

        return LOGIN_FALT;
    }

    public void autoPunch() {
        List<Employee> employees = employeeDao.findAll();
        //获取当前时间
        String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
        for(Employee employee : employees) {
            //先设置出勤类型为旷工，然后真正出勤的时候由员工去修改出勤的状态
            //6表示旷工；已经插入数据库了; 这里最好弄一个常量管理类；但为了方便先这样吧
            AttendType attendType = attendTypeDao.findById(6);
            Attend a = new Attend();
            a.setAttendType(attendType);
            a.setDutyDay(dutyDay);
            //如果是早上，则对应上班打卡
            if(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
                a.setCome(true);
            } else {
                //下班打卡
                a.setCome(false);
            }
            a.setEmployee(employee);
            attendDao.save(a);
        }
    }

    public void autoPay() {
        List<Employee> employees = employeeDao.findAll();
        //获取上个月时间
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -15);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String payMonth = sdf.format(c.getTime());

        for(Employee employee : employees) {
            Payment pay = new Payment();
            double amount = employee.getSalary();
            //获取出勤记录
            List<Attend> attends = attendDao.findByEmpAndMonth(employee, payMonth);
            //计算工资
            for(Attend attend : attends) {
                amount += attend.getAttendType().getAmerceAmount();
            }
            pay.setPayMonth(payMonth);
            pay.setEmployee(employee);
            pay.setPayAmount(amount);
            paymentDao.save(pay);
        }

    }

    @Override
    public int validPunch(String user, String dutyDay) {
        //不能查找到对应的用户，返回无法打卡
        Employee employee = employeeDao.findByName(user);
        if(null == employee) {
            return NO_PUNCH;
        }
        //打到员工指定日期的出勤记录
        List<Attend> attends = attendDao.findByEmpAndDutyDay(employee, dutyDay);
        //系统没有为用户在当前插入空打卡记录，无法打卡
        if(null == attends || attends.size() == 0) {
            return NO_PUNCH;
        }

        //开始上班打卡
        if(attends.size() == 1 && attends.get(0).isCome() && null == attends.get(0).getPunchTime()) {
            return COME_PUNCH;
        }
        if(attends.size() == 1 && null == attends.get(0).getPunchTime()) {
            return  LEAVE_PUNCH;
        }
        if(attends.size() == 2) {
            if(null == attends.get(0).getPunchTime() && null == attends.get(0).getPunchTime()) {
                return BOTH_PUNCH;
            } else if(null == attends.get(1).getPunchTime()) {
                return LEAVE_PUNCH;
            } else {
                return NO_PUNCH;
            }
        }
        return NO_PUNCH;
    }

    public int punch(String user, String dutyDay, boolean isCome) {
        Employee employee = employeeDao.findByName(user);
        if(null == employee) {
            return PUNCH_FALT;
        }

        //找到员工本次打卡对应的出勤记录
        Attend attend = attendDao.findByEmpAndDutyDayAndCome(employee, dutyDay, isCome);
        if(null == attend) {
            return PUNCH_FALT;
        }
        //如果已经打卡
        if(null != attend.getPunchTime()) {
            return PUNCHED;
        }

        int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        attend.setPunchTime(new Date());
        //上班打卡
        if(isCome) {
            //9点之前算正常
            if(punchHour < COME_LIMIT) {
                //1表示正常
                attend.setAttendType(attendTypeDao.findById(1));
            } else if (punchHour < LATE_LIMIT) {
               //9点到11点之间算迟到
               attend.setAttendType(attendTypeDao.findById(4));
            }
            //11点之后算旷工，不用管，本来初始就是旷工
        } else {
            //下班打卡
            //18点之后算正常
            if(punchHour >= LEAVE_LIMIT) {
                attend.setAttendType(attendTypeDao.findById(1));
            } else if(punchHour >= LEAVE_LIMIT) {
                //16到18点算正常
                attend.setAttendType(attendTypeDao.findById(5));
            }
        }
        attendDao.update(attend);
        return PUNCH_SUCC;
    }

    public List<PaymentVo> employeeSalary(String employeeName) {
        Employee employee = employeeDao.findByName(employeeName);

        List<Payment> payments = paymentDao.findByEmp(employee);

        List<PaymentVo> result = new ArrayList<PaymentVo>();

        for(Payment payment : payments) {
            result.add(new PaymentVo(payment.getPayMonth(), payment.getPayAmount()));
        }
        return result;
    }

    /**
     * 查看自己最近三天的非正常打卡
     * @param employeeName 员工名
     * @return 该员工的最近三天的非正常打卡
     */
    public List<AttendVo> unAttend(String employeeName) {
        AttendType type = attendTypeDao.findById(1);
        Employee employee = employeeDao.findByName(employeeName);

        //获取最近三天非正常的出勤记录
        List<Attend> attends = attendDao.findByEmpunAttend(employee, type);
        List<AttendVo> result = new ArrayList<AttendVo>();
        for(Attend attend : attends) {
            result.add(new AttendVo(attend.getId(), attend.getDutyDay(), attend.getAttendType().getTypeName(), attend.getPunchTime()));
        }
        return result;

    }

    public List<AttendType> getAllType() {
        return attendTypeDao.findAll();
    }

    @Override
    public boolean addApplication(int attId, int typeId, String reason) {
        Application application = new Application();
        //获取申请需要改变的出勤记录
        Attend attend = attendDao.findById(attId);
        AttendType type = attendTypeDao.findById(typeId);
        application.setAttend(attend);
        application.setAttendType(type);
        if(reason != null) {
            application.setApplicationReason(reason);
        }
        applicationDao.save(application);
        return true;
    }
}
