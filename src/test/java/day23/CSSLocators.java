package day23;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSLocators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts"); //tag#id
        driver.findElement(By.cssSelector("button.button-1.search-box-button")).click();    //tag.className use dot add more class names
        driver.navigate().back();
    }
}
