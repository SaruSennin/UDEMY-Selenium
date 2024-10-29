package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkRadioButtonTest extends BasePage {

    @Test
    public void checkRadioButtonsIsDisplayedTest() {
        List<WebElement> radioButtons = chromeDriver.findElements(By.name("gender"));
        radioButtons.forEach(radioButton ->
                Assert.assertTrue(radioButton.isDisplayed(), "Radio button " + radioButton.getAttribute("value") + " nie jest widoczny.")
        );
    }

    @Test
    public void checkRadioButtonsAreDefaultNotSelectedTest() {
        List<WebElement> radioButtons = chromeDriver.findElements(By.name("gender"));
        boolean isRadioButtonsAreSelected = radioButtons.stream().anyMatch(WebElement::isSelected);
        Assert.assertFalse(isRadioButtonsAreSelected, "Domyślnie wszystkie radiobutony powinny być odznaczone");
    }

    @Test
    public void checkRadioButtonAreSelectedTest() {
        List<WebElement> radioButtons = chromeDriver.findElements(By.name("gender"));
        radioButtons.forEach(radioButton -> {
            radioButton.click();
            Assert.assertTrue(radioButton.isSelected(), "Radiobutton " + radioButton.getAttribute("value") + " powinien być zaznaczony");
        });
    }

    /**
     * //TODO przeanalizować ten przypadek dla sytuacji kiedy wyszukujemy jakiejś wartości tekstowej która jest "luzem" w kodzie HTLM
     * <form action="">
     * <input type="radio" name="gender" value="male"> Male<br>
     * <input type="radio" name="gender" value="female"> Female<br>
     * <input type="radio" name="gender" value="other"> Other
     * </form>
     */
    @Test
    public void checkRadioButtonLabelTest() {
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        List<WebElement> radioButtons = chromeDriver.findElements(By.xpath("//input[@name='gender']"));
        Map<String, String> genderTextMap = new HashMap<>();

        for (WebElement radioButton : radioButtons) {
            String value = radioButton.getAttribute("value");
            String labelText = (String) js.executeScript("return arguments[0].nextSibling.textContent.trim();", radioButton);
            genderTextMap.put(value, labelText);
        }
        Assert.assertEquals(genderTextMap, expectedLabels(), "W liście radiobuttonów nie ma wymaganych labeli");
    }

    @Test
    public void checkNumberOfRadioButtonsTest() {
        List<WebElement> radioButtons = chromeDriver.findElements(By.name("gender"));
        Assert.assertEquals(radioButtons.size(), 3, "Brak wymaganej liczby radiobuttonów");
    }

    private Map<String, String> expectedLabels() {
        return Map.of(
                "male", "Male",
                "female", "Female",
                "other", "Other");
    }
}
