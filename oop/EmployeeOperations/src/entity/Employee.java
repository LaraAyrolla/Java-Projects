package entity;

import java.util.Date;

public class Employee {
    int registration;
    Date admissionDate;
    double hourlyWage;

    Employee (int registrationNumber, Date admission)
    {
        this.registration = registrationNumber;
        this.admissionDate = admission;
    }
}
