package SeleniumTutorial.ActionOnElements;

import SeleniumTutorial.PageClass.IframePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionOnElementsIframeSiteTest extends IframePage {

    @Test
    public void switchingBetweenIframesUsingIndexTest(){
        chromeDriver.switchTo().frame(0);// podajemy id ifrema (numerujemy od 0) jeśli wchodzimy w iframe iframe podajemy kolejny numer id
        WebElement textField = chromeDriver.findElement(By.id("fname"));
        textField.sendKeys("barteg");
        Assert.assertEquals(textField.getAttribute("value"), "barteg", "Pole tekstowe nie zostało uzupełnione prawidłowo!");
        chromeDriver.switchTo().defaultContent();
        String headingText = chromeDriver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(headingText, "To jest test iframe", "Nie wróciliśmy do domyślnego okna lub nagłówek h1 nie jest zgodny z oczekiwaniami!");
    }

    @Test
    public void switchingBetweenIframesUsingWebElementTest(){
        WebElement iframe = chromeDriver.findElement(By.cssSelector("[src='basics.html']"));
        chromeDriver.switchTo().frame(iframe);// podajemy wartość selektora z tagu <iframe>
        WebElement textField = chromeDriver.findElement(By.id("fname"));
        textField.sendKeys("barteg");
        // dodatkowo możemy użyć metody frame gdzie jako argument możemy użyć atrybutu id lub name ale podstawowa strona ich nie ma
        Assert.assertEquals(textField.getAttribute("value"), "barteg", "Pole tekstowe nie zostało uzupełnione prawidłowo!");
        chromeDriver.switchTo().defaultContent(); // powrót do pierwotnego okna
        String headingText = chromeDriver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(headingText, "To jest test iframe", "Nie wróciliśmy do domyślnego okna lub nagłówek h1 nie jest zgodny z oczekiwaniami!");
    }
}
