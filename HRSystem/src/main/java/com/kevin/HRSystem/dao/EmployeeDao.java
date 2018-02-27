package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.EnumMap;
import java.util.List;

public interface EmployeeDao extends BaseDao<Employee>{
    /**
     * 根据用户名和密码查询员工
     * @param name 用户名
     *        password 密码
     * @return 返回员工
     */
    public Employee findByNameAndPass(@Param("name")String name, @Param("password") String password);

    public Employee findByName(@Param("name")String name);

    public List<Employee> findEmployeesByMgrId(@Param("id") long id);
}
