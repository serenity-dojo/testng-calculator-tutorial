package serenitydojo.testng.calculator;

import com.serenitydojo.calculator.Calculator;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {

    Calculator calculator;

    @Parameters({"locale"})
    @BeforeMethod(alwaysRun = true)
    void setupCalculator(String locale) {
        System.out.println("USING LOCALE " + locale);
        calculator = new Calculator(Locale.forLanguageTag(locale));
    }

    @Test
    void testLocale() {
        assertThat(calculator.add(1,2)).isEqualTo(3);
    }

    @DataProvider(name = "simple_additions")
    public Object[][] simpleAdditions() {
        return new Object[][] {
                {1,2,3},
                {1,3,4},
                {2,0,2},
                {10, -3, 7}
        };
    }

    @DataProvider(name = "additionsCSV", parallel = true)
    public Object[][] additionsCSVs() {
        List<Object[]> records = new ArrayList<>();

        String line;
        URL csvResource = getClass().getClassLoader().getResource("additions.csv");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvResource.openStream()))) {
            while((line = reader.readLine()) != null) {
                String[] values =line.split(",");
                Integer[] intValues = new Integer[4];
                for(int i = 0; i < 4; i++) {
                    intValues[i] = Integer.parseInt(values[i].trim());
                }
                records.add(intValues);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records.toArray(new Object[][]{});
    }

    @Test(dataProvider = "simple_additions")
    void shouldAddTwoNumber(int a, int b, int result) {
        System.out.println("CALCULATING " + a + " + " + b);
        assertThat(calculator.add(a,b)).isEqualTo(result);
    }

    @Test(dataProvider = "additionsCSV")
    void shouldAddTheeeNumber(int a, int b, int c, int result) {
        System.out.println("CALCULATING " + a + " + " + b + " + " + c);
        assertThat(calculator.add(a,b,c)).isEqualTo(result);
    }

}
