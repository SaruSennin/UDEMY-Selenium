package SeleniumTutorial.LocatingElementsOnPage.CssSelectors;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Metoda By.cssSelector w Selenium pozwala na znalezienie elementów na stronie internetowej przy użyciu selektorów CSS.
 * Jest to bardzo elastyczna metoda lokalizacji, która umożliwia wyszukiwanie elementów z użyciem różnorodnych reguł
 */
public class FindByCssSelectorsPart01Page extends BasePage {

    /**
     * By.cssSelector("#identifier")
     * e.g. selects an element with a given id (e.g. By.cssSelector("#buttonId") for the element <button id="buttonId"></button>)
     */
    @Test
    public void findElementByIdUsingCssTest() { // instead By.id("clickOnMe")
        String buttonId = "#clickOnMe";
        String description = "Searched element by css pattern '" + buttonId + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(buttonId), description);
    }

    /**
     * By.cssSelector(".className")
     * e.g. selects an element with a given class name (e.g. By.cssSelector(".topSecret") for the <p class="topSecret"></p> element)
     */
    @Test
    public void findElementByClassUsingCssTest() { // instead By.className("topSecret")
        String cssClass = ".topSecret";
        String description = "Searched element by css pattern '" + cssClass + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(cssClass), description);
    }

    /**
     * By.cssSelector("typeOfTag")
     * e.g. selects an element or elements with a given tag (e.g. By.cssSelector("input") for an <input></input> element)
     */
    @Test
    public void findElementByTagUsingCssTest() { // instead By.tagName("input")
        String cssInput = "input";
        String description = "Searched element by css pattern '" + cssInput + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(cssInput), description);
    }

    /**
     * By.cssSelector("attribute='value'")
     * e.g. selects an element or elements with a given attribute and its value (e.g. By.cssSelector("[name='Bogdan']")
     * for the element <input name='Bogdan'></input>)
     */
    @Test
    public void findElementByNameUsingCssTest() { // instead By.name("fname")
        String cssName = "[name='fname']";
        String description = "Searched element by css pattern '" + cssName + "'";
        Util.findElementAndVerify(chromeDriver, By.cssSelector(cssName), description);
    }
}
