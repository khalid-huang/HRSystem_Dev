package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.model.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentDao extends BaseDao<Payment>{
    /**
     * 根据员工查询月结薪水
     * @param employee 员工
     * @return 返回该员工对应的月结薪水集合
     */
    List<Payment> findByEmp(Employee employee);


    /**
     * 根据员工和发薪月份来查询月结薪水
     * @param payMonth 发薪月份
     * @param employee 领薪的员工
     * @return 返回指定员工和指定月份的月结薪水
     */
    Payment findByMonthAndEmp(@Param("payMonth") String payMonth, @Param("employee") Employee employee);


}
