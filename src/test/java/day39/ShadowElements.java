package day39;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowElements {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://dev.automationtesting.in/shadow-dom");
        driver.manage().window().maximize();

        SearchContext shadow = driver.findElement(By.cssSelector(".MuiBox-root.css-13o7eu2")).getShadowRoot();
       String str =  shadow.findElement(By.cssSelector("#shadow-element")).getText();
        System.out.println(str);

        SearchContext nestedShadow = shadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        String str2 = nestedShadow.findElement(By.cssSelector("#nested-shadow-element")).getText();
        System.out.println(str2);

        SearchContext multiNestedShadow = nestedShadow.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        String str3 = multiNestedShadow.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
        System.out.println(str3);

    }
}
