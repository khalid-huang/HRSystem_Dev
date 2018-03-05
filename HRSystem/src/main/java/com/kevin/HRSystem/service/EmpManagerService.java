package com.kevin.HRSystem.service;

import com.kevin.HRSystem.model.AttendType;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.model.Manager;
import com.kevin.HRSystem.vo.AttendVo;
import com.kevin.HRSystem.vo.PaymentVo;

import java.util.List;

public interface EmpManagerService {

    /**
     * 以经理身份来验证登录
     * @param employee 登录的身份
     * @return
     *  登录后的身份确认：0为登录失败，1为登录emp，2为登录mgr
     */
    int validLogin(Employee employee);


    /**
     * 自动打卡，周一到周五，早上7点为每个员工插入旷工记录
     */
    void autoPunch();

    /**
     * 自动结算工资，每月1号，结算上个月工资
     */
    void autoPay();

    /**
     * 验证某个员工是否可以打卡
     * @param user 员工名
     * @param dutyDay 日期
     * @return 可打卡的类别
     */
    int validPunch(String user, String dutyDay);


    /**
     * 打卡
     * @param user 员工名
     * @param dutyDay 打卡日期
     * @param isCome 是否是上班打卡
     * @return 打卡结果
     */
    int punch(String user, String dutyDay, boolean isCome);

    /**
     * 根据员工浏览自己的工资
     * @param employeeName 员工名
     * @return 该员工的工资列表
     */
    List<PaymentVo> employeeSalary(String employeeName);


    /**
     * 员工查看自己的最近三天的非正常打卡
     * @param employeeName 员工名
     * @return 该员工最近三天的非正常打卡
     */
    List<AttendVo> unAttend(String employeeName);


    /**
     * 返回全部的出勤类别
     * @return 全部的出勤类别
     */
    List<AttendType> getAllType();

    /**
     * 添加申请
     * @param attId 申请的出勤ID
     * @param typeId 申请的类型ID
     * @param reason 申请的理由
     * @return 添加的结果
     */
    boolean addApplication(int attId, int typeId, String reason);

}
