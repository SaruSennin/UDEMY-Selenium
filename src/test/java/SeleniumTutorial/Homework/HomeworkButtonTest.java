package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomeworkButtonTest extends BasePage {

    @Test
    public void pushUpWindowTest() throws InterruptedException {
//        WebElement clickOnMe = chromeDriver.findElement(By.cssSelector("#clickOnMe")).click();
//        WebElement clickOnMe = chromeDriver.findElement(By.id("clickOnMe")).click();
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        clickOnMe.click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Hello world!", "Oczekiwany alert nie został wyswietlony");
        sleep(1000);
        alert.accept();
    }

    @Test
    public void verifyButtonIsVisibleTest() {
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        Assert.assertTrue(clickOnMe.isDisplayed(), "Przycisk Kliknij mnie! nie jest wyświetlony");
    }

    @Test
    public void verifyButtonIsNotSelectedTest() {
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        Assert.assertFalse(clickOnMe.isSelected(), "Przycisk Kliknij mnie! nie powinien być zaznaczony");
    }

    @Test
    public void verifyButtonNameIsCorrectTest() {
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        Assert.assertEquals(clickOnMe.getText(), "Kliknij mnie!", "Niepoprawna nazwa przycisku Kliknij mnie!");
    }

    @Test
    public void verifyButtonIsEnabledTest() {
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        Assert.assertTrue(clickOnMe.isEnabled(), "Przycisk Kliknij mnie! powinien być dostępny");
    }

    @Test
    public void verifyButtonTagNameTest() {
        WebElement clickOnMe = chromeDriver.findElement(By.xpath("//button[contains(text(), 'Kliknij')]"));
        Assert.assertEquals(clickOnMe.getTagName(), "button", "Przycisk Kliknij mnie! powinien być dostępny");
    }
}
