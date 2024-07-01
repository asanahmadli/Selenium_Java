package day22;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LocatorsDemo {
    public static void main(String[] args) {


        WebDriver chromeDriver = new ChromeDriver();     //creating google Chrome browser session
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);      //implicit wait
        chromeDriver.get("https://demo.opencart.com/");     //get specific website using get() method
        chromeDriver.manage().window().maximize();      //maximize window
        WebElement searchBox = chromeDriver.findElement(By.name("search"));     //using name locator
        searchBox.sendKeys("MacBook");      //send text into search bar
        chromeDriver.findElement(By.className("btn-lg")).click();   //using className locator
        boolean status = chromeDriver.findElement(By.id("logo")).isDisplayed();
        System.out.println(status);

        chromeDriver.findElement(By.id("button-list")).click();
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;  //js executor
        js.executeScript("window.scrollBy(0,600)");
        WebElement element =  chromeDriver.findElement(By.xpath("//a[text() = 'MacBook']"));
       // js.executeScript("arguments[0].scrollIntoView();",element);   //scroll until see element
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));   //explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        //chromeDriver.quit();


    }
}
