package tests;

import entity.IdealWeightOperations;
import org.junit.Assert;
import org.junit.Test;

public class IdealWeightTests {
    IdealWeightOperations idealWeight = new IdealWeightOperations();

    @Test
    public void shouldCorrectlyCalculateAndClassifyUnderweightBmi() {
        Assert.assertEquals(
                idealWeight.SITUATION_UNDERWEIGHT,
                idealWeight.classifyWeightAccordingToBmi(50, 1.68)
        );

        Assert.assertEquals(
                17.7,
                idealWeight.bmi,
                0.1
        );
    }

    @Test
    public void shouldCorrectlyCalculateAndClassifyNormalWeightBmi() {
        Assert.assertEquals(
                idealWeight.SITUATION_NORMAL_WEIGHT,
                idealWeight.classifyWeightAccordingToBmi(65, 1.68)
        );

        Assert.assertEquals(
                23,
                idealWeight.bmi,
                0.1
        );
    }

    @Test
    public void shouldCorrectlyCalculateAndClassifyOverweightBmi() {
        Assert.assertEquals(
                idealWeight.SITUATION_OVERWEIGHT,
                idealWeight.classifyWeightAccordingToBmi(75, 1.68)
        );

        Assert.assertEquals(
                26.6,
                idealWeight.bmi,
                0.1
        );
    }

    @Test
    public void shouldCorrectlyCalculateAndClassifyObeseBmi() {
        Assert.assertEquals(
                idealWeight.SITUATION_OBESE,
                idealWeight.classifyWeightAccordingToBmi(85, 1.68)
        );

        Assert.assertEquals(
                30.1,
                idealWeight.bmi,
                0.1
        );
    }

    @Test
    public void shouldCorrectlyCalculateAndClassifyMorbidlyObeseBmi() {
        Assert.assertEquals(
                idealWeight.SITUATION_MORBIDLY_OBESE,
                idealWeight.classifyWeightAccordingToBmi(115, 1.68)
        );

        Assert.assertEquals(
                40.7,
                idealWeight.bmi,
                0.1
        );
    }

    @Test(expected = Exception.class)
    public void shouldCorrectlyThrowExceptionForNotSupportedAges() throws Exception {
        idealWeight.calculateIdealWeight(2, idealWeight.SEX_FEMALE, 0);
    }

    @Test
    public void shouldCorrectlyCalculateIdealWeightForChildren() throws Exception {
        Assert.assertEquals(
                17,
                idealWeight.calculateIdealWeight(4, idealWeight.SEX_FEMALE, 0),
                0
        );

        Assert.assertEquals(
                17,
                idealWeight.calculateIdealWeight(4, this.idealWeight.SEX_MALE, 0),
                0
        );

        Assert.assertEquals(
                29,
                idealWeight.calculateIdealWeight(10, idealWeight.SEX_FEMALE, 0),
                0
        );

        Assert.assertEquals(
                29,
                idealWeight.calculateIdealWeight(10, this.idealWeight.SEX_MALE, 0),
                0
        );
    }

    @Test
    public void shouldCorrectlyCalculateIdealWeightForAdultsUnder65() throws Exception {
        Assert.assertEquals(
                59.2,
                idealWeight.calculateIdealWeight(22, idealWeight.SEX_FEMALE, 1.68),
                0.1
        );

        Assert.assertEquals(
                62,
                idealWeight.calculateIdealWeight(32, this.idealWeight.SEX_MALE, 1.68),
                0.1
        );

        Assert.assertEquals(
                68,
                idealWeight.calculateIdealWeight(42, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                71.2,
                idealWeight.calculateIdealWeight(62, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );
    }

    @Test
    public void shouldCorrectlyCalculateIdealWeightForAdultsOver65() throws Exception {
        Assert.assertEquals(
                85.8,
                idealWeight.calculateIdealWeight(65, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                78.7,
                idealWeight.calculateIdealWeight(65, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                85.2,
                idealWeight.calculateIdealWeight(70, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                81.3,
                idealWeight.calculateIdealWeight(70, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                84.5,
                idealWeight.calculateIdealWeight(75, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                77.4,
                idealWeight.calculateIdealWeight(75, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                82.6,
                idealWeight.calculateIdealWeight(80, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                76.7,
                idealWeight.calculateIdealWeight(80, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                76.4,
                idealWeight.calculateIdealWeight(85, idealWeight.SEX_FEMALE, 1.8),
                0.1
        );

        Assert.assertEquals(
                74.8,
                idealWeight.calculateIdealWeight(85, this.idealWeight.SEX_MALE, 1.8),
                0.1
        );
    }
}
