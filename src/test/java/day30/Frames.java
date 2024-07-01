package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frames {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //Frame1
        WebElement frame1 = driver.findElement(By.cssSelector("[src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.cssSelector("input[name='mytext1']")).sendKeys("Welcome");
        driver.switchTo().parentFrame();

        //Frame2
        WebElement frame2 = driver.findElement(By.cssSelector("[src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.cssSelector("input[name='mytext2']")).sendKeys("World");
        driver.switchTo().parentFrame();
        //Frame3
        WebElement frame3 = driver.findElement(By.cssSelector("[src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.cssSelector("input[name='mytext3']")).sendKeys("From");

        WebElement iframe = driver.findElement(By.cssSelector("[src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='AB7Lab Id5V1'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='uHMk6b fsHoPb'])[1]")).click();
        driver.switchTo().parentFrame();


    }
}
