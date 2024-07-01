package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        WebDriver chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chrome.navigate().to("https://demoblaze.com/index.html");
        chrome.manage().window().maximize();
        List<WebElement> links = chrome.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());
        List<WebElement> images = chrome.findElements(By.tagName("img"));
        System.out.println("Total Images: " + images.size());
        chrome.findElement(By.partialLinkText("galaxy s6")).click();
        chrome.quit();
    }
}
