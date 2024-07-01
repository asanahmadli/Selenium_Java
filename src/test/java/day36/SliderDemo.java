package day36;

import day35.DragDrop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SliderDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement mini_slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));

        //print out location of slider. It comes from Point class
        System.out.println("Location of slider " + mini_slider.getLocation());

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(mini_slider,400,249).perform();
        System.out.println("Location of slider " + mini_slider.getLocation());


    }
}
