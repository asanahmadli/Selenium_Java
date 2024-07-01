package day28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleBrowserWindows {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> ids = driver.getWindowHandles();
        List<String> list = new ArrayList<>(ids);
        System.out.println("Parent window id: " + list.get(0));
        System.out.println(driver.getTitle());
        driver.switchTo().window(list.get(1));
        System.out.println("Child window id: " + list.get(1));
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector(".d-flex.web-menu-btn ul > li:nth-child(2) a button")).click();
        System.out.println(driver.getTitle());
        driver.switchTo().window(list.get(0));
        System.out.println(driver.getTitle());

        //when you have multiple windows then loop through then get title in each window if title equals expected title do action
        for(String id:list){
            String pageTitle = driver.switchTo().window(id).getTitle();
            if(pageTitle.equals("OrangeHRM")){
                System.out.println("You are on the Home Page");
            }
            else if(pageTitle.equals("Get in Touch with OrangeHRM Sales | OrangeHRM")){
                System.out.println("You are on the Human Resources");
                driver.close();
            }
        }
        driver.quit();
    }
}
