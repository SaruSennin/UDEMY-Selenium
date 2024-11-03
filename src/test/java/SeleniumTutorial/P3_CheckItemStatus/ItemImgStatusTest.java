package SeleniumTutorial.P3_CheckItemStatus;

import SeleniumTutorial.PageClass.ImagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemImgStatusTest extends ImagePage {

    @Test
    public void checkImageDoExistTest() {
        WebElement img = chromeDriver.findElement(By.tagName("img"));
        Assert.assertEquals(img.getAttribute("naturalHeight"), "0", "Błąd - obrazek nie powinien być załadowany");
    }
}
