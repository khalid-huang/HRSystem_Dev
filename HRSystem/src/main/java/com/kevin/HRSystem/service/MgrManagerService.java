package com.kevin.HRSystem.service;

import com.kevin.HRSystem.exception.HrException;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.vo.ApplicationVo;
import com.kevin.HRSystem.vo.EmployeeVo;
import com.kevin.HRSystem.vo.SalaryVo;

import java.util.List;

public interface MgrManagerService {

    /**
     * 新增员工
     * @param employee 新增的员工
     * @param manager 员工所属的经理
     * @throws HrException
     */
    void addEmployee(Employee employee, String manager) throws HrException;


    /**
     * 根据经理返回所有的部门上个月的工资
     * @param manager 经理
     * @return 部门上个月的工资
     */
    List<SalaryVo> getSalaryByManger(String manager);

    /**
     * 根据经理返回部门的全部员工
     * @param manager 经理名
     * @return 经理的全部下属
     */
    List<EmployeeVo> getEmployeesByManager(String manager);

    /**
     * 根据经理返回该部门的没有批复的申请
     * @param manager 经理名
     * @return 该部门的全部申请
     */
    List<ApplicationVo> getApplicationByManager(String manager);

    /**
     * 处理申请
     * @param applicationId 申请ID
     * @param managerName 经理名字
     * @param result 是否通过
     */
    void check(long applicationId, String managerName, boolean result);

}
