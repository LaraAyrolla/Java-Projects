package tests;

import entity.Operations;

import org.junit.*;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

public class OperationsTest {
    Operations operations = new Operations();

    @Test
    public void shouldVerifyBiggestValue()
    {
        double biggestValue = operations.biggestValue(16, 9);

        Assert.assertEquals(16, biggestValue, 0);
        Assert.assertEquals(17, biggestValue, 1);
        Assert.assertEquals(15, biggestValue, 1);
    }

    @Test
    public void shouldVerifySmallestValue()
    {
        double smallestValue = operations.smallestValue(16, 9);

        Assert.assertFalse(smallestValue == 16);
        Assert.assertTrue(smallestValue == 9);
    }

    @Test
    public void shouldCompareObjects()
    {
        String o1 = "Hello!";
        String o2 = "Hello!";
        String o3 = "Hello.";

        Assert.assertSame(o1, o2);
        Assert.assertNotSame(o1, o3);
    }

    @Test
    public void shouldVerifySquareRoot()
    {
        Assert.assertEquals(
                9.380,
                operations.squareRoot(88),
                0.00083151964686
        );
    }

    @Test
    public void shouldVerifyDivision()
    {
        Assert.assertEquals(25, operations.divide(50, 2), 0);
        Assert.assertEquals(POSITIVE_INFINITY, operations.divide(50, 0), 0);
        Assert.assertEquals(NaN, operations.divide(0, 0), 0);
    }

    @Test
    public void shouldVerifyProduct()
    {
        Assert.assertEquals(
                1.0E12,
                operations.multiply(1000000, 1000000),
                0
        );
    }

    @Test
    public void shouldVerifySum()
    {
        double sum = operations.sum(10, 10);

        Assert.assertEquals(20, sum, 0);
        Assert.assertFalse(sum == 21);
        Assert.assertTrue(sum == 20);
    }
}