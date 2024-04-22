package entity;

import java.util.Objects;

import static java.lang.Math.pow;

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
        } else if (age < 18) {
            if (Objects.equals(sex, this.SEX_FEMALE)) {
                this.bmr = 12.2 * weight + 746;
            } else {
                this.bmr = 17.5 * weight + 651;
            }
        } else if (age < 30)  {
            if (Objects.equals(sex, this.SEX_FEMALE)) {
                this.bmr = 14.7 * weight + 496;
            } else {
                this.bmr = 15.3 * weight + 679;
            }
        } else if (age < 60)  {
            if (Objects.equals(sex, this.SEX_FEMALE)) {
                this.bmr = 8.7 * weight + 829;
            } else {
                this.bmr = 8.7 * weight + 879;
            }
        } else if (age > 60)  {
            if (Objects.equals(sex, this.SEX_FEMALE)) {
                this.bmr = 10.5 * weight + 596;
            } else {
                this.bmr = 13.5 * weight + 487 ;
            }
        }

        return bmr * activityFactor;
    }
}
