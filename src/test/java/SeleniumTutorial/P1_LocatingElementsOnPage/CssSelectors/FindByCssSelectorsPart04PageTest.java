package SeleniumTutorial.P1_LocatingElementsOnPage.CssSelectors;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByCssSelectorsPart04PageTest extends BasePage {

    /**
     * The By.cssSelector("TagName:first-child") method in Selenium uses a CSS selector to find the first element
     * of a given tag - it finds the first child of the given parent.
     * WebElement firstChildElement = driver.findElement(By.cssSelector("li:first-child"));
     * the above line will return the first child of the first <li> </li> tag encountered in the file
     * in the case of using the findElements() method, it will return a list of elements consisting of the
     * first children of their parents
     */
    @Test
    public void findFirstChildrenInLiTagUsingCssTest() {
        String firstChild = "li:first-child";
        String description = "Valid number of items not found '" + firstChild + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(firstChild), description, 2);
    }

    /**
     * The By.cssSelector("TagName:last-child") method in Selenium uses a CSS selector to find the last element
     * of a given tag - it finds the last child of the given parent.
     * WebElement lastChildElement = driver.findElement(By.cssSelector("li:last-child"));
     * the above line will return the last child of the first <li> </li> tag encountered in the file
     * in the case of using the findElements() method, it will return a list of elements consisting of the
     * last children of their parents
     */
    @Test
    public void findLastChildrenInLiTagUsingCssTest() {
        String lastChild = "li:last-child";
        String description = "Valid number of items not found '" + lastChild + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(lastChild), description, 2);
    }

    /**
     * The By.cssSelector("TagName:nth-child(number)") method in Selenium uses a CSS selector to find an element with
     * a specific position of a given tag - finds the child with the given position in brackets.
     * WebElement currentChildElement = driver.findElement(By.cssSelector("li:nth-child(2)"));
     * the above line will return a child with the given ordinal number of the <li> </li> tag encountered in the file
     * when using the findElements() method, it will return a list of elements consisting of children with the given
     * ordinal number for the given parents, unlike arrays, the first child will have ordinal number 1, not 0
     */
    @Test
    public void findCurrentChildInLiTagUsingCssTest() {
        String currentChild = "li:nth-child(2)";
        String description = "Valid number of items not found '" + currentChild + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(currentChild), description, 1);
    }
}
