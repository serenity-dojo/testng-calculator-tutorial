package serenitydojo.testng.calculator;

import com.serenitydojo.calculator.Calculator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionTest {
    @Test(groups = {"subtraction"})
    void shouldSubtractToNumbers() {
        Calculator calculator = new Calculator();

        int result = calculator.subtract(10,4);

        assertThat(result).isEqualTo(6);
    }
}
