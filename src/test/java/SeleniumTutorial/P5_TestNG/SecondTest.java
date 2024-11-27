package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    @Test
    public void checkFirstMethodSecondClassTest() {
        System.out.println("First method in Second Class test");
    }

    @Test
    public void checkSecondMethodSecondClassTest() {
        System.out.println("Second method in Second Class test");
    }
}
