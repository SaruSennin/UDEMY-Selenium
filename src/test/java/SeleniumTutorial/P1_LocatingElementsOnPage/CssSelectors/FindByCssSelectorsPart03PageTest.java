package SeleniumTutorial.P1_LocatingElementsOnPage.CssSelectors;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByCssSelectorsPart03PageTest extends BasePage {

    /**
     * By.cssSelector("tag[attribute='valueOfAttribute']") thanks to this selector we can find an HTML element based on
     * its attribute and the given attribute value
     * in the example below we search for all input elements that have an attribute 'name' containing the value 'name'
     */
    @Test
    public void findByFullNameUsingCssTest() {
        String fullName = "input[name='fname']";
        String description = "Valid number of items not found '" + fullName + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(fullName), description, 1);
    }

    /**
     * By.cssSelector("tag[attribute*='attributeValueFragment']") thanks to this selector we can find an HTML element based
     * on its attribute and a fragment of the given attribute value, for the selector to work after the attribute name
     * we have to provide the symbol *
     * in the example below we search for all input elements that have the attribute 'name' in which the attribute
     * value contains the value 'name'
     */
    @Test
    public void findByContainsPartNameUsingCssTest() {
        String containsPartName = "input[name*='name']";
        String description = "Valid number of items not found '" + containsPartName + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(containsPartName), description, 2);
    }

    /**
     * By.cssSelector("tag[attribute^='beginningOfValueAttribute']") thanks to this selector we can find an HTML element
     * based on its attribute and the beginning of the given attribute value, for the selector to work after
     * the attribute name we have to provide the symbol ^
     * in the example below we search for all input elements that have the attribute 'name' in which the attribute value starts with 'f'
     */
    @Test
    public void findByStartNameUsingCssTest() {
        String startName = "input[name^='f']";
        String description = "Valid number of items not found '" + startName + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(startName), description, 1);
    }

    /**
     * By.cssSelector("tag[attribute='endAttributeValue']") thanks to this selector we can find an HTML element based
     * on its attribute and the end of the given attribute value, for the selector to work after the attribute name
     * we have to enter the $ symbol
     * in the example below we search for all input elements that have the attribute 'name' in which the attribute value ends with 'name'
     */
    @Test
    public void findByEndNameUsingCssTest() {
        String endName = "input[name$='name']";
        String description = "Valid number of items not found '" + endName + "'";
        Util.findElementsAndVerify(chromeDriver, By.cssSelector(endName), description, 2);
    }
}
