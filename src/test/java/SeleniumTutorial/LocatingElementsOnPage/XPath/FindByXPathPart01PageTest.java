package SeleniumTutorial.LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart01PageTest extends BasePage {

    /**
     * The selector using the path /tag1/tag2//tag3 will find an element or list of elements with the tag <tag3>
     * the given path is a mapping of the tag path in the HTML file
     * if any element on the path is omitted, we will not get the correct result
     * in the example below, using // causes part of the path to be cut out and all <ul> tags to be found without
     * having to know what is inside the access path
     */
    @Test
    public void findElementByFullPathUsingXpathTest() {
        String fullPath = "/html/body/div//ul";
        String description = "Valid number of items not found '" + fullPath + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(fullPath), description, 2);
    }

    /**
     * In this case, using only // in the "//ul" selector will find all <ul> tags available on the HTML page
     */
    @Test
    public void findElementByShortPathUsingXpathTest() {
        String shortPath = "//ul";
        String description = "Valid number of items not found '" + shortPath + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(shortPath), description, 2);
    }
}
