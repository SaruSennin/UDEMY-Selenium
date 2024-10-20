package SeleniumTutorial.PageClass;

import SeleniumTutorial.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class IframePage {

    public static WebDriver chromeDriver;

    @BeforeMethod
    public void setUpSuite() {
        chromeDriver = DriverManager.getDriver();
        DriverManager.navigateTo("https://testeroprogramowania.github.io/selenium/iframe.html");
    }

    @AfterMethod
    public void tearDownSuite() {
        DriverManager.quitDriver();
    }
}