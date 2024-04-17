package entity;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public final String MESSAGE_INCORRECT_COEFFICIENTS = "Incorrectly informed coefficients";
    public final String MESSAGE_EQUALITY_CONFIRMED = "Equality confirmed: 0 = 0";
    public final String MESSAGE_LINEAR_EQUATION = "This is a linear equation";
    public final String MESSAGE_NO_REAL_ROOTS = "This equation has no real roots";
    public final String MESSAGE_TWO_EQUAL_REAL_ROOTS = "This equation has two equal real roots";
    public final String MESSAGE_TWO_DIFFERENT_REAL_ROOTS = "This equation has two different real roots";

    public double coefficientA;
    public double coefficientB;
    public double coefficientC;
    public double discriminant;
    public double realRootOne;
    public double realRootTwo;
    public boolean isQuadraticEquation;
    public String message;

    public QuadraticEquation(double a, double b, double c)
    {
        this.coefficientA = a;
        this.coefficientB = b;
        this.coefficientC = c;
        this.discriminant = pow(this.coefficientB,2) - (4*this.coefficientA*this.coefficientC);
        this.message = "";
    }

    public void verifyQuadraticEquationAndCalculateRealRoots() {
        this.isQuadraticEquation = this.isQuadraticEquation();

        if (!this.isQuadraticEquation) {
            return;
        }

        if (this.discriminant < 0) {
            this.message = this.MESSAGE_NO_REAL_ROOTS;
            System.out.println(this.message);
        } else {
            if (this.discriminant == 0) {
                this.message = this.MESSAGE_TWO_EQUAL_REAL_ROOTS;
                System.out.println(this.message);
            } else if (this.discriminant > 0) {
                this.message = this.MESSAGE_TWO_DIFFERENT_REAL_ROOTS;
                System.out.println(this.message);
            }
            this.calculateQuadraticEquationRealRoots();
            System.out.println(STR."Real roots: \{this.realRootOne} and \{this.realRootTwo}");
        }
    }

    private boolean isQuadraticEquation() {
        if (this.coefficientA == 0) {
            if (this.coefficientB == 0) {
                if (this.coefficientC != 0) {
                    this.message = this.MESSAGE_INCORRECT_COEFFICIENTS;
                } else {
                    this.message = this.MESSAGE_EQUALITY_CONFIRMED;
                }
                System.out.println(this.message);
            } else {
                this.message = this.MESSAGE_LINEAR_EQUATION;
                System.out.println(this.message);
                this.calculateLinearEquationRealRoot();
                System.out.println(STR."Real root: \{this.realRootOne}");
            }
            return false;
        } else {
            return true;
        }
    }

    private void calculateQuadraticEquationRealRoots ()
    {
        this.realRootOne = (this.coefficientB*-1 + sqrt(this.discriminant)) / (2*this.coefficientA);
        this.realRootTwo = (this.coefficientB*-1 - sqrt(this.discriminant)) / (2*this.coefficientA);
    }

    private void calculateLinearEquationRealRoot ()
    {
        this.realRootOne = this.realRootTwo = (this.coefficientC*-1) / this.coefficientB;
    }
}
