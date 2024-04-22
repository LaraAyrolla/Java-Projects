package tests;

import entity.EnergyExpenditureOperations;
import org.junit.Assert;
import org.junit.Test;

public class EnergyExpenditureTests {
    EnergyExpenditureOperations energyExpenditure = new EnergyExpenditureOperations();

    @Test(expected = Exception.class)
    public void shouldCorrectlyThrowExceptionForNotSupportedAges() throws Exception {
        energyExpenditure.calculateTdee(5, energyExpenditure.SEX_FEMALE, 0, 0);
    }

    @Test
    public void shouldCorrectlyCalculateTdee() throws Exception {
        Assert.assertEquals(
                2400,
                energyExpenditure.calculateTdee(15, energyExpenditure.SEX_FEMALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2814,
                energyExpenditure.calculateTdee(15, energyExpenditure.SEX_MALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2287.5,
                energyExpenditure.calculateTdee(25, energyExpenditure.SEX_FEMALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2625,
                energyExpenditure.calculateTdee(25, energyExpenditure.SEX_MALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2157,
                energyExpenditure.calculateTdee(50, energyExpenditure.SEX_FEMALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2232,
                energyExpenditure.calculateTdee(50, energyExpenditure.SEX_MALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                1996.5,
                energyExpenditure.calculateTdee(65, energyExpenditure.SEX_FEMALE, 70, 1.5),
                0.1
        );

        Assert.assertEquals(
                2148,
                energyExpenditure.calculateTdee(65, energyExpenditure.SEX_MALE, 70, 1.5),
                0.1
        );
        energyExpenditure.calculateTdee(60, energyExpenditure.SEX_FEMALE, 70, 1.5);
        energyExpenditure.calculateTdee(60, energyExpenditure.SEX_MALE, 70, 1.5);
    }
}
