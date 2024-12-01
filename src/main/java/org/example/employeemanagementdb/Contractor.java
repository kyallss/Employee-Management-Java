package org.example.employeemanagementdb;

import java.util.Date;

public class Contractor extends Employee {
    private double hourlyRate;
    private int maxHours;

    public Contractor(String name, double hourlyRate, int maxHours, Date hireDate) {
        super(name, "Contractor", hireDate);
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    public Contractor(int id, String name, double hourlyRate, int maxHours, Date hireDate) {
        super(id, name, "Contractor", hireDate);
        this.hourlyRate = hourlyRate;
        this.maxHours = maxHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * maxHours;
    }
}
