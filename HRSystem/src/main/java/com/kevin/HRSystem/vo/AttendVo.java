package com.kevin.HRSystem.vo;

import java.io.Serializable;
import java.util.Date;

public class AttendVo implements Serializable {
    private static final long serialVersionUID = 48L;

    private long id;
    private String dutyDay;
    private String unType;
    private Date time;

    public AttendVo() {
    }

    public AttendVo(long id, String dutyDay, String unType, Date time) {
        this.id = id;
        this.dutyDay = dutyDay;
        this.unType = unType;
        this.time = time;
    }

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

    public String getUnType() {
        return unType;
    }

    public void setUnType(String unType) {
        this.unType = unType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
