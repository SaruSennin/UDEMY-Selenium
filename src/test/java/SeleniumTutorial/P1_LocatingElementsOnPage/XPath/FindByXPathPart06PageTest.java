package SeleniumTutorial.P1_LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart06PageTest extends BasePage {

    /**
     * Using the "//a | //div" selector, we search for all <a> and <div> elements in the HTML page
     * the | symbol means OR
     */
    @Test
    public void findElementsWithSimpleAndOperatorUsingXpathTest() {
        String findElementUsingAnd = "//a | //div";
        String description = "Valid number of items not found '" + findElementUsingAnd + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(findElementUsingAnd), description, 3);
    }

    /**
     * The selector construction "//input[@name='fname' and @id='fname']" allows us to find exactly the <input> element
     * whose name is equal to 'fname' and id is equal to 'fname'
     */
    @Test
    public void findElementsWithAndOperatorUsingXpathTest() {
        String findElementsUsingAnd = "//input[@name='fname' and @id='fname']";
        String description = "Searched element by css pattern '" + findElementsUsingAnd + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(findElementsUsingAnd), description);
    }

    /**
     * Using the "//input[@name='fname' or @id='fnam']" selector allows us to find <input> elements
     * where the condition only requires one to be true
     */
    @Test
    public void findElementsWithOrOperatorUsingXpathTest() {
        String findElementUsingOr = "//input[@name='fname' or @id='fnam']";
        String description = "Searched element by css pattern '" + findElementUsingOr + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(findElementUsingOr), description);
    }
}
