package entity;

import java.util.Objects;

import static java.lang.Math.pow;

public class IdealWeightOperations extends WeightOperations {
    public final String SITUATION_UNDERWEIGHT = "Underweight";
    public final String SITUATION_NORMAL_WEIGHT = "Normal weight";
    public final String SITUATION_OVERWEIGHT = "Overweight";
    public final String SITUATION_OBESE = "Obese";
    public final String SITUATION_MORBIDLY_OBESE = "Morbidly obese";

    public double bmi;
    public double idealBmi;

    public String classifyWeightAccordingToBmi(double weight, double height) {
        this.bmi = weight / pow(height, 2);

        if (this.bmi < 20) {
            return this.SITUATION_UNDERWEIGHT;
        }

        if (this.bmi < 25) {
            return this.SITUATION_NORMAL_WEIGHT;
        }

        if (bmi < 30) {
            return this.SITUATION_OVERWEIGHT;
        }

        if (bmi < 40) {
            return this.SITUATION_OBESE;
        }

        return this.SITUATION_MORBIDLY_OBESE;
    }

    public double calculateIdealWeight(int age, String sex, double height) throws Exception {
        if (age < 3 || (age > 10 && age < 18)) {
            throw new Exception(this.EXCEPTION_NOT_SUPPORTED_AGE);
        }

        if (age <= 10) {
            return age * 2 + 9;
        }

        if (Objects.equals(sex, this.SEX_FEMALE)) {
            if (age <= 64) {
                this.idealBmi = 21;
            } else if (age <= 69) {
                    this.idealBmi = 26.5;
            } else if (age <= 74) {
                this.idealBmi = 26.3;
            } else if (age <= 79) {
                this.idealBmi = 26.1;
            } else if (age <= 84) {
                this.idealBmi = 25.5;
            } else {
                this.idealBmi = 23.6;
            }
        } else {
            if (age <= 64) {
                this.idealBmi = 22;
            } else if (age <= 69) {
                    this.idealBmi = 24.3;
            } else if (age <= 74) {
                this.idealBmi = 25.1;
            } else if (age <= 79) {
                this.idealBmi = 23.9;
            } else if (age <= 84) {
                this.idealBmi = 23.7;
            } else {
                this.idealBmi = 23.1;
            }
        }

        return this.idealBmi * (pow(height, 2));
    }
}
