package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkListTest extends BasePage {

    /**
     * <ul>
     *     <li> List Item
     *         <ul>
     *             <li> Child </li>
     *         </ul>
     *     </li>
     *     <li> List Item </li>
     *     <li> List Item </li>
     *     <li> List Item </li>
     * </ul>
     */
    @Test
    public void checkLiTagNumbersInListTest() {
        List<WebElement> liList = chromeDriver.findElements(By.xpath("//ul//li"));
        Assert.assertEquals(liList.size(), 5, "Niepoprawna ilość obiektów");
    }

    @Test
    public void checkNestedElementsTest() {
        WebElement ul = chromeDriver.findElement(By.xpath("//ul//li[1]//ul"));
        Assert.assertTrue(ul.isDisplayed(), "Błąd - brak oczekiwanej listy ul w elemencie");
    }

    @Test
    public void checkListTextTest() {
        WebElement ul = chromeDriver.findElement(By.xpath("//ul//li[1]//ul"));
        Assert.assertTrue(ul.isDisplayed(), "Błąd - brak oczekiwanej listy ul w elemencie");
    }

    // TODO: na potem pomyśleć jak swobodnie poruszać sie po takiej strukturze jaka została wykorzystana w tej klasie
    @Test
    public void checkUlChildrenTest() {
        List<WebElement> ulList = chromeDriver.findElements(By.xpath("//ul[not(ancestor::ul)]/li"));
        boolean doListIsCorrect = ulList.stream().allMatch(liElement -> liElement.getText().startsWith("List Item"));
        Assert.assertTrue(doListIsCorrect, "Zawartość listy nie jest zgodna z oczekiwaną");
    }
}
