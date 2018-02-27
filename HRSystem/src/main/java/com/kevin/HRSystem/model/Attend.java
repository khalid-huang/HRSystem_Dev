package com.kevin.HRSystem.model;

import java.util.Date;

public class Attend {
    private long id;
    private String dutyDay;
    private Date punchTime;
    private boolean isCome;
    private AttendType attendType;
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDutyDay() {
        return dutyDay;
    }

    public void setDutyDay(String dutyDay) {
        this.dutyDay = dutyDay;
    }

    public Date getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(Date punchTime) {
        this.punchTime = punchTime;
    }

    public boolean isCome() {
        return isCome;
    }

    public void setCome(boolean come) {
        isCome = come;
    }

    public AttendType getAttendType() {
        return attendType;
    }

    public void setAttendType(AttendType attendType) {
        this.attendType = attendType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Attend [id=" + this.getId() + ", duty_day=" + this.getDutyDay() + " , punch_time=" + this.getPunchTime() + ", is_come=" + this.isCome();
    }
}
