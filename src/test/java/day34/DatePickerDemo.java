package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePickerDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //Method1: using sendkeys() method

        //switch the frame
        WebElement frame = driver.findElement(By.cssSelector("[class='demo-frame']"));
        driver.switchTo().frame(frame);

        //send date
        driver.findElement(By.cssSelector("[id='datepicker']")).sendKeys("12/25/1961");

    }
}
