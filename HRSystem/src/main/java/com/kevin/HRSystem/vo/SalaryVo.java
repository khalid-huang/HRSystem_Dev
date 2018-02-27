package com.kevin.HRSystem.vo;

import java.io.Serializable;

public class SalaryVo implements Serializable {
    private static final long serialVersionUID = 48L;

    private String employeeName;
    private double  amount;

    public SalaryVo() {
    }

    public SalaryVo(String employeeName, double amount) {
        this.employeeName = employeeName;
        this.amount = amount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
