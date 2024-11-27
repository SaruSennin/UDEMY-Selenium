package SeleniumTutorial.P5_TestNG;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Method beforeSuite()");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Method beforeClass()");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Method beforeTest()");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Method beforeMethod()");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Method afterMethod()");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Method afterClass()");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Method afterTest()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Method afterSuite()");
    }
}
