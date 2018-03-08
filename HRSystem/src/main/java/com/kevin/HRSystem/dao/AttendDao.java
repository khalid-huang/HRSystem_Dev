package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.Attend;
import com.kevin.HRSystem.model.AttendType;
import com.kevin.HRSystem.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendDao extends BaseDao<Attend> {

    /**
     * 根据员工和月分查询该员工的出勤记录
     * @param employee 员工
     * @param month 月份，是形如 “2012-12”的字符串
     * @return 该员工在指定月份的全部出勤记录
     */
    List<Attend> findByEmpAndMonth(@Param("employee") Employee employee, @Param("month") String month);


    /**
     * 根据员工，日期查询该员工的打卡记录集合
     * @param employee 员工
     * @param dutyDay 日期
     * @return 该员工的某天的打卡记录集合
     */
    List<Attend> findByEmpAndDutyDay(@Param("employee") Employee employee, @Param("dutyDay") String dutyDay);


    /**
     * 根据员工，日期，上下班查询该员工的打卡记录集合
     * @param employee 员工
     * @param dutyDay 日期
     * @param isCome 是否上班
     * @return 该员工的某天上班或下班物打卡记录
     */
    Attend findByEmpAndDutyDayAndCome(@Param("employee") Employee employee, @Param("dutyDay") String dutyDay,@Param("isCome") boolean isCome);

    List<Attend> findByEmpUnAttend(@Param("employee") Employee employee,@Param("attendType") AttendType attendType);
}
