package SeleniumTutorial.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomeworkGladiatusTest {

    private WebDriver chromeDriver = new ChromeDriver();

    @BeforeMethod
    public void setUpBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = chromeDriver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
    }

//    @AfterMethod
//    public void tearDown() {
//        if (chromeDriver != null) {
//            chromeDriver.quit();
//        }
//    }

    @Test(enabled = false)
    public void gladiatusBotTest() throws InterruptedException {
        chromeDriver.get("https://lobby.gladiatus.gameforge.com/en_GB/hub");
        chromeDriver.manage().window().maximize();
        WebElement cookies = chromeDriver.findElement(By.className("cookiebanner5"));
        cookies.click();
        WebElement acceptAllButton = chromeDriver.findElement(By.cssSelector("button.cookiebanner5"));
        acceptAllButton.click();

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
//        WebElement logInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(), 'Log in')]")));
        WebElement logInElement = chromeDriver.findElement(By.xpath("//li[contains(text(), 'Log in')]"));
        Actions actions = new Actions(chromeDriver);
        actions.moveToElement(logInElement).click().perform();
        sleep(10000);
        chromeDriver.findElement(By.name("email")).sendKeys("mail");
        chromeDriver.findElement(By.name("password")).sendKeys("hasło");
        chromeDriver.findElement(By.className("button-primary")).click();
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button button-default button-md']")));
        actions.moveToElement(playButton).click().perform();
    }
}
