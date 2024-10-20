package SeleniumTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Util {

    public static void findElementsAndVerify(WebDriver chromeDriver, By by, String elementDescription, Integer expectedElements) {
        List<WebElement> elements = chromeDriver.findElements(by);
        String message = elementDescription + ": Expected " + expectedElements + " elements, but found " + elements.size() + ".";
        Assert.assertEquals(elements.size(), expectedElements, message);
        System.out.println(elements.size() + " elements were found and are displayed.");
    }

    public static void findElementAndVerify(WebDriver chromeDriver, By by, String elementDescription) {
        try {
            WebElement element = chromeDriver.findElement(by);
            if (element.isDisplayed()) {
                Assert.assertTrue(element.isDisplayed(), elementDescription + " should be displayed.");
                System.out.println(elementDescription + " was found and is displayed.");
            } else {
                System.out.println(elementDescription + " was found and should not be visible.");
            }
        } catch (
                NoSuchElementException e) {
            Assert.fail(" " + elementDescription + " was not found.");
        }
    }
}
