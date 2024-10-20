package SeleniumTutorial.LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart02Page extends BasePage {

    /**
     * The "//tag[@key='value']" selector uses xpath to search the entire HTML file for a <tag> element whose key is equal to the specified value
     * in the example below "//button[@id='clickOnMe']"
     * // - we search the entire HTML file
     * button - we search for the <button> element
     * @id - which has an element id
     * 'clickOnMe' - with the value is clickOnMe
     */
    @Test
    public void findElementByIdUsingXpathTest() {
        String buttonId = "//button[@id='clickOnMe']";
        String description = "Searched element by css pattern '" + buttonId + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(buttonId), description);
    }

    /**
     * Example as above
     * we search the entire HTML file for the <input> element whose name attribute is equal to 'fname'
     */
    @Test
    public void findElementByNameUsingXpathTest() {
        String inputName = "//input[@name='fname']";
        String description = "Searched element by css pattern '" + inputName + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(inputName), description);
    }

    /**
     * Example as above
     * we search the entire HTML file for the <p> element (paragraph) whose class attribute is 'topSecret'
     */
    @Test
    public void findElementByClassNameUsingXpathTest() {
        String inputName = "//p[@class='topSecret']";
        String description = "Searched element by css pattern '" + inputName + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(inputName), description);
    }

    /**
     * In this method we search using the findElement() method the first 'input' element available on the HTML page
     */
    @Test
    public void findElementByTagNameUsingXpathTest() {
        String tagName = "//input";
        String description = "Searched element by css pattern '" + tagName + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(tagName), description);
    }

    /**
     * In this method we search using the findElements() method a list of <input> elements available on the HTML page
     */
    @Test
    public void findElementsByTagNameUsingXpathTest() {
        String tagName = "//input";
        String description = "Valid number of items not found '" + tagName + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(tagName), description, 8);
    }

    /**
     * In the selector "//a[text()='Visit W3Schools.com!']"
     * //a - we search for <a> elements on the HTML page
     * text() - we call the text() method on the found <a> element
     * ='Visit W3Schools.com!' - we check if our element has the value 'Visit W3Schools.com!' as text
     */
    @Test
    public void findElementByLinkTextUsingXpathTest() {
        String linkText = "//a[text()='Visit W3Schools.com!']";
        String description = "Searched element by css pattern '" + linkText + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(linkText), description);
    }

    /**
     * The selector "//a[contains(text(),'sit W3Scho')]" searches for an element on the page that contains the given text fragment
     * //a - we search for <a> elements on the HTML page
     * contains(method, text) - we call the cointains() method
     * as the first parameter we provide the text() method
     * and as the second parameter we provide the text fragment that is to be included in the result
     */
    @Test
    public void findElementByPartialLinkTextUsingXpathTest() {
        String linkText = "//a[contains(text(),'sit W3Scho')]";
        String description = "Searched element by css pattern '" + linkText + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(linkText), description);
    }
}
