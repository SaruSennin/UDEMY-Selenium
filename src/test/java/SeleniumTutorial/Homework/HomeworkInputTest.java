package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomeworkInputTest extends BasePage {

    @Test
    public void fillAndClearInputTest() throws InterruptedException {
//        WebElement fname = chromeDriver.findElement(By.cssSelector("input[id='fname']"));
//        WebElement fname = chromeDriver.findElement(By.name("fname"));
        WebElement fname = chromeDriver.findElement(By.xpath("//input[@id='fname']"));
        fname.sendKeys("Wprowadzona wartość");
        Assert.assertEquals(fname.getAttribute("value"), "Wprowadzona wartość", "Input First name nie zawiera oczekiwanej wartości");
        sleep(1000);
        fname.clear();
        Assert.assertEquals(fname.getAttribute("value"), "", "Input First name nie został poprawnie wyczyszczony");
    }
}
