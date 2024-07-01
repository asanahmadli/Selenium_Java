package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class JSExecutorDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //passing the text into inputbox - alternate of sendkeys()
        js.executeScript("arguments[0].setAttribute('value','John')",inputBox);

        //when sendKeys or click methods not working then we use js executor

        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='female']"));
        js.executeScript("arguments[0].click()",radioBtn);




    }
}
