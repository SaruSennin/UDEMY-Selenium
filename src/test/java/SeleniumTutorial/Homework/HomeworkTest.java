package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkTest extends BasePage {

    @Test
    public void homeworkTest() {
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        String car = "Mercedes";
        boolean doContains = isValueIsInTheSelectHomework(car, select);
        Assert.assertTrue(doContains, "Samochód " + car + " nie zawiera się w selekcie");
    }

    private boolean isValueIsInTheSelectHomework(String value, WebElement select) {
        Select cars = new Select(select);
        List<WebElement> selectOptions = cars.getOptions();
        List<String> actualElements = selectOptions.stream().map(WebElement::getText).toList();
        return actualElements.contains(value);
    }
}
