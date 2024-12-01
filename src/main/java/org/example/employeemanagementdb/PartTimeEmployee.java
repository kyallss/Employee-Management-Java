package org.example.employeemanagementdb;

import java.util.Date;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked, Date hireDate) {
        super(name, "Part-time", hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked, Date hireDate) {
        super(id, name, "Part-time", hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
