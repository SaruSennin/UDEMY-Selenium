package SeleniumTutorial.LocatingElementsOnPage.XPath;

import SeleniumTutorial.PageClass.BasePage;
import SeleniumTutorial.Util;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindByXPathPart04Page extends BasePage {

    /**
     * The "//*[@id!='clickOnMe']" selector searches all elements of the HTML page for all elements whose id attribute
     * is not equals 'clickOnMe'
     */
    @Test
    public void findElementsByNotEqualsAttributeUsingXpathTest() {
        String notEqualsAttribute = "//*[@id!='clickOnMe']";
        String description = "Valid number of items not found '" + notEqualsAttribute + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(notEqualsAttribute), description, 4);
    }

    /**
     * The "//*[contains(@name,'ame')]" selector searches all elements of the HTML page for all elements
     * that have the 'name' attribute and its value contains the string 'ame'
     */
    @Test
    public void findElementsByContainsPartAttributeUsingXpathTest() {
        String containPartAttribute = "//*[contains(@name,'ame')]";
        String description = "Valid number of items not found '" + containPartAttribute + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(containPartAttribute), description, 2);
    }

    /**
     * The "//*[starts-with(@name,'user')]" selector searches all elements of the HTML page for all elements that
     * have the 'name' attribute and its value starts with 'user'
     */
    @Test
    public void findElementByStartWithUsingXpathTest() {
        String startWith = "//*[starts-with(@name,'user')]";
        String description = "Searched element by css pattern '" + startWith + "'";
        Util.findElementAndVerify(chromeDriver, By.xpath(startWith), description);
    }

    /**
     * The selector "//*[substring(@name, string-length(@name)-string-length('name')+1)='name']" searches all
     * elements of the HTML page for all elements with the 'name' attribute whose values end with the string 'name'
     */
    @Test
    public void findElementsByEndWithUsingXpathTest() {
        String endWith = "//*[substring(@name, string-length(@name)-string-length('name')+1)='name']";
//        String endWith = "//*[ends-with(@name,'user')]"; // nie działa dla starszych wersji
        String description = "Valid number of items not found '" + endWith + "'";
        Util.findElementsAndVerify(chromeDriver, By.xpath(endWith), description, 2);
    }
}
