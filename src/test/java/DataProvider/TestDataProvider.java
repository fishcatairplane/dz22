package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    @DataProvider(name = "positiveManAge")
    public static Object[][] positiveManAgeDataProvider() {
        return new Object[][]{
                {30}, {40}, {55}, {64}
        };
    }

    @DataProvider(name = "positiveWomanAge")
    public static Object[][] positiveWomanAgeDataProvider() {
        return new Object[][]{
                {20}, {35}, {50}, {59}
        };
    }

    @DataProvider(name = "negativeAge")
    public static Object[][] negativeAgeDataProvider() {
        return new Object[][]{
                {65}, {70}, {80}
        };
    }
    @Test(dataProvider = "positiveManAge")
    public void testPositiveManAge(int age) {
    }

    @Test(dataProvider = "positiveWomanAge")
    public void testPositiveWomanAge(int age) {
    }

    @Test(dataProvider = "negativeAge")
    public void testNegativeAge(int age) {
    }
}
