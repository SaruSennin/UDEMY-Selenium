package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeworkCheckBoxTest extends BasePage {

    @Test
    public void checkCheckBoxIsSelectedTest() {
        WebElement checkBox = chromeDriver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected(), "Checkbox nie został zaznaczony");
    }

    @Test
    public void checkCheckBoxIsDisplayedTest() {
        WebElement checkBox = chromeDriver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertTrue(checkBox.isDisplayed(), "Checkbox powinien być widoczny");
    }

    @Test
    public void checkCheckboxDeselectionTest() {
        WebElement checkbox = chromeDriver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected(), "Checkbox powinien być odznaczony.");
    }

    @Test
    public void checkCheckBoxIsEnabledTest() {
        WebElement checkbox = chromeDriver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertTrue(checkbox.isEnabled(), "Checkbox powinien być dostepny");
    }

    @Test
    public void checkCheckBoxTextTest() {
        WebElement checkbox = chromeDriver.findElement(By.xpath("//label[contains(text(),'Potwierdzam')]"));
        Assert.assertEquals(checkbox.getText(), "Potwierdzam 100% nieznajomość regulaminu. Kto ma czas na czytanie regulaminów", "W checkboxie występuje niepoprawny tekst");
    }

    @Test
    public void checkUniqueCheckboxTest() {
        List<WebElement> checkboxes = chromeDriver.findElements(By.xpath("//label//input[@type='checkbox']"));
        Assert.assertEquals(checkboxes.size(), 1, "Na stronie powinien znajdować się tylko jeden checkbox.");
    }

    @Test
    public void checkCheckboxHasParentLabelTest() {
        WebElement checkbox = chromeDriver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement parent = checkbox.findElement(By.xpath(".."));
        Assert.assertEquals(parent.getTagName(), "label", "Checkbox powinien być wewnątrz znacznika <label>.");
    }
}
