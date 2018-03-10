package com.kevin.HRSystem.model;

public class Application {
    private long id;
    private Attend attend; //相关联的出勤记录(需要申请改变的出勤记录，比如事假)
    private String applicationReason;
    private boolean applicationResult;
    private AttendType attendType; //需要申请得到的出勤记录（需要得到的记录，比如从上面的事假到正常）

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Attend getAttend() {
        return attend;
    }

    public void setAttend(Attend attend) {
        this.attend = attend;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public boolean isApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(boolean applicationResult) {
        this.applicationResult = applicationResult;
    }


    public AttendType getAttendType() {
        return attendType;
    }

    public void setAttendType(AttendType attendType) {
        this.attendType = attendType;
    }

    @Override
    public String toString() {
        return "Application [id=" + this.id + ", attendID =" + this.attend.getId() + ", app_reason="  + this.applicationReason + ", app_result=" + this.applicationResult + " , typeId= " + this.attendType.getId()  + "]";
    }
}
