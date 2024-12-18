package SeleniumTutorial.PageClass;

import SeleniumTutorial.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ImagePage {

    public static WebDriver chromeDriver;

    @BeforeMethod
    public void setUpSuite() {
        chromeDriver = DriverManager.getDriver();
        DriverManager.navigateTo("https://testeroprogramowania.github.io/selenium/image.html");
    }

    @AfterMethod
    public void tearDownSuite() {
        DriverManager.quitDriver();
    }
}
