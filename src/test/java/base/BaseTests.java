package base;

import SitePages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTests {

    private WebDriver webDriver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Omar Saeed\\Downloads\\Compressed\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void goHome()
    {
        webDriver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(webDriver);
    }
//    @AfterMethod
//    public void takeScreenshot()
//    {
//        var camera = (TakesScreenshot)webDriver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
//        try{
//            Files.move(Paths.get(screenshot.getAbsolutePath()), Paths.get("resources/screenshots/" + screenshot.getName()));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
    public static void main(String args[])
    {
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
