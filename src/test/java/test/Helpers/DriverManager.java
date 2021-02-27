package test.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver getDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/home/dereck/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      //  driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        return driver;
    }

    public static void endSession(WebDriver driver){
        driver.quit();
    }
}
