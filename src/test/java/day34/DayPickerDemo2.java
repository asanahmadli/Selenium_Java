package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DayPickerDemo2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        //switch the frame
        WebElement frame = driver.findElement(By.cssSelector("[class='demo-frame']"));
        driver.switchTo().frame(frame);

        //second method, data has to be in String format

        String year = "2020";
        String month = "May";
        String date = "20";

        //locate datepicker
        driver.findElement(By.cssSelector("[id='datepicker']")).click();

        String elementYear = driver.findElement(By.cssSelector("[class='ui-datepicker-year']")).getText();
        String elementMonth = driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText();


        if (Integer.parseInt(year) >= Integer.parseInt(elementYear)) {
            while (true) {

                if (elementMonth.equals(month) && elementYear.equals(year)) {
                    driver.findElement(By.cssSelector("[data-date='"+date+"']")).click();
                    break;
                }
                WebElement right = driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']"));
                right.click();
                elementYear = driver.findElement(By.cssSelector("[class='ui-datepicker-year']")).getText();
                elementMonth = driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText();
            }
        } else {
            while (true) {

                if (elementMonth.equals(month) && elementYear.equals(year)) {
                    driver.findElement(By.cssSelector("[data-date='20']")).click();
                    break;
                }
                WebElement right = driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']"));
                right.click();
                elementYear = driver.findElement(By.cssSelector("[class='ui-datepicker-year']")).getText();
                elementMonth = driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText();
            }
        }


    }
}
