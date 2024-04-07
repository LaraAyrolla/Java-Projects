package entity;

import java.util.Date;

public class Manager extends Employee {
    double bonus;

    Manager(int registrationNumber, Date admission) {
        super(registrationNumber, admission);
    }

    public double calculateBonus (double commission)
    {
        if (commission > 1000) {
            this.bonus = 5000;
        } else {
            this.bonus = 0;
        }

        return this.bonus;
    }
}
