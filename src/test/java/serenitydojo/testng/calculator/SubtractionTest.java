package serenitydojo.testng.calculator;

import com.serenitydojo.calculator.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionTest {
    Calculator calculator;

    @Parameters({"locale"})
    @BeforeMethod(alwaysRun = true)
    void setupCalculator(String locale) {
        System.out.println("USING LOCALE " + locale);
        calculator = new Calculator(Locale.forLanguageTag(locale));
    }

    @Test(groups = {"subtraction"})
    void shouldSubtractToNumbers() {
        int result = calculator.subtract(10,4);

        assertThat(result).isEqualTo(6);
    }
}
