package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicTable {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();

        // Click on submit button
        driver.findElement(By.className("btn-primary")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement salesMenu = driver.findElement(By.xpath("//*[@id='column-left']/ul/li[6]"));
        wait.until(ExpectedConditions.elementToBeClickable(salesMenu)).click();

        WebElement customersLink = driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]"));
        wait.until(ExpectedConditions.elementToBeClickable(customersLink)).click();

        // Scroll side bar until element visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement textElement = driver.findElement(By.xpath("//*[@class='col-sm-6 text-end']"));
        js.executeScript("arguments[0].scrollIntoView(true);", textElement);

        String text = textElement.getText();
        String[] arr = text.substring(text.indexOf("(") + 1, text.indexOf(")")).split(" ");

        int pages = Integer.parseInt(arr[0]);
        System.out.println("Total pages: " + pages);

        for (int i = 1; i < pages; i++) {
            WebElement nextPageBtn = driver.findElement(By.xpath("//a[normalize-space()='>']"));
            js.executeScript("arguments[0].scrollIntoView(true);", nextPageBtn);

            wait.until(ExpectedConditions.elementToBeClickable(nextPageBtn)).click();

            // Adding a small wait to ensure the page is loaded
            wait.until(ExpectedConditions.stalenessOf(nextPageBtn));

            if (i == 3) {
                WebElement cell = driver.findElement(By.cssSelector(".table.table-bordered.table-hover tbody tr td"));
                String cellText = cell.getText();
                System.out.println("Data from cell: " + cellText);
            }
        }

        driver.quit();
    }
}
