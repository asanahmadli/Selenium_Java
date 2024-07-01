package day38;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshots {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //1. full page screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\screenshots\\fullPage.png");

        sourceFile.renameTo(targetFile); //copy source file to target file

        //2. specific part of page screenshot
        //web element itself is interface
        WebElement element = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File sourceFile2 = element.getScreenshotAs(OutputType.FILE);
        File targetFile2 = new File(System.getProperty("user.dir")+"\\screenshots\\feature.png");
        sourceFile2.renameTo(targetFile2);


        //3. element screenshot
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File sourceFileLogo = logo.getScreenshotAs(OutputType.FILE);
        File targetFileLogo = new File(System.getProperty("user.dir") +"\\screenshots\\logo.png");
        sourceFileLogo.renameTo(targetFileLogo);

    }
}
