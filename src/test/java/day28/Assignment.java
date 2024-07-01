package day28;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Assignment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //provide string search
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
        driver.findElement(By.className("wikipedia-search-button")).click();

        //store all the links and click them
        List<WebElement> links = driver.findElements(By.cssSelector("[id='wikipedia-search-result-link'] a"));
        System.out.println("Total links: " + links.size());
        for(WebElement element:links){
            System.out.println(element.getText());
            element.click();
        }

        //store all the window ids in set and add to list
        Set<String> ids = driver.getWindowHandles();
        List<String> windowIds = new ArrayList<>(ids);

        //close page title name with Selenium (software) - Wikipedia
        for(String id:windowIds){
            String pageTitle = driver.switchTo().window(id).getTitle();
            if(pageTitle.equals("Selenium (software) - Wikipedia")){
                System.out.println(driver.getCurrentUrl());
                driver.close();
            }
        }

    }
}
