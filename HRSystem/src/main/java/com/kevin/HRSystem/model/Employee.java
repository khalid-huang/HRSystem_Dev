package com.kevin.HRSystem.model;

public class Employee {
    private long id;
    private int type;
    private String name;
    private String password;
    private double salary;
    private Manager manager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        String rsl = "Employee [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", type=" + this.type + ", salary=" + this.salary;
        if(this.manager != null) {
            rsl += ", managerId=" + this.manager.getId() +  ", managerName=" + this.manager.getName() + "]";
        }
        return rsl;
    }
}
