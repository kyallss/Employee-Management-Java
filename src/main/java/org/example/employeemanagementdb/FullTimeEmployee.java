package org.example.employeemanagementdb;

import java.util.Date;

public class FullTimeEmployee extends Employee {
    private static final double ANNUAL_SALARY = 50000;

    public FullTimeEmployee(String name, Date hireDate) {
        super(name, "Full-time", hireDate);
    }

    public FullTimeEmployee(int id, String name, Date hireDate) {
        super(id, name, "Full-time", hireDate);
    }

    @Override
    public double calculateSalary() {
        return ANNUAL_SALARY / 12;
    }
}
