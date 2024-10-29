package SeleniumTutorial.P2_ActionOnElements;

import SeleniumTutorial.PageClass.FileUploadClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActionOnElementsFileUploadSiteTest extends FileUploadClass {

    @Test
    public void fileUploadTest(){
        chromeDriver.findElement(By.id("myFile")).sendKeys("C:\\Users\\programista\\Documents\\blikTezdowy.txt");
        String attribute = chromeDriver.findElement(By.id("myFile")).getAttribute("value");
        Assert.assertEquals(extractFileName(attribute), "blikTezdowy.txt", "Nie załadowano pliku");
        // można też uzyć sikuli do weryfikacji czy zostało otwarte okno pliku
    }

    private String extractFileName(String path) {
        return (path != null) ? path.substring(path.lastIndexOf('\\') + 1) : "nie znaleziono ścieżki";
    }

    @Test
    public void screenshotTest() throws IOException {
        chromeDriver.findElement(By.id("myFile")).sendKeys("C:\\Users\\programista\\Documents\\blikTezdowy.txt");
        TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/resources/screenshot.png");
        FileUtils.copyFile(srcFile, destFile);
        Assert.assertTrue(destFile.exists(), "Zrzut ekranu nie został zapisany prawidłowo!");
    }

    @Test
    public void screenshotWithUniqueNameTest() throws IOException {
        chromeDriver.findElement(By.id("myFile")).sendKeys("C:\\Users\\programista\\Documents\\blikTezdowy.txt");
        TakesScreenshot screenshot = (TakesScreenshot) chromeDriver;
        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/resources/screenshot_" + formattedDateTime + ".png");
        FileUtils.copyFile(srcFile, destFile);
        Assert.assertTrue(destFile.exists(), "Zrzut ekranu nie został zapisany prawidłowo!");
    }
}
