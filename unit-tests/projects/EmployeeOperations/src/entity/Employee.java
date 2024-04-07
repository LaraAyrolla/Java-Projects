package entity;

import java.util.Date;

public class Employee {
    public int registration;
    public Date admissionDate;
    public double hourlyWage;

    Employee (int registrationNumber, Date admission, double hourlySalary)
    {
        this.registration = registrationNumber;
        this.admissionDate = admission;
        this.hourlyWage = hourlySalary;
    }
}
