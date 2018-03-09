package com.kevin.HRSystem;

import com.kevin.HRSystem.dao.ApplicationDao;
import com.kevin.HRSystem.dao.AttendDao;
import com.kevin.HRSystem.dao.EmployeeDao;
import com.kevin.HRSystem.model.*;
import com.kevin.HRSystem.service.EmpManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class HRSystemApplicationTest {


    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private AttendDao attendDao;

    @Autowired
    private EmpManagerService empManagerService;

    @Test
    public void testSelectUser() throws Exception {
        //测试employee
//        long e_id = 3;
//        Employee employee = employeeDao.findById(e_id);
//        System.out.println(employee.getManager().getId());
////        System.out.println(employee.toString());
//          List<Employee> employees = employeeDao.findAll();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//
//        Employee employee = employeeDao.findById(1);
//        if(employee instanceof Manager) {
//            System.out.println("manager");
//            Manager manager = (Manager) employee;
//            System.out.println(manager.getEmployees().size());
//        }

//        //测试getUnAttend
//        List<AttendVo> unAttends = empManagerService.getUnAttend(employee.getName());
//        System.out.println(unAttends.get(0).getUnType());
//        System.out.println(unAttends.get(0).getDutyDay());
//        System.out.println(unAttends.size());

        //自动调度接口测试
//        empManagerService.autoPunch();
//        empManagerService.autoPay();

        //测试attend
//        long attend_id = 1;
//        Attend attend = attendDao.findById(attend_id);
//        System.out.println(attend.toString());
//
//        System.out.println(attend.getAttendType().getId());
//        System.out.println(attend.getEmployee().getId());
//
//        AttendType attendType = attend.getAttendType();
//        attendType.setId(3);
//        attend.setAttendType(attendType);
//        attendDao.update(attend);

          //Application测试
        Employee employee = employeeDao.findById(3);
        List<Application> applications = applicationDao.findByEmp(employee);
        System.out.println(applications.size());
        if(applications.size() > 0) {
            Application application = applications.get(0);
            System.out.println("unAttendTypeName: " + application.getAttend().getAttendType().getTypeName());
            System.out.println("toAttendTypeName" + application.getAttendType().getTypeName());
        }
//        Application application = applicationDao.selectApplicationByID(id);
//        System.out.println(application.getAttendType());
//        Application application = new Application();
//        application.setApplicationReason("reason");
//        application.setApplicationResult(true);
//
//        AttendType attendType = new AttendType();
//        attendType.setAmerceAmount(-10);
//        attendType.setTypeName("事假");
//        Attend attend = new Attend();
//        attend.set
//        application.setAttend();
    }
}
