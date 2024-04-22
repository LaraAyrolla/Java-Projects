package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.EnergyExpenditureTests;
import tests.IdealWeightTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        IdealWeightTests.class,
        EnergyExpenditureTests.class
})

public class TestsSuite {
}
