package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.UtilLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Set;

import static java.lang.Thread.sleep;

public class HomeworkLinkTest extends BasePage {

    @Test
    public void clickToW3SchoolsLinkTest() throws InterruptedException {
//        WebElement w3SchoolsLink = chromeDriver.findElement(By.partialLinkText("Visit W3Scho"));
//        WebElement w3SchoolsLink = chromeDriver.findElement(By.linkText("Visit W3Schools.com!"));
//        WebElement w3SchoolsLink = chromeDriver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        WebElement w3SchoolsLink = chromeDriver.findElement(By.xpath("//a[contains(text(),'sit W3Scho')]"));
        String currentWindow = chromeDriver.getWindowHandle(); // wyszukanie nazwy aktualnego okna
        w3SchoolsLink.click();
        Set<String> windowNames = chromeDriver.getWindowHandles(); // wyszukanie nazw wszystkich otwartych okien
        sleep(1000);
        windowNames.forEach(windowName -> { // TODO pomyśleć jak to można zmienić
            if (!windowName.equals(currentWindow)) { // sprawdzamy czy w zbiorze nazw występuje nazwa różna od naszego aktualnego okna
                chromeDriver.switchTo().window(windowName); // jeśli tak to sie przełączamy
            }
        });
        sleep(1000);
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains(UtilLink.W3SCHOOLS), "Oczekiwana strona to W3Schools");
        chromeDriver.navigate().back();
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains(UtilLink.BASIC_PAGE), "Oczekiwana strona to Basic");
    }

    @Test
    public void clickToGoogleLinkTest() throws InterruptedException {
//        WebElement weirdLink = chromeDriver.findElement(By.cssSelector("a[href='https://www.google.com']"));
//        WebElement weirdLink = chromeDriver.findElement(By.cssSelector("a[href*='google.com']"));
//        WebElement weirdLink = chromeDriver.findElement(By.cssSelector("a[href^='https://www.google']"));
        WebElement weirdLink = chromeDriver.findElement(By.cssSelector("a[href$='www.google.com']"));
        weirdLink.click();
        Set<String> windowNames = chromeDriver.getWindowHandles();
        sleep(1000);
        String currentWindow = chromeDriver.getWindowHandle();
        windowNames.forEach(windowName -> { // TODO pomyśleć jak to można zmienić
            if (!windowName.equals(currentWindow)) {
                chromeDriver.switchTo().window(windowName);
            }
        });
        sleep(1000);
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains(UtilLink.GOOGLE), "Oczekiwana strona to Google");
        chromeDriver.navigate().back();
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains(UtilLink.BASIC_PAGE), "Oczekiwana strona to Basic");
    }
}
