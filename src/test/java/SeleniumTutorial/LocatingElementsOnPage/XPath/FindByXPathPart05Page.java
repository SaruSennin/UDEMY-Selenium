package SeleniumTutorial.LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart05Page extends BasePage {

    /**
     * Using the "//div/child::ul" selector, we search for all <div> elements in the HTML page, and then use child::ul
     * to select all direct <ul> elements that are children of any <div> elements we found.
     */
    @Test
    public void findElementByChildUsingXpathTest() {
        String child = "//div/child::ul";
        String description = "Searched element by css pattern '" + child + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(child), description);
    }

    /**
     * Using the "//div/descendant::ul" selector, we select all <div> elements available in the HTML page and then
     * search all descendants of each of those <div> elements to find <ul> elements in their hierarchy (direct or nested)
     * we search for each <ul> element in the found divs
     */
    @Test
    public void findElementByDescendantUsingXpathTest() {
        String descendant = "//div/descendant::ul";
        String description = "Valid number of items not found '" + descendant + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(descendant), description, 2);
    }

    /**
     * Using the "//div/../.." selector we go back in the XML genealogical tree. The first use of /.. takes us back to
     * the parent of our found <div> element and the second use of /.. takes us back to its grandfather
     */
    @Test
    public void findElementByParentUsingXpathTest() {
        String parent = "//div/../..";
        String description = "Searched element by css pattern '" + parent + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(parent), description);
    }

    /**
     * Using the "//div/ancestor::*" selector searches for all ancestors of our found <div> elements
     */
    @Test
    public void findElementsByAncestorUsingXpathTest() {
        String ancestor = "//div/ancestor::*";
        String description = "Valid number of items not found '" + ancestor + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(ancestor), description, 2);
    }

    /**
     * Using the "//img/following::*" selector finds all <img> tags and then returns all tags that are found after our <img> elements in file
     */
    @Test
    public void findElementsAfterChosenTagUsingXpathTest() {
        String findAfterImgTag = "//img/following::*";
        String description = "Valid number of items not found '" + findAfterImgTag + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(findAfterImgTag), description, 11);
    }

    /**
     * Using the "//img/following-sibling::*" selector returns all elements that appear after the found <img> elements,
     * but only returns those elements that are on the same generation line (are siblings) in file
     */
    @Test
    public void findSiblingsElementsAfterChosenTagUsingXpathTest() {
        String findSiblingsAfterImgTag = "//img/following-sibling::*";
        String description = "Valid number of items not found '" + findSiblingsAfterImgTag + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(findSiblingsAfterImgTag), description, 4);
    }

    /**
     * Using the "//img/preceding::*" selector returns all HTML page elements used in file before the <img> tags found
     */
    @Test
    public void findElementsBeforeChosenTagUsingXpathTest() {
        String findBeforeImgTag = "//img/preceding::*";
        String description = "Valid number of items not found '" + findBeforeImgTag + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(findBeforeImgTag), description, 47);
    }

    /**
     * Using the "//img/preceding-sibling::*" selector returns all HTML page elements used in file before the found <img> tags,
     * but only those that are on the same generation line
     */
    @Test
    public void findSiblingsElementsBeforeChosenTagUsingXpathTest() {
        String findSiblingsBeforeImgTag = "//img/preceding-sibling::*";
        String description = "Valid number of items not found '" + findSiblingsBeforeImgTag + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(findSiblingsBeforeImgTag), description, 17);
    }
}
