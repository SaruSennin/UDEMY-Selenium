package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.Test;

public class DependMethodTest {

    @Test (dependsOnMethods = {"checkThirdTest"})
    public void checkFirstTest() {
        System.out.println("I'm first test");
    }

    @Test (dependsOnMethods = {"checkFirstTest"})
    public void checkSecondTest() {
        System.out.println("I'm second test");
    }

    @Test (priority = 0)
    public void checkThirdTest() {
        System.out.println("I'm third test");
    }
}
