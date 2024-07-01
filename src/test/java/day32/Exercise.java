package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {

        //launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //land on homepage
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        //select your option from first dropdown
        WebElement departure = driver.findElement(By.xpath("//*[@name='fromPort']"));
        Select select1 = new Select(departure);
        select1.selectByVisibleText("Boston");

        //select your option from second dropdown
        WebElement destination = driver.findElement(By.xpath("//*[@name='toPort']"));
        Select select2 = new Select(destination);
        select2.selectByVisibleText("Rome");

        //click submit button
        driver.findElement(By.className("btn-primary")).click();

        //locate last column and store in the list of webelement
        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='container']/table/tbody//td[6]"));

        //locate first value  of last column element and substring not using dollar sign and  convert to double and assign to double type variable
        double lowestPrice = Double.parseDouble(driver.findElement(By.xpath("//*[@class='container']/table/tbody/tr[1]/td[6]")).getText().substring(1));

        //loop through each element values and compare if value less than double variable and update variable
        for(WebElement e:prices){
            double price = Double.parseDouble(e.getText().substring(1));

            if(price<lowestPrice){
            lowestPrice = price;
            }
        }

        //print result lowest price
        System.out.println("Lowest Price: $" + lowestPrice);
    }
}
