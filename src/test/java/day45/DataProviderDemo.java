package day45;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {

    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "dp")
    void testLogin(String email, String pwd) {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        boolean status = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
        if (status) {
            driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
            driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")).click();
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }


    @DataProvider(name = "dp")
    Object[][] loginData() {

        Object data[][] = {
                {"asdasd@gmail.com", "test123"},
                {"sdasdas@gmail.com", "test543"},
                {"gdfgdg@gmail.com", "asas23"},
                {"dasdasd@gmail.com", "2324asd"},
                {"aaabbbqwe@gmail.com", "Legion321"}
        };

        return data;
    }

}
