package SeleniumTutorial.ActionOnElements;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionOnElementsJavaScriptTest extends BasePage {

    @Test
    public void tabToNextItemTest() {
        WebElement inputUserName = chromeDriver.findElement(By.name("username"));
        WebElement inputUserPassword = chromeDriver.findElement(By.name("password"));
        inputUserName.sendKeys(Keys.TAB);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
        Boolean isFocused = (Boolean) jsExecutor.executeScript("return arguments[0] === document.activeElement;", inputUserPassword);
        Assert.assertEquals(isFocused, Boolean.TRUE, "Input nie jest zaznaczony!");
    }

    @Test
    public void executeJavaScriptClickOnButtonTest(){
        chromeDriver.get("https://testeroprogramowania.github.io/selenium"); // TODO pomyśleć jak to usunąć i podmienić
        WebElement basicPageLink = chromeDriver.findElement(By.linkText("Podstawowa strona testowa")); // TODO pomyśleć jak to usunąć i podmienić
        JavascriptExecutor jsExecutor = (JavascriptExecutor) chromeDriver;
        jsExecutor.executeScript("arguments[0].click();",basicPageLink);
        String expectedUrl = "https://testeroprogramowania.github.io/selenium/basics.html";
        String currentUrl = chromeDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "Przeglądarka nie przełączyła się na oczekiwaną stronę!");
    }

    @Test
    public void executeJavaScriptEnterValueTest(){
        chromeDriver.get("https://testeroprogramowania.github.io/selenium"); // TODO pomyśleć jak to usunąć i podmienić
        WebElement basicPageLink = chromeDriver.findElement(By.linkText("Podstawowa strona testowa")); // TODO pomyśleć jak to usunąć i podmienić
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) chromeDriver;
        javascriptExecutor.executeScript("arguments[0].click();", basicPageLink); // zamiast click()
        WebElement firstName = chromeDriver.findElement(By.name("fname"));
        javascriptExecutor.executeScript("arguments[0].setAttribute('value','Barteg');",firstName); // zamiast sendKeys()
        Assert.assertEquals(firstName.getAttribute("value"), "Barteg", "Pole tekstowe nie zostało uzupełnione prawidłowo!");
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', '');", firstName);
    }
}
