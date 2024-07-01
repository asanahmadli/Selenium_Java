package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitCommand {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }
}
