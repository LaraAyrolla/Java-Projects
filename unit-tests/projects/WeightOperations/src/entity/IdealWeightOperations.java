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

        if (Objects.equals(sex, SEX_FEMALE)) {
            idealBmi = this.defineFemaleIdealBmi(age);
        } else {
            idealBmi = this.defineMaleIdealBmi(age);
        }

        return this.idealBmi * (pow(height, 2));
    }

    private double defineFemaleIdealBmi(int age) {
        if (age <= 64) return 21;
        if (age <= 69) return 26.5;
        if (age <= 74) return 26.3;
        if (age <= 79) return 26.1;
        if (age <= 84) return 25.5;
        return 23.6;
    }

    private double defineMaleIdealBmi(int age) {
        if (age <= 64) return 22;
        if (age <= 69) return 24.3;
        if (age <= 74) return 25.1;
        if (age <= 79) return 23.9;
        if (age <= 84) return 23.7;
        return 23.1;
    }
}
