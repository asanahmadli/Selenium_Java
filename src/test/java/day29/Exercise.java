package day29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {

        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/radio-buttons");
        driver.manage().window().maximize();
        List<WebElement> radio = driver.findElements(By.className("form-check-input"));
        for(WebElement element:radio){

            if(element.isEnabled()){
                element.click();
            }
           else if(!element.isEnabled()) {
                System.out.println(element.getAttribute("value") + " "+element.isEnabled());
            }

        }

        //check specific radio button
        for(WebElement element:radio){
             if(element.getAttribute("value").equals("yellow")){
                element.click();
            }
        }
    }
}
