package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class EnableExtensions {
    public static void main(String[] args) {

        /** blocking adds only possible with automation once you first enable add blocking extension then extension will block all
         * adds
         * 1.Get CRX Extractor/Downloader (manually download from google) - we can use this to get any extension crx file
         * 2.Add your extension from google store to browser
         * whichever extension you want to enable on run time get crx file of that extension
         * 3.Download CRX file of selectorhub
         * Create File object and pass path to new File() then options.addExtension(file)
         */
        ChromeOptions options = new ChromeOptions();
        File file = new File("C:\\Users\\asana\\OneDrive\\Desktop\\Resume\\SelectorsHub.crx");
        options.addExtensions(file);

        //1.Launch browser
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://demo.opencart.com");
        String actualTitle = chromeDriver.getTitle();
        String expectedTitle = "Your Store";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //chromeDriver.quit();
    }
}
