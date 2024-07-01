package day21;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 1.Launch browser
 * 2.Open URL https://demo.opencart.com
 * 3.Validate title should be "Your Story"
 * 4.Close browser
 */
public class FirstTestCase {
    public static void main(String[] args) {

        //1.Launch browser
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demo.opencart.com");
        String actualTitle = chromeDriver.getTitle();
        String expectedTitle = "Your Store";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        chromeDriver.quit();

        WebDriver chromeDriver2 = new ChromeDriver();
        chromeDriver2.get("https://demo.nopcommerce.com");
        String actualTitle2 = chromeDriver2.getTitle();
        String expectedTitle2 = "nopCommerce demo store";
        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println("Test2 Passed");
        } else {
            System.out.println("Test2 Failed");
        }
        chromeDriver2.quit();
    }
}
