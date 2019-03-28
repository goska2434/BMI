import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class BMIcalculatorTest {

    @Test
    @Parameters({"60, 160, BMI: 23.44", "100, 170, BMI: 34.6","60, 200, BMI: 15.0", "120, 200, BMI: 30.0" })
    public void calculateTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
       assertEquals(expectedResult, BMIResult);
    }

    @Test
    @Parameters({"60, 160, You're normal", "100, 170, You're obese Class I", "60, 200,You're very severely underweight",
            "120, 200, You're overweight"})
    public void interpretTest(int weight, int height, String expectedResult){
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.interpret();
        assertEquals(expectedResult,BMIResult);
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters({"0, 160, Put greater than 0 value","40, 0, Put greater than 0 value", "0, 0, Put greater than 0 value" })
    public void zeroCalculateExceptionTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
        assertEquals(expectedResult,BMIResult);

    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters({"-10, 160, Put greater than 0 value","40, -10, Put greater than 0 value",
            "-110, -60, Put greater than 0 value" })
    public void negativeValueCalculateExceptionTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
       assertEquals(expectedResult,BMIResult);
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters({"400, 160, Limit is 300kg","40, 300, Limit is 250cm", "340, 500, Limit is 300kg" })
    public void overLimitCalculateExceptionTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
       assertEquals(expectedResult,BMIResult);
    }


}
