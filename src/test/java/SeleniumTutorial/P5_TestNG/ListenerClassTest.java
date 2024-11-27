package SeleniumTutorial.P5_TestNG;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = { SampleTestListener.class })
public class ListenerClassTest{

    @Test
    public void checkFirstMethodFirstClassTest() {
        Assert.assertTrue(true);
    }

    @Test
    public void checkSecondMethodFirstClassTest() {
//        Assert.assertFalse(true); // wymuszony błąd tylko do celów poglądowych
    }

    @Test @Ignore
    public void checkThirdMethodFirstClassTest() {
        System.out.println("Third method in First Class test");
    }
}
