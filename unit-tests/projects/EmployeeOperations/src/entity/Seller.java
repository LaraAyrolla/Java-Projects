package entity;

import java.util.Date;

public class Seller extends Employee {
    public double overtime = 0;
    public double commission = 0;
    public double nightShiftBonus = 0;

    public final String SELLER_OF_THE_MONTH = "Seller of the month!";
    public final String NOT_SELLER_OF_THE_MONTH = "Not seller of the month.";

    public Seller (int registrationNumber, Date admission, double hourlySalary) {
        super(registrationNumber, admission, hourlySalary);
    }

    public double calculateCommission (double saleValue)
    {
        double partialCommission = hourlyWage * saleValue * 0.01;

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
