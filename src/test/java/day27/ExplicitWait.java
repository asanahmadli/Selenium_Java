package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    public static void main(String[] args) {
    /**based on condition we apply explicit wait*/
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //usage of explicit wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");


//        driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
//        driver.findElement(By.cssSelector("[type='submit']")).click();
    }
}
