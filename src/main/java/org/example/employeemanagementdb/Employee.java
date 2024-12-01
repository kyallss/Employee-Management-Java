package org.example.employeemanagementdb;

import java.util.Date;

public abstract class Employee {
    private int id;
    private String name;
    private String type;
    private Date hireDate;

    public Employee(int id, String name, String type, Date hireDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hireDate = hireDate;
    }

    public Employee(String name, String type, Date hireDate) {
        this.name = name;
        this.type = type;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public abstract double calculateSalary();

    public double getSalary() {
        return calculateSalary();
    }
}
