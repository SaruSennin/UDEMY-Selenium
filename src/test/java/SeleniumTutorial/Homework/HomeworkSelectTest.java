package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HomeworkSelectTest extends BasePage {

    @Test
    public void settingSelectValueByValueTest() {
        Select select = getSelect();
        select.selectByValue("volvo");
        Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "volvo", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void settingSelectValueByIdTest() {
        Select select = getSelect();
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "mercedes", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void settingSelectValueByTextTest() {
        Select select = getSelect();
        select.selectByVisibleText("Audi");
        Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "audi", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void checkingDefaultSelectValueTest() {
        Select select = getSelect();
        select.selectByVisibleText("Audi");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Audi", "Domyślnie wybrana opcja to Audi");
    }

    @Test
    public void checkingNumberOfSelectOptionsTest() {
        Select select = getSelect();
        int selectSize = select.getOptions().size();
        Assert.assertEquals(selectSize, 4, "Liczba opcji w selekcie jest niepoprawna ");
    }

    @Test
    public void optionAvailabilityTest() {
        Select select = getSelect();
        List<String> expectedOptions = Arrays.asList("Volvo", "Saab", "Mercedes", "Audi");
        List<String> currentOptions = select.getOptions().stream().map(WebElement::getText).toList();
        Assert.assertEquals(currentOptions, expectedOptions, "Niepoprawna zawartość selecta");
    }

    @Test
    public void valueValidityWithSelectTextTest() {
        Select select = getSelect();
        Map<String, String> expectedValues = expectedSelect();
        Map<String, String> currentValues = select.getOptions().stream()
                .collect(Collectors.toMap(WebElement::getText, getValue()));
        Assert.assertEquals(currentValues, expectedValues, "Nie odnaleziono oczekiwanego selecta");
    }

    private Function<WebElement, String> getValue() {
        return option -> option.getAttribute("value");
    }

    private Map<String, String> expectedSelect() {
        Map<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Volvo", "volvo");
        expectedValues.put("Saab", "saab");
        expectedValues.put("Mercedes", "mercedes");
        expectedValues.put("Audi", "audi");

        return expectedValues;
    }

    private Select getSelect() {
        return new Select(chromeDriver.findElement(By.xpath("//select")));
    }
}
