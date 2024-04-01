package entity;

public class Temperature {
    public final String ZERO_TEMPERATURE = "ZERO";
    public final String POSITIVE_TEMPERATURE = "POSITIVE";
    public final String NEGATIVE_TEMPERATURE = "NEGATIVE";

    public double convertCelsiusToFahrenheit (double celsiusValue)
    {
        return (celsiusValue * 9/5) + 32;
    }

    public double convertCelsiusToKelvin (double celsiusValue)
    {
        return celsiusValue + + 273.15;
    }

    public String classify (double temperature)
    {
        if (temperature == 0) {
            return ZERO_TEMPERATURE;
        }

        if (temperature > 0) {
            return POSITIVE_TEMPERATURE;
        }

        return NEGATIVE_TEMPERATURE;
    }

    public boolean verifyCelsiusToFahrenheitConversion (
            double celsiusValue,
            double fahrenheitValue
    ) {
        return fahrenheitValue == convertCelsiusToFahrenheit(celsiusValue);
    }
}
