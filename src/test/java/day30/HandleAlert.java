package day30;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleAlert {
    public static void main(String[] args) {

        //launch the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //click the alert
            WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
            element.click();
            //driver.switchTo().alert().accept(); if you dont use explicit wait use this command
            //wait alert show up and accept the alert

            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert was present and accepted.");
            //confirm the alert got clicked
            String actual = driver.findElement(By.xpath("//*[@id='result']")).getText();
            System.out.println(actual.equals("You successfully clicked an alert"));
        }
        catch (Exception e){
            System.out.println("No alert appeared");
        }


        //second alert
        try {
            //click the alert
            WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
            element.click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert was present and accepted.");
            //confirm the alert got clicked
            String actual = driver.findElement(By.xpath("//*[@id='result']")).getText();
            System.out.println(actual.equals("You clicked: Ok"));
        }
        catch (Exception e){
            System.out.println("No alert appeared");
        }


        //third alert
        try {
            //click the alert
            WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
            element.click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            //get text from alert window
            System.out.println(alert.getText());
            alert.sendKeys("Hello World!");
            alert.accept();
            System.out.println("Alert was present and accepted.");
            //confirm the alert got clicked
            String actual = driver.findElement(By.xpath("//*[@id='result']")).getText();
            System.out.println(actual.equals("You entered: Hello World!"));
        }
        catch (Exception e){
            System.out.println("No alert appeared");
        }

    }
}
