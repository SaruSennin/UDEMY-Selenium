package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

import static SeleniumTutorial.UtilLink.IMG_SMILE;

public class HomeworkImgTest extends BasePage {

    @Test
    public void checkImgTest() {
        WebElement img = chromeDriver.findElement(By.tagName("img"));
        boolean doImgHaveHeight = Integer.parseInt(Objects.requireNonNull(img.getAttribute("naturalHeight"))) > 0;
        Assert.assertTrue(doImgHaveHeight, "Błąd - obraz nie wyświetlił sie na stronie");
        Assert.assertTrue(img.isDisplayed(), "Błąd - obraz nie wyświetlił sie na stronie");
        String srcImg = img.getAttribute("src");
        Assert.assertEquals(srcImg, IMG_SMILE, "Błąd - niepoprawne źródło obrazu");
    }
}
