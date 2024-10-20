package SeleniumTutorial.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkTest {

    private WebDriver chromeDriver = new ChromeDriver();

    @BeforeMethod
    public void setUpBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement basicPageLink = chromeDriver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();
    }

    @AfterMethod
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    @Test
    public void homeworkTest(){
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        String car = "Mercedes";
        boolean doContains = isValueIsInTheSelectHomework(car, select);
        Assert.assertTrue(doContains, "Samochód " + car + " nie zawiera się w selekcie");
    }

    private boolean isValueIsInTheSelectHomework(String value, WebElement select){
        Select cars = new Select(select);
        List<WebElement> selectOptions = cars.getOptions();
        List<String> actualElements = selectOptions.stream().map(WebElement::getText).toList();
        return actualElements.contains(value);
    }

    @Test
    public void methodTest(){

    /*
    praca domowa
    metoda sprawdzajaca wszystko co się da na elementach ze strony basic
     */
    }

}
