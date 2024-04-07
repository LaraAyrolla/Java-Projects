package tests;

import entity.Manager;
import entity.Seller;
import org.junit.*;

import java.util.Date;

public class EmployeeTests {
    Seller sellerOne = new Seller(1, new Date(), 20);
    Seller sellerTwo = new Seller(2, new Date(), 20);
    Seller sellerThree = new Seller(3, new Date(), 20);
    Manager manager = new Manager(4, new Date(), 30);

    @Test
    public void shouldCorrectlyCalculateManagerBonus ()
    {
        sellerOne.calculateCommission(210);
        sellerTwo.calculateCommission(1100);
        sellerThree.calculateCommission(2010);

        double commissionSum = sellerOne.commission + sellerTwo.commission + sellerThree.commission;

        Assert.assertEquals(664, manager.calculateBonus(commissionSum), 0);
        Assert.assertEquals(5000, manager.calculateBonus(commissionSum*2), 0);
    }

    @Test
    public void shouldCorrectlyCalculateSellerCommission ()
    {
        Assert.assertEquals(40, sellerOne.calculateCommission(200), 0);
        Assert.assertEquals(200, sellerTwo.calculateCommission(1000), 0);
        Assert.assertEquals(2, sellerThree.calculateCommission(10), 0);

        Assert.assertEquals(2, sellerOne.calculateCommission(10), 0);
        Assert.assertEquals(20, sellerTwo.calculateCommission(100), 0);
        Assert.assertEquals(400, sellerThree.calculateCommission(2000), 0);

        Assert.assertEquals(42, sellerOne.commission, 0);
        Assert.assertEquals(220, sellerTwo.commission, 0);
        Assert.assertEquals(402, sellerThree.commission, 0);
    }

    @Test
    public void shouldCorrectlyCalculateSellerOvertime ()
    {
        Assert.assertEquals(2000, sellerOne.calculateOvertime(100), 0);
        Assert.assertEquals(400, sellerTwo.calculateOvertime(20), 0);
        Assert.assertEquals(200, sellerThree.calculateOvertime(10), 0);

        Assert.assertEquals(2000, sellerOne.calculateOvertime(100), 0);
        Assert.assertEquals(400, sellerTwo.calculateOvertime(20), 0);
        Assert.assertEquals(200, sellerThree.calculateOvertime(10), 0);

        Assert.assertEquals(4000, sellerOne.overtime, 0);
        Assert.assertEquals(800, sellerTwo.overtime, 0);
        Assert.assertEquals(400, sellerThree.overtime, 0);
    }

    @Test
    public void shouldCorrectlyCalculateSellerNightShiftBonus ()
    {
        Assert.assertEquals(400, sellerOne.calculateNightShiftBonus(100), 0);
        Assert.assertEquals(80, sellerTwo.calculateNightShiftBonus(20), 0);
        Assert.assertEquals(40, sellerThree.calculateNightShiftBonus(10), 0);

        Assert.assertEquals(400, sellerOne.calculateNightShiftBonus(100), 0);
        Assert.assertEquals(80, sellerTwo.calculateNightShiftBonus(20), 0);
        Assert.assertEquals(40, sellerThree.calculateNightShiftBonus(10), 0);

        Assert.assertEquals(800, sellerOne.nightShiftBonus, 0);
        Assert.assertEquals(160, sellerTwo.nightShiftBonus, 0);
        Assert.assertEquals(80, sellerThree.nightShiftBonus, 0);
    }

    @Test
    public void shouldCorrectlyAnalyzeSellerOfTheMonth ()
    {
        double biggestCommission = 402;

        sellerOne.calculateCommission(2000);
        sellerTwo.calculateCommission(biggestCommission*5);
        sellerThree.calculateCommission(1200);

        Assert.assertEquals(
                sellerOne.NOT_SELLER_OF_THE_MONTH,
                sellerOne.sellerOfTheMonth(biggestCommission)
        );

        Assert.assertEquals(
                sellerTwo.SELLER_OF_THE_MONTH,
                sellerTwo.sellerOfTheMonth(biggestCommission)
        );

        Assert.assertEquals(
                sellerThree.NOT_SELLER_OF_THE_MONTH,
                sellerThree.sellerOfTheMonth(biggestCommission)
        );
    }
}
