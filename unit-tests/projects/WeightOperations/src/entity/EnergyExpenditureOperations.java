package entity;

import java.util.Objects;

public class EnergyExpenditureOperations extends WeightOperations {
    public double bmr;

    public double calculateTdee(
            int age,
            String sex,
            double weight,
            double activityFactor
    ) throws Exception {
        if (age < 10) {
            throw new Exception(this.EXCEPTION_NOT_SUPPORTED_AGE);
        }

        double bmr;
        if (Objects.equals(sex, this.SEX_FEMALE)) {
            if (age < 18) {
                bmr = 12.2 * weight + 746;
            } else if (age < 30) {
                bmr = 14.7 * weight + 496;
            } else if (age < 60) {
                bmr = 8.7 * weight + 829;
            } else {
                bmr = 10.5 * weight + 596;
            }
        } else {
            if (age < 18) {
                bmr = 17.5 * weight + 651;
            } else if (age < 30)  {
                bmr = 15.3 * weight + 679;
            } else if (age < 60)  {
                bmr = 8.7 * weight + 879;
            } else {
                bmr = 13.5 * weight + 487 ;
            }
        }

        this.bmr = bmr;

        return this.bmr * activityFactor;
    }
}
