package day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links "+links.size());


        //count broken link
        int brokenLinks = 0;
        int emptyHref =0;

            //capture all the link
            for (int i = 0; i < links.size(); i++) {
                String href = links.get(i).getAttribute("href");
                if (href.isEmpty() || href == null) {
                    System.out.println("Href attribute value null is or empty");
                    emptyHref++;
                    continue;
                }

                try {
                //hit url to the server
                URL linkURL = new URL(href);    //converted href value from string to URL format
                //cast link to HttpURLConnection
                HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();  //open connection to the server
                connection.connect();

                //get response code
                if (connection.getResponseCode() >= 400) {
                    System.out.println("Broken Link " + href);
                    brokenLinks++;
                } else {
                    System.out.println("Not a broken link " + href);
                }
            }catch (Exception e){

                }
        }
        System.out.println("Empty links " + emptyHref);
        System.out.println(brokenLinks);
        driver.quit();
    }
}
