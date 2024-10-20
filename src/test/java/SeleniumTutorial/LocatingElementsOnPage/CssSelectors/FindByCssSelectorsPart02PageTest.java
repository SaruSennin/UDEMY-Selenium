package SeleniumTutorial.LocatingElementsOnPage.CssSelectors;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByCssSelectorsPart02PageTest extends BasePage {

    /**
     * The By.cssSelector("*") method returns all elements on the page
     */
    @Test
    public void findAllElementsUsingCssTest() {
        String all = "*";
        String description = "Valid number of items not found '" + all + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(all), description, 61);
    }

    /**
     * The "tag1 tag2" selector finds all <tag2> elements that are nested inside <tag1> elements.
     * This means that it will return all ordered lists <tag2> that are directly or deeper in the HTML structure
     * inside any <tag1> element.
     * In the method below, cssSelector("div ul") will return all <ul> lists that are contained in all divs on the page
     */
    @Test
    public void findUlListsInDivUsingCssTest() {
        String ulInDiv = "div ul";
        String description = "Valid number of items not found '" + ulInDiv + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(ulInDiv), description, 2);
    }

    /**
     * The "tag1 > tag2" selector finds the first child of the <tag2> tag contained in the <tag1> tag
     * if in HTML the <tag2> tag is not directly contained in <tag1> but is nested deeper in this case the child will not be found
     * in the example below the first child of the <ul> tag will be found in <div> in case that the <ul> tag is not
     * nested deeper into the structure and <div> tag is his direct parent
     */
    @Test
    public void findFirstChildUlForDivUsingCssTest() {
        String firstChildDiv = "div > ul";
        String description = "Searched element by css pattern '" + firstChildDiv + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(firstChildDiv), description);
    }

    /**
     * The selector "tag1 + tag2" finds the first child of <tag1> whose tag is <tag2>
     * if in the same generation HTML <tag2> does not occur right after <tag1> then the child will not be found
     * in the example below the child is the <form> tag if between the <label> tag and the <form> tag in the same
     * generation another tag will occur then the <form> tag will not be found
     */
    @Test
    public void findFirstFormAfterLabelUsingCssTest() {
        String firstFormAfterLabel = "label + form";
        String description = "Searched element by css pattern '" + firstFormAfterLabel + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(firstFormAfterLabel), description);
    }

    /**
     * The selector "tag1 ~ tag2" finds all children of <tag1> that are marked with <tag2>
     * in the example "label ~ form" we will get as result all <form> elements that are inside the <label> element
     * only children of <label> will be searched, ignoring deeper nested structures
     */
    @Test
    public void findAllFormAfterLabelUsingCssTest() {
        String allFormAfterLabel = "label ~ form";
        String description = "Valid number of items not found '" + allFormAfterLabel + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(allFormAfterLabel), description, 2);
    }
}
