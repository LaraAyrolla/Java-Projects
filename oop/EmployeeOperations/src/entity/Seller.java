package entity;

import java.util.Date;

public class Seller extends Employee {
    double overtime = 0;
    double commission = 0;
    double nightShiftBonus = 0;

    final String SELLER_OF_THE_MONTH = "Seller of the month!";
    final String NOT_SELLER_OF_THE_MONTH = "Not seller of the month.";

    Seller(int registrationNumber, Date admission) {
        super(registrationNumber, admission);
    }

    public double calculateCommission (double saleValue)
    {
        double partialCommission = hourlyWage * saleValue;

        this.commission += partialCommission;

        return partialCommission;
    }

    public double calculateOvertime (double numberOfHours)
    {
        double partialOvertime = hourlyWage * numberOfHours;

        this.overtime += partialOvertime;

        return partialOvertime;
    }

    public double calculateNightShiftBonus (double numberOfHours)
    {
        double partialNightShiftBonus = hourlyWage * numberOfHours * 0.2;

        this.nightShiftBonus += partialNightShiftBonus;

        return partialNightShiftBonus;
    }

    public String sellerOfTheMonth (double commission)
    {
        if (this.commission >= commission) {
            return SELLER_OF_THE_MONTH;
        }

        return NOT_SELLER_OF_THE_MONTH;
    }
}
