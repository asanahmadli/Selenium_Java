package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class BlockAdds {
    public static void main(String[] args) {

        //store CRX file in file object
        File file = new File("C:\\Users\\asana\\OneDrive\\Desktop\\Resume\\uBlock-Origin.crx");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file);

        //1.Launch browser
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        chromeDriver.get("https://text-compare.com");
        chromeDriver.manage().window().maximize();
        //chromeDriver.quit();
    }
}
