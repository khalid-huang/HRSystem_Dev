package com.kevin.HRSystem.vo;

import java.io.Serializable;

public class ApplicationVo implements Serializable {
    private static final long serialVersionUID = 48L;

    private long id;
    private String employee;
    private String unAttend;
    private String toAttend;
    private String reason;

    //无参构造器
    public ApplicationVo() {

    }

    //初始化全部成员变量的构造器
    public ApplicationVo(long id, String employee, String unAttend,
                         String toAttend, String reason) {
        this.id = id;
        this.employee = employee;
        this.unAttend = unAttend;
        this.toAttend = toAttend;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getUnAttend() {
        return unAttend;
    }

    public void setUnAttend(String unAttend) {
        this.unAttend = unAttend;
    }

    public String getToAttend() {
        return toAttend;
    }

    public void setToAttend(String toAttend) {
        this.toAttend = toAttend;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ApplicationVo{" +
                "id=" + id +
                ", employee='" + employee + '\'' +
                ", unAttend='" + unAttend + '\'' +
                ", toAttend='" + toAttend + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
