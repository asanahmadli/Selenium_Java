package day36;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardActions {

    public static void main(String[] args) {

        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        //locate left board and send value
        WebElement left = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        left.sendKeys("Hello World!");

        Actions actions = new Actions(driver);
        //select all  the text
        actions.moveToElement(left).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //copy the text
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //switch to right board
        WebElement right = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //past the text to the right
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
        driver.switchTo().newWindow(WindowType.WINDOW);



    }
}
