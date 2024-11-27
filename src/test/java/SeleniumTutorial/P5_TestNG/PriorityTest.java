package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test (priority = 2)
    public void checkFirstTest() {
        System.out.println("I'm first test");
    }

    @Test (priority = 1)
    public void checkSecondTest() {
        System.out.println("I'm second test");
    }

    @Test (priority = 0)
    public void checkThirdTest() {
        System.out.println("I'm third test");
    }
}
