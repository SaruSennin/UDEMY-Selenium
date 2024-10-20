package SeleniumTutorial.ActionOnElements;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ActionOnElementsBasicSitePageTest extends BasePage {

    /**
     * Metoda klika na przycisk o id = clickOnMe i uruchamia alert zawierający tekst Hello world!
     * Jeśli alert nie został wyświetlony try-catch wyłapuje to i asercja podaje komunikat o niepowodzeniu
     */
    @Test
    public void clickOnElementWithTryCatchTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        try {
            Alert alert = chromeDriver.switchTo().alert();
            Assert.assertEquals(alert.getText(), "Hello world!", "Oczekiwany alert nie został wyswietlony");
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert nie został wyświetlony!");
        }
    }

    /**
     * Metoda klika na przycisk o id = clickOnMe i odczekuje 10 sekund
     * ExpectedConditions.alertIsPresent() to warunek, który sprawdza, czy alert jest obecny.
     * Jeśli alert się pojawi w ciągu tych 10 sekund, jest zwracany obiekt Alert, który reprezentuje okno dialogowe.
     * Jeśli alert się nie pojawi w określonym czasie, test zakończy się niepowodzeniem.
     */
    @Test
    public void clickOnElementWithoutTryCatchTest() {
        chromeDriver.findElement(By.id("clickOnMe")).click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Hello world!", "Oczekiwany alert nie został wyswietlony");
        alert.accept();
    }

    @Test
    public void enterValueToInputTest() {
        WebElement input = chromeDriver.findElement(By.id("fname"));
        input.sendKeys("Bartek");
        Assert.assertEquals(input.getAttribute("value"), "Bartek", "Niepoprawna zawartość inputa - fname");
    }

    @Test
    public void removeValueFromInputTest() {
        WebElement input = chromeDriver.findElement(By.name("username"));
        input.clear();
        Assert.assertEquals(input.getAttribute("value"), "", "Niepoprawna zawartość inputa - username");
    }

    @Test
    public void simulateButtonPressTest() {
        WebElement inputUserName = chromeDriver.findElement(By.name("username"));
        inputUserName.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Formularz wyslany", "Oczekiwany alert nie został wyswietlony");
        alert.accept();
        alert.accept();
    }

    @Test
    public void selectCheckBoxTest() {
        WebElement checkBox = chromeDriver.findElement(By.cssSelector("[type=checkbox]"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected(), "Check Box nie został zaznaczony");
    }

    @Test
    public void selectRadioButtonTest() {
        WebElement radioButton = chromeDriver.findElement(By.cssSelector("[value='male']"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected(), "Radio Button nie został zaznaczony");
    }

    @Test
    public void takeItemFromSelectByIdTest() {
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        Select cars = new Select(select);
        cars.selectByIndex(2); // w selekcie numerujemy od 0
        String value = cars.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals(value, "mercedes", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void takeItemFromSelectByVisibleTextTest() {
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        Select cars = new Select(select);
        cars.selectByVisibleText("Saab");
        String selectedTextByVisibleText = cars.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedTextByVisibleText, "Saab", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void takeItemFromSelectByValueTest() {
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        Select cars = new Select(select);
        cars.selectByValue("volvo");
        String selectedValue = cars.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals(selectedValue, "volvo", "Wybrano niepoprawną wartość selectu");
    }

    @Test
    public void takeAllItemFromSelectTest() {
        WebElement select = chromeDriver.findElement(By.cssSelector("select"));
        Select cars = new Select(select);
        List<WebElement> selectOptions = cars.getOptions();
        List<String> actualElements = selectOptions.stream().map(WebElement::getText).toList();
        boolean isEquals = actualElements.containsAll(expectedElements());
        Assert.assertTrue(isEquals, "Pobrana lista wartości z pola select jest niepoprawna");
    }

    private List<String> expectedElements() {
        return Arrays.asList("Mercedes", "Audi", "Saab", "Volvo");
    }

    @Test
    public void takeValueFromInputTest() {
        WebElement input = chromeDriver.findElement(By.name("username"));
        String inputValue = input.getAttribute("value");
        Assert.assertEquals(inputValue, "Mickey", "Nie pobrano oczekiwanej wartości inputa");
    }

    @Test
    public void takeValueFromHiddenElementTest() {
        WebElement hiddenElement = chromeDriver.findElement(By.cssSelector(".topSecret"));
        hiddenElement.getText(); // nie zwróci nic dla ukrytego paragafu
        hiddenElement.getAttribute("value"); // zwróci null dla ukrytego paragafu
        String textContent = hiddenElement.getAttribute("textContent");
        Assert.assertEquals(textContent, "This paragraph should be hidden.", "Nie pobrano oczekiwanej wartości inputa");
    }

    /**
     * Metoda zamyka (akceptuje) wyskakujące prompty
     * gdy wyskoczy alert to linia chromeDriver.switchTo().alert().accept(); przechodzi do niego i go zamyka
     * gdy wyskoczy kolejny alert to identyczna linia kodu robi z nim to samo
     */
    @Test
    public void alertHandlingTest() {
        WebElement input = chromeDriver.findElement(By.name("username"));
        input.sendKeys(Keys.ENTER);
        chromeDriver.switchTo().alert().accept(); // przechodzi do pierwszego alertu i go akceptuje (zamyka)
        chromeDriver.switchTo().alert().accept(); // przechodzi do drugiego alertu i go akceptuje (zamyka)
        Assert.assertTrue(isAlertClosed(), "Pierwszy alert nie został zamknięty.");
    }

    private boolean isAlertClosed() {
        try {
            chromeDriver.switchTo().alert();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }

    @Test
    public void handlingNewWindowTest() {
        String currentWindow = chromeDriver.getWindowHandle(); // wyszukanie nazwy aktualnego okna
        chromeDriver.findElement(By.id("newPage")).click();
        Set<String> windowNames = chromeDriver.getWindowHandles(); // wyszukanie nazw wszystkich otwartych okien
        windowNames.forEach(windowName -> {
            if (!windowName.equals(currentWindow)) { // sprawdzamy czy w zbiorze nazw występuje nazwa różna od naszego aktualnego okna
                chromeDriver.switchTo().window(windowName); // jeśli tak to sie przełączamy
            }
        });
        chromeDriver.findElement(By.id("L2AGLb")).click(); // zamykam drażniace okiengo cookies w google
        chromeDriver.findElement(By.name("q")).sendKeys("Selenium"); // wprowadzam wartość "Selenium" do inputa google
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains("https://www.google.com"), "Oczekiwana strona to Google");
        Assert.assertEquals(chromeDriver.findElement(By.name("q")).getAttribute("value"), "Selenium", "Pole wyszukiwania nie zawiera oczekiwanej wartości 'Selenium'");

        chromeDriver.switchTo().window(currentWindow); // powrót do wcześniejszego okna
        WebElement fname = chromeDriver.findElement(By.name("fname"));
        fname.sendKeys("Barteg"); // wpisanie wartości w inputa
        Assert.assertTrue(chromeDriver.getCurrentUrl().contains("https://testeroprogramowania.github.io/selenium/basics.html"), "Oczekiwana strona to strona podstawowa testowa");
        Assert.assertEquals(fname.getAttribute("value"), "Barteg", "Pole input nie zawiera oczekiwanej wartości 'Barteg'");
        fname.clear();
    }

    @Test
    public void clickRightButtonMouseTest(){
        Actions actions = new Actions(chromeDriver);
        actions.contextClick().perform();
        // do weryfikacji użyć sikuli?
    }

    @Test
    public void clickRightButtonMouseOnElementTest(){
        Actions actions = new Actions(chromeDriver);
        actions.contextClick(chromeDriver.findElement(By.id("fname"))).perform();
        // do weryfikacji użyć sikuli?
    }

    @Test
    public void hoveringOverElementTest(){
        Actions actions = new Actions(chromeDriver);
        WebElement heading = chromeDriver.findElement(By.tagName("h1"));
        String colorBeforeHover = heading.getCssValue("color");
        actions.moveToElement(heading).perform();
        String colorAfterHover = heading.getCssValue("color");
        Assert.assertNotEquals("Kolor nie zmienił się po najechaniu kursorem", colorBeforeHover, colorAfterHover);
    }

    @Test
    public void getTitleAndAddressSiteTest(){
        chromeDriver.getTitle();
        chromeDriver.getCurrentUrl();
        String expectedTitle = "Strona testowa";
        String expectedUrl = "https://testeroprogramowania.github.io/selenium/basics.html";
        Assert.assertEquals(chromeDriver.getTitle(), expectedTitle, "Tytuł strony nie jest zgodny z oczekiwaniami");
        Assert.assertEquals(chromeDriver.getCurrentUrl(), expectedUrl, "URL strony nie jest zgodny z oczekiwaniami");
    }
}
