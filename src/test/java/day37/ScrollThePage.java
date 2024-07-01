package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollThePage {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //we can scroll the page until element visible or based on pixels or end of the page
        //scrolling bar is not web element


        JavascriptExecutor js = (JavascriptExecutor) driver;

        //first approach
        /**js.executeScript("window.scrollBy(0,1500)","");
        System.out.println(js.executeScript("return window.pageYOffset;"));
        System.out.println(js.executeScript("return window.pageXOffset;"));*/

//        WebElement element = driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
//        //second approach
//        js.executeScript("arguments[0].scrollIntoView()",element);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
         System.out.println(js.executeScript("return window.pageYOffset;"));
         System.out.println(js.executeScript("return window.pageXOffset;"));

         Thread.sleep(5000);
         //go to initial position
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

    }
}
