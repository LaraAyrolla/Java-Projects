package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BookTest.class,
        LibraryTest.class,
        MainTest.class
})

public class TestSuite {
}