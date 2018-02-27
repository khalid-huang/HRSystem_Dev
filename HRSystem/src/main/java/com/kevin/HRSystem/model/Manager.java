package com.kevin.HRSystem.model;

import java.util.List;

public class Manager extends Employee {

    private String departmentName;

    private List<Employee> employees;

    private List<Checkback> checkbacks;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Checkback> getCheckbacks() {
        return checkbacks;
    }

    public void setCheckbacks(List<Checkback> checkbacks) {
        this.checkbacks = checkbacks;
    }

    @Override
    public String toString() {
        return "Manager [id=" + this.getId() + ", name=" + this.getName() + ", password=" + this.getPassword() + ", type=" + this.getType() + ", salary=" + this.getSalary()  + ", departmentName=" + this.getDepartmentName() + "]";
    }
}
