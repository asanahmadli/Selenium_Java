package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUpload {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        //single file upload
        WebElement input = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
        //send file location
        String file1 = "C:\\Users\\asana\\OneDrive\\Desktop\\Test.txt";
        String file2 = "C:\\Users\\asana\\OneDrive\\Desktop\\Test2.txt";
        input.sendKeys(file1 + "\n" + file2);






    }
}
