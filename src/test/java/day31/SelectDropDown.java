package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectDropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        WebElement dropCountryDown = driver.findElement(By.id("country"));
        Select drops = new Select(dropCountryDown);

        //select option from the drop down
        Thread.sleep(3000);
        drops.selectByVisibleText("India");
        Thread.sleep(3000);
        drops.selectByValue("uk");
        Thread.sleep(3000);
        drops.selectByIndex(4);


        //capture the options from the dropdown
        List<WebElement> options = drops.getOptions();
        System.out.println("Total number of options "+options.size());
        for(WebElement element:options){
            System.out.println(element.getText());
        }




    }
}
