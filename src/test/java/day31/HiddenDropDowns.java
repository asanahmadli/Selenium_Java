package day31;
//oxd-select-option

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HiddenDropDowns {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        //login to app
        driver.findElement(By.cssSelector("[placeHolder='Username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("[placeHolder='Password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        //click PIM menu
        driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
        //click Dropdown
        driver.findElement(By.xpath("(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")).click();
        Thread.sleep(3000);
        //choose single option
       // driver.findElement(By.xpath("//span[normalize-space()='test']")).click();

        List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
        System.out.println(options.size());




       for(WebElement el:options){
           System.out.println(el.getText());
        }


    }
}
