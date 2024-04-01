package tests;

import entity.Temperature;
import org.junit.*;

public class TemperatureTests {
    Temperature temperature = new Temperature();

    @Test
    public void shouldConvertCelsiusToFahrenheit ()
    {
        Assert.assertEquals(
                23,
                temperature.convertCelsiusToFahrenheit(-5),
                0
        );

        Assert.assertEquals(
                32,
                temperature.convertCelsiusToFahrenheit(0),
                0
        );

        Assert.assertEquals(
                64.4,
                temperature.convertCelsiusToFahrenheit(18),
                0
        );
    }

    @Test
    public void shouldConvertCelsiusToKelvin ()
    {
        Assert.assertEquals(
                268.15,
                temperature.convertCelsiusToKelvin(-5),
                0
        );

        Assert.assertEquals(
                273.15,
                temperature.convertCelsiusToKelvin(0),
                0
        );

        Assert.assertEquals(
                291.15,
                temperature.convertCelsiusToKelvin(18),
                0
        );
    }

    @Test
    public void shouldClassifyTemperature ()
    {
        Assert.assertTrue(
                temperature.classify(-5)
                        .equals(
                            temperature.NEGATIVE_TEMPERATURE
                        )
        );

        Assert.assertTrue(
                temperature.classify(0)
                        .equals(
                            temperature.ZERO_TEMPERATURE
                        )
        );

        Assert.assertTrue(
                temperature.classify(18)
                        .equals(
                            temperature.POSITIVE_TEMPERATURE
                        )
        );
    }

    @Test
    public void shouldVerifyCelsiusToFahrenheitConversion ()
    {
        Assert.assertTrue(
                temperature.verifyCelsiusToFahrenheitConversion(
                        -5,
                        23
                )
        );
    }
}
