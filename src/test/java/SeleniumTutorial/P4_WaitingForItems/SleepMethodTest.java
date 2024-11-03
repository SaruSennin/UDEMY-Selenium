package SeleniumTutorial.P4_WaitingForItems;

import SeleniumTutorial.PageClass.WaitingForItemsTwoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static java.lang.Thread.sleep;

public class SleepMethodTest extends WaitingForItemsTwoPage {

    @Test
    public void checkSleepMethodTest() throws InterruptedException {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        sleep(5000);
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    @Test
    public void checkImplicitlyWaitMethodTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
//        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Deprecated
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    @Test
    public void checkExplicitWaitMethodTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    @Test
    public void checkFluentWaitMethodTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    @Test
    public void checkMyOwnConditionByAnonymousClassTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        waitForElementByAnonymousClass(By.cssSelector("p"));
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    @Test
    public void checkMyOwnConditionByLambdaTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        waitForElementByLambda(By.cssSelector("p"));
        Assert.assertTrue(chromeDriver.findElement(By.cssSelector("p")).isDisplayed(), "Błąd - Paragraf powinien być widoczny");
    }

    public void waitForElementByAnonymousClass(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> webElementList = chromeDriver.findElements(locator);
                System.out.println(!webElementList.isEmpty() ? "Element jest już na stronie" : "Brak elementu <p> na stronie");
                return !webElementList.isEmpty();
            }
        });
    }

    public void waitForElementByLambda(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver -> {
            List<WebElement> webElementList = chromeDriver.findElements(locator);
            System.out.println(!webElementList.isEmpty() ? "Element jest już na stronie" : "Brak elementu <p> na stronie");
            return !webElementList.isEmpty();
        }));
    }
}
