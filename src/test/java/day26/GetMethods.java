package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class GetMethods {
    public static void main(String[] args) {

        WebDriver chrome = new ChromeDriver();

        //get() launch the application
        chrome.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        chrome.manage().window().maximize();    //maximize window
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //implicit wait
        String currentTitle = chrome.getTitle();   //get current page title
        System.out.println(currentTitle);

        String currentUrl = chrome.getCurrentUrl();     //getCurrentUrl()
        System.out.println(currentUrl);

        //getPageSource()
        String pageSource = chrome.getPageSource();
        System.out.println(pageSource);

        //window id is string and each time get changes
        System.out.println("Current Window ID "+chrome.getWindowHandle());

        chrome.findElement(By.linkText("OrangeHRM, Inc")).click();
        //get windowHandles
        Set<String> ids = chrome.getWindowHandles();
        int i = 0;
        for (String id:ids){
            System.out.println(id+"-"+(++i));
        }

        chrome.close(); // close focused web page

        chrome.quit();  //quite browser
    }
}
