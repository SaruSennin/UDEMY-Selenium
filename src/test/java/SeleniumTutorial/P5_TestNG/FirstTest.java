package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void checkFirstMethodFirstClassTest() {
        System.out.println("First method in First Class test");
    }

    @Test
    public void checkSecondMethodFirstClassTest() {
        System.out.println("Second method in First Class test");
    }

    @Test @Ignore
    public void checkThirdMethodFirstClassTest() {
        System.out.println("Third method in First Class test");
    }
}
