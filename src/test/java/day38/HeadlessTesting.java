package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

    public static void main(String[] args) {

        //headless browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); //setting for headless mode of execution

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
        chromeDriver.quit();


    }
}
