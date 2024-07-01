package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DoubleClick {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
        driver.manage().window().maximize();

        //switch to iframe
        driver.switchTo().frame("iframeResult");


        //locate the element needs to use actions
        WebElement btn = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));

        //create actions object and pass driver
        Actions actions = new Actions(driver);
        //perform double-click
        actions.doubleClick(btn).perform();

        //
        String hello = driver.findElement(By.xpath("//p[@id='demo']")).getText();
        System.out.println(hello);

    }
}
