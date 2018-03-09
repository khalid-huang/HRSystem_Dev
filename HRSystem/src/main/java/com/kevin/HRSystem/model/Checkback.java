package com.kevin.HRSystem.model;

public class Checkback {
    private long id;
    private Application application;
    private boolean checkResult;
//    private String checkReason;
    private Manager manager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public boolean isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

//    public String getCheckReason() {
//        return checkReason;
//    }

//    public void setCheckReason(String checkReason) {
//        this.checkReason = checkReason;
//    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Checkback{" +
                "id=" + id +
                ", application=" + application +
                ", checkResult=" + checkResult +
                ", manager=" + manager +
                '}';
    }
}
