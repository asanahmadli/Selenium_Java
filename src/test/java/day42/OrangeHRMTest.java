package day42;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    /**
     * open application
     * test logo presence
     * login
     * close
     */
    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void openApp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.orangehrm.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void testLogo(){
        boolean status = driver.findElement(By.xpath("//*[@class='navbar-brand nav-logo']")).isDisplayed();
        System.out.println("logo displayed..." + status);
    }

    @Test(priority = 3)
    public void testLogin(){

    }

    @Test(priority = 4)
    public void testLogout(){

    }
}
