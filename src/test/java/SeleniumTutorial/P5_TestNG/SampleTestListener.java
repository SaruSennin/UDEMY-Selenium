package SeleniumTutorial.P5_TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Rozpoczęcie testu");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test zakończony sukcesem");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test zakończony porażką");
    }
}
