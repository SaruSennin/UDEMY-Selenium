package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeworkFormTest extends BasePage {

    @Test
    public void checkFormTest() {
        WebElement inputName = chromeDriver.findElement(By.name("username"));
        WebElement inputPassword = chromeDriver.findElement(By.name("password"));
        Assert.assertEquals(inputName.getAttribute("value"), "Mickey", "Błąd - domyślny login niepoprawny");
        Assert.assertEquals(inputPassword.getAttribute("value"), "Mouse", "Błąd - domyślne hasło niepoprawne");
        inputName.clear();
        inputPassword.clear();
        Assert.assertEquals(inputName.getAttribute("value"), "", "Błąd - pole powinno być puste");
        Assert.assertEquals(inputPassword.getAttribute("value"), "", "Błąd - pole powinno być puste");
        inputName.sendKeys("Nazwa użytkownika");
        inputPassword.sendKeys("Hasło użytkownika");
        Assert.assertEquals(inputName.getAttribute("value"), "Nazwa użytkownika", "Błąd - nie znaleziono oczekiwanej wprowadzonej wartości");
        Assert.assertEquals(inputPassword.getAttribute("value"), "Hasło użytkownika", "Błąd - nie znaleziono oczekiwanej wprowadzonej wartości");
        Assert.assertTrue(inputName.isDisplayed(), "Błąd - pole powinno być wyświetlone");
        Assert.assertTrue(inputPassword.isDisplayed(), "Błąd - pole powinno być wyświetlone");
        Assert.assertTrue(inputName.isEnabled(), "Błąd - pole powinno być aktywne");
        Assert.assertTrue(inputPassword.isEnabled(), "Błąd - pole powinno być aktywne");
    }

    @Test
    public void checkSubmitButtonTest() {
        WebElement buttonSubmit = chromeDriver.findElement(By.cssSelector("input[type='submit']"));
        Assert.assertTrue(buttonSubmit.isEnabled(), "Przycisk powinien być dostępny");
        Assert.assertTrue(buttonSubmit.isDisplayed(), "Przycisk powinien być widoczny");
        buttonSubmit.click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Formularz wyslany", "Oczekiwany alert nie został wyswietlony");
        alert.accept();
        Assert.assertEquals(alert.getText(), "On submit method", "Oczekiwany alert nie został wyswietlony");
        alert.accept();
    }
}
