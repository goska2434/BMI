import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)

public class BMIcalculatorTest {

    @Test
    @Parameters({"60, 160, Your BMI index is: 23.437499999999996", "100, 170, Your BMI index is: 34.602076124567475"})
    public void calculateTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
       assertEquals(expectedResult, BMIResult);
    }

    @Test
    @Parameters({"0, 160, Your BMI index is: 0.0"})
    public void zeroweightCalculateTest(int weight, int height, String expectedResult) {
        BMIcalculator calculator = new BMIcalculator(weight, height);
        String BMIResult = calculator.calculate();
        assertEquals(expectedResult, BMIResult);
    }







}
