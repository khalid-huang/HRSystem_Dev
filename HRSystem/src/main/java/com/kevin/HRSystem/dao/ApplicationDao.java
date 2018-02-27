package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.Application;
import com.kevin.HRSystem.model.Employee;

import java.util.List;

public interface ApplicationDao extends BaseDao<Application>{

    /**
     * 根据员工查询未处理的异动申请
     * @param employee 需要查询的员工
     * @return 该员工对应的未处理的异动申请
     */
    List<Application> findByEmp(Employee employee);
}
