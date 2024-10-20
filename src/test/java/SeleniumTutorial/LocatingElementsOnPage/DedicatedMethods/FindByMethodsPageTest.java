package SeleniumTutorial.LocatingElementsOnPage.DedicatedMethods;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByMethodsPageTest extends BasePage {

    /**
     * The By.id method is one of the methods available in Selenium WebDriver, used to refer to an element with
     * an identified id attribute.
     * WebElement element = driver.findElement(By.id("exampleId"));
     * Advantages
     *  * efficiency
     *  * precision - thanks to the fact that the id should be unique, we choose the object we want
     *  * readability - thanks to the name of the dedicated method, we know what it is for
     * Disadvantages
     *  * problems in the case when there is a dynamic id on the page
     *  * in a situation when there are two identical ids on the page, the method will return the first one found
     */
    @Test
    public void findElementByIdTest() {
        String buttonId = "clickOnMe";
        String description = "Element with ID '" + buttonId + "'";
        Util.findElementAndVerify(chromeDriver, By.id(buttonId), description);
    }

    /**
     * The By.name method is one of the methods available in Selenium WebDriver, used to refer to an element that has
     * a unique or well-identified name attribute.
     * WebElement element = driver.findElement(By.name("elementName"));
     * Application
     *  * often used to find fields in forms that usually have correctly named elements
     *  * uniqueness - despite the possibility of multiple identical names, they are a good alternative to id
     * Advantages
     *  * efficiency
     *  * readability - thanks to the name of the dedicated method, we know what it is for
     * Disadvantages
     *  * lack of uniqueness of the name field
     *  * if the name attribute has changed its value, it will affect the test operation
     */
    @Test
    public void findElementByNameTest() {
        String inputName = "fname";
        String description = "Element with name '" + inputName + "'";
        Util.findElementAndVerify(chromeDriver, By.name(inputName), description);
    }

    /**
     * The By.className method is one of the methods available in Selenium WebDriver, used to refer to an element
     * based on the value of the class attribute of a given HTML element. It searches for elements that have exactly
     * the same class attribute that was given. It does not handle the case when the selector has several classes,
     * in which case one of them must be selected. In the case of the findElement() method, the first element on the
     * page that meets the condition will be found, and for the findElements() method, a list of elements that meet
     * the condition will be found
     * WebElement element = driver.findElement(By.className("className"));
     * Advantages
     *  * efficiency (if the class structure in the file is not complicated)
     * Disadvantages
     *  * when the selector has several classes, e.g. class="button primary large" in which case we select
     *    only one of them to use the method
     */
    @Test
    public void findElementByClassNameTest() {
        String className = "topSecret";
        String description = "Element with class name '" + className + "'";
        Util.findElementAndVerify(chromeDriver, By.className(className), description);
    }

    /**
     * The By.tagName method is one of the methods available in Selenium WebDriver, used to refer to element(s)
     * using their HTML tag.
     * WebElement element = driver.findElement(By.tagName("button"));
     * Application
     *  * method good to use when we know that there is only one tag we are looking for on the page
     *  * good for creating sets of tags on which operations will be performed
     * Advantages
     *  * efficiency
     *  * useful when the html page is generated, in such a case it is easier to move around HTML tags than
     *    generated class or id values
     * Disadvantages
     *  * lower precision in searching - we will find a large set of the same elements, but it is not suitable for
     *    searching for specific objects
     */
    @Test
    public void findElementByTagNameTest() {
        String tagName = "input";
        String description = "Element with tag name '" + tagName + "'";
        Util.findElementAndVerify(chromeDriver, By.tagName(tagName), description);
    }

    @Test
    public void findElementsByTagNameTest() {
        String tagName = "input";
        String description = "Element with tag name '" + tagName + "'";
        Util.findElementsAndVerify(chromeDriver, By.tagName(tagName), description, 8);
    }

    /**
     * The By.linkText method in Selenium is used to locate links (<a>) on a web page using full text visible to the user.
     * HTML - <a href="https://example.com">Visit Example</a>
     * WebElement link = driver.findElement(By.linkText("Visit Example"));
     */
    @Test
    public void findElementByLinkTextTest() {
        String linkText = "Visit W3Schools.com!";
        String description = "Element with tag text link '" + linkText + "'";
        Util.findElementAndVerify(chromeDriver, By.linkText(linkText), description);
    }

    @Test
    public void findElementByPartialLinkTextTest() {
        String linkText = "Visit W3Scho";
        String description = "Element with text link '" + linkText + "'";
        Util.findElementAndVerify(chromeDriver, By.partialLinkText(linkText), description);
    }
}
