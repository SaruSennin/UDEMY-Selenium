package SeleniumTutorial.LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart03Page extends BasePage {

    /**
     * The "//*" selector selects all elements in an HTML page
     */
    @Test
    public void findAllElementsUsingXpathTest() {
        String allElements = "//*";
        String description = "Valid number of items not found '" + allElements + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(allElements), description, 61);
    }

    /**
     * The "(//input)[2]" selector selects all <input> elements from the HTML page and returns the next element from the list
     * (numbered list starting from 1)
     */
    @Test
    public void findSecondElementInListUsingXpathTest() {
        String secondInput = "(//input)[2]";
        String description = "Searched element by css pattern '" + secondInput + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(secondInput), description);
    }

    /**
     * The "(//input)[last()]" selector returns the last <input> element available in the HTML page
     */
    @Test
    public void findLastElementInListUsingXpathTest() {
        String lastInput = "(//input)[last()]";
        String description = "Searched element by css pattern '" + lastInput + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(lastInput), description);
    }

    /**
     * The "//*[@name]" selector returns all elements from the HTML page that have the 'name' attribute
     */
    @Test
    public void findAllElementWithNameAttributeUsingXpathTest() {
        String elementsWithAttribute = "//*[@name]"; // wszystkie elementy z atrybutem name
        String description = "Valid number of items not found '" + elementsWithAttribute + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(elementsWithAttribute), description, 6);
    }
}
