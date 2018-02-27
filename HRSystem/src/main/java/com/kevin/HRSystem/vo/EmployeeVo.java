package com.kevin.HRSystem.vo;

import java.io.Serializable;

public class EmployeeVo implements Serializable {
    private static final long serialVersionUID = 48L;

    private String employeeName;
    private String employeePassword;
    private double amount;

    public EmployeeVo() {
    }

    public EmployeeVo(String employeeName, String employeePassword, double amount) {
        this.employeeName = employeeName;
        this.employeePassword = employeePassword;
        this.amount = amount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
