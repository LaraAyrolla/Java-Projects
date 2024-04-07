package entity;

import java.util.Date;

public class Manager extends Employee {
    public double bonus;

    public Manager (int registrationNumber, Date admission, double hourlySalary) {
        super(registrationNumber, admission, hourlySalary);
    }

    public double calculateBonus (double commission)
    {
        if (commission > 1000) {
            this.bonus = 5000;
        } else {
            this.bonus = commission;
        }

        return this.bonus;
    }
}
