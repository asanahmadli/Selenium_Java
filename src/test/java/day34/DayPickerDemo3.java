package day34;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

public class DayPickerDemo3 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        String expectedYear = "2018";
        String expectedMonth = "September";
        String expectedDay = "24";

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //switch to iframe use id
        driver.switchTo().frame("frame-one796456169");

        //scroll until calendar element
        WebElement calendar = driver.findElement(By.cssSelector("[class='icon_calendar']"));
        js.executeScript("arguments[0].scrollIntoView(true)", calendar);
        calendar.click();

        //click dropdown
        WebElement dropBox = driver.findElement(By.cssSelector("[class='ui-datepicker-year']"));
        dropBox.click();

        //select all years and choose the year
        Select select = new Select(dropBox);
        select.selectByVisibleText(expectedYear);

        // located current month
        WebElement mon = driver.findElement(By.cssSelector("[class='ui-datepicker-month']"));

        //get int value for month
        YearMonth currentMonth = YearMonth.of(Integer.parseInt(expectedYear), Month.valueOf(mon.getText().toUpperCase()));
        YearMonth expectedMon = YearMonth.of(Integer.parseInt(expectedYear), Month.valueOf(expectedMonth.toUpperCase()));


        //compare less than zero click next
        if (currentMonth.compareTo(expectedMon) < 0) {
            while (true) {

                String text = driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText();

                if (expectedMonth.equals(text)) {
                    driver.findElement(By.cssSelector("[data-date='" + expectedDay + "']")).click();
                    break;
                }
                WebElement next = driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']"));
                next.click();
            }

        } else {
            while (true) {

                String text = driver.findElement(By.cssSelector("[class='ui-datepicker-month']")).getText();

                if (expectedMonth.equals(text)) {
                    driver.findElement(By.cssSelector("[data-date='" + expectedDay + "']")).click();
                    break;
                }
                WebElement prev = driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-w']"));
                prev.click();
            }
        }

    }
}
