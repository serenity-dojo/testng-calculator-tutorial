package serenitydojo.testng.calculator;

import com.serenitydojo.calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {

    Calculator calculator;

    @BeforeMethod( alwaysRun = true )
    void setupCalculator() {
        calculator = new Calculator();
        System.out.println("SETTING UP THE CALCULATOR");
    }

    Calculator calc4;

    @BeforeMethod
    void setupCalc4() {
        calc4 = new Calculator();
        System.out.println("SETTING UP CALC 4");
    }

    @Test
    void shouldAddFourNumbers() {
        System.out.println("ADDING 4 NUMBERS");

        int sum = calc4.add(1,2,3,4);

        assertThat(sum).isEqualTo(10);
    }

    @Test(groups = {"addition"})
    void shouldAddTwoNumbers() {
        System.out.println("ADDING 2 NUMBERS");

        int sum = calculator.add(1,2);

        assertThat(sum).isEqualTo(3);
    }

    @Test(groups = {"addition"})
    void shouldAddThreeNumbers() {
        System.out.println("ADDING 3 NUMBERS");

        int sum = calculator.add(1,2,3);

        assertThat(sum).isEqualTo(6);
    }

}
