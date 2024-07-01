package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StaticTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> table = driver.findElements(By.cssSelector("[name='BookTable'] tbody tr"));
        System.out.println("Total number of rows: " + table.size());
        for(WebElement e:table){
            System.out.println(e.getText());
        }

        String value = driver.findElement(By.xpath("//*[@name='BookTable']//tr[6]//td[1]")).getText();
        System.out.println(value);
    }
}
