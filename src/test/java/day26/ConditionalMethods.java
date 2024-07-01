package day26;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ConditionalMethods {
    public static void main(String[] args) {

        WebDriver chrome = new ChromeDriver();
        chrome.get("https://demo.nopcommerce.com/register");
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //isDisplayed
        boolean logo = chrome.findElement(By.cssSelector(".header-logo a img")).isDisplayed();
        System.out.println("Display Status of Logo: "+logo);

        //isEnabled()
        boolean enabled = chrome.findElement(By.xpath("//*[@id='FirstName'][@name='FirstName']")).isEnabled();
        System.out.println("Element is enabled: " + enabled);

        //isSelected()
        WebElement male = chrome.findElement(By.xpath("//input[@id='gender-male']"));
        WebElement female = chrome.findElement(By.xpath("//input[@id='gender-female']"));
        System.out.println("Male selected: " + male.isSelected());
        System.out.println("Female selected: " + female.isSelected());
        male.click();
        System.out.println("Male selected: " + male.isSelected());

        WebElement checkBox = chrome.findElement(By.xpath("//input[@id='Newsletter']"));
        checkBox.click();
        System.out.println("Checkbox is selected: " + checkBox.isSelected());

    }
}
