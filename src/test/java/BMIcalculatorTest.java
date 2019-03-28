import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class BMIcalculatorTest {

    @Test
    @Parameters({"60, 160, BMI: 23.44", "100, 170, BMI: 34.6","60, 200, BMI: 15.0", "120, 200, BMI: 30.0" })
    public void calculateTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
       Assert.assertEquals(expectedResult, BMIResult);
    }

    @Test
    @Parameters({"60, 160, You're normal", "100, 170, You're obese Class I", "60, 200,You're very severely underweight",
            "120, 200, You're overweight"})
    public void interpretTest(int weight, int height, String expectedResult){
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.interpret();
        Assert.assertEquals(expectedResult,BMIResult);
    }

    @Ignore
    @Test
    @Parameters({"0, 160","40, 0", "0, 0" })
    public void zeroCalculateExceptionTest(int weight, int height) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        calculator.calculate();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate());
    }

    @Ignore
    @Test
    @Parameters({"-10, 160","40, -10", "-110, -60" })
    public void negativeCalculateExceptionTest(int weight, int height) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        calculator.calculate();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate());
    }

    @Ignore
    @Test
    @Parameters({"400, 160","40, 300", "340, 500" })
    public void overlimitCalculateExceptionTest(int weight, int height) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        calculator.calculate();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate());
    }


}
