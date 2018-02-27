package com.kevin.HRSystem.model;

public class AttendType {
    private long id;
    private double amerceAmount;
    private String typeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmerceAmount() {
        return amerceAmount;
    }

    public void setAmerceAmount(double amerceAmount) {
        this.amerceAmount = amerceAmount;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
