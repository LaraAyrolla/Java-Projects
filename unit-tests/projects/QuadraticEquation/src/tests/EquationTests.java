package tests;

import entity.QuadraticEquation;
import org.junit.Assert;
import org.junit.Test;

public class EquationTests {
    QuadraticEquation quadraticEquation;

    @Test
    public void shouldCorrectlyConfirmZeroEquality ()
    {
        quadraticEquation = new QuadraticEquation(0, 0, 0);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_EQUALITY_CONFIRMED,
                quadraticEquation.message
        );
    }

    @Test
    public void shouldCorrectlyIdentifyIncorrectCoefficients ()
    {
        quadraticEquation = new QuadraticEquation(0, 0, 8);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_INCORRECT_COEFFICIENTS,
                quadraticEquation.message
        );
    }

    @Test
    public void shouldCorrectlyIdentifyAndCalculateLinearEquation ()
    {
        quadraticEquation = new QuadraticEquation(0, 2, -8);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_LINEAR_EQUATION,
                quadraticEquation.message
        );

        Assert.assertEquals(4, quadraticEquation.realRootOne, 0);
        Assert.assertEquals(4, quadraticEquation.realRootTwo, 0);
    }

    @Test
    public void shouldCorrectlyIdentifyQuadraticEquationWithNoRealRoots ()
    {
        quadraticEquation = new QuadraticEquation(10, -4, 12);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_NO_REAL_ROOTS,
                quadraticEquation.message
        );
    }

    @Test
    public void shouldCorrectlyIdentifyAndCalculateEquationWithEqualRealRoots ()
    {
        quadraticEquation = new QuadraticEquation(4, -4, 1);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_TWO_EQUAL_REAL_ROOTS,
                quadraticEquation.message
        );

        Assert.assertEquals(0.5, quadraticEquation.realRootOne, 0);
        Assert.assertEquals(0.5, quadraticEquation.realRootTwo, 0);
    }

    @Test
    public void shouldCorrectlyIdentifyAndCalculateEquationWithDifferentRealRoots ()
    {
        quadraticEquation = new QuadraticEquation(1, 6, 7);
        quadraticEquation.verifyQuadraticEquationAndCalculateRealRoots();

        Assert.assertEquals(
                quadraticEquation.MESSAGE_TWO_DIFFERENT_REAL_ROOTS,
                quadraticEquation.message
        );

        Assert.assertEquals(-1.58, quadraticEquation.realRootOne, 0.1);
        Assert.assertEquals(-4.4, quadraticEquation.realRootTwo, 0.1);
    }
}
