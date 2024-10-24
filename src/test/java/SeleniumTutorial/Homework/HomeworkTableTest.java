package SeleniumTutorial.Homework;

import SeleniumTutorial.PageClass.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomeworkTableTest extends BasePage {

    @Test
    public void checkIfTableExistTest() {
        By table = By.xpath("//table[@border='1']");
        Assert.assertFalse(chromeDriver.findElements(table).isEmpty(), "Nie wykryto oczekiwanej tabeli");
    }

    @Test
    public void checkNumberOfColumnsTest() {
        WebElement table = chromeDriver.findElement(By.xpath("//table[@border='1']"));
        List<WebElement> columns = table.findElements(By.cssSelector(".tableHeader"));// wyszukanie na stronie wszystkich elementow majacych klasę tableHeader
        Assert.assertEquals(columns.size(), 2, "Tabela powinna zawierać 2 kolumny");
    }

    @Test
    public void checkColumnHeadersTest() {
        WebElement table = chromeDriver.findElement(By.xpath("//table[@border='1']"));
        List<WebElement> columns = table.findElements(By.cssSelector(".tableHeader"));
        List<String> requiredList = Arrays.asList("Month", "Savings");
        List<String> columnHeaderlist = columns.stream().map(WebElement::getText).toList();
        Assert.assertEquals(columnHeaderlist, requiredList, "W tabeli nie występuja oczekiwane kolumy lub ich kolejność jest nieprawidłowa");
    }

    @Test
    public void checkNumberOfRowTest() {
//        List<WebElement> rows = chromeDriver.findElements(By.xpath("//table[@border='1']//tr"));
        List<WebElement> rows = chromeDriver.findElements(By.cssSelector("table[border='1'] tr"));
        Assert.assertEquals(rows.size(), 2, "Brak oczekiwanej ilości wierszyw tabeli");
    }

    @Test
    public void checkRowValueTest() {
        List<WebElement> rows = chromeDriver.findElements(By.xpath("//table[@border='1']//tr[2]//td"));
        List<String> requiredRowValues = Arrays.asList("January", "$100");
        List<String> rowValues = rows.stream().map(WebElement::getText).toList();
        Assert.assertEquals(rowValues, requiredRowValues, "We wskazanym wierszu nie występują oczekiwane dane lub są w nieodpowiedniej kolejności");
    }
}
