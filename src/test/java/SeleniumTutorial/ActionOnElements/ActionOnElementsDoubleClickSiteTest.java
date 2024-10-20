package SeleniumTutorial.ActionOnElements;

import SeleniumTutorial.PageClass.DoubleClickPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Set;

public class ActionOnElementsDoubleClickSiteTest extends DoubleClickPage {

    @Test
    public void doubleClickLeftButtonMouseTest(){
        String currentWindow = chromeDriver.getWindowHandle(); // wyszukanie nazwy aktualnego okna
        Actions actions = new Actions(chromeDriver);
        actions.doubleClick(chromeDriver.findElement(By.id("bottom"))).perform();
        Set<String> windowNames = chromeDriver.getWindowHandles(); // wyszukanie nazw wszystkich otwartych okien
        windowNames.forEach(windowName -> {
            if (!windowName.equals(currentWindow)) { // sprawdzamy czy w zbiorze nazw występuje nazwa różna od naszego aktualnego okna
                chromeDriver.switchTo().window(windowName); // jeśli tak to sie przełączamy
            }
        });
        chromeDriver.findElement(By.id("L2AGLb")).click(); // zamykam drażniace okiengo cookies w google
        Assert.assertTrue(Objects.requireNonNull(chromeDriver.getCurrentUrl()).contains("https://www.google.com"), "Oczekiwana strona to Google");
    }
}
