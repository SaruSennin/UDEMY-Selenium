package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {

    @Test
    public void checkFirstTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true, "Powinno być true");
//        softAssert.assertTrue(false, "Powinno być true"); // wymuszony błąd do celów poglądowych
        softAssert.assertFalse(false, "Powinno być false");
//        softAssert.assertFalse(true, "Powinno być false"); // wymuszony błąd do celów poglądowych
        softAssert.assertEquals("RABARBAR", "RABARBAR", "Oczekiwana wartość dla obu stringów to \"RABARBAR\"");
        softAssert.assertAll();
    }

    @Test @Ignore
    public void checkIgnoreAnnotationTest() {
        System.out.println("jak to sie uruchomi to coś się zrypało");
    }
}
