package day35;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextMenu {

    public static void main(String[] args) {

        WebDriver driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement menu = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions.contextClick(menu).perform();
        WebElement edit = driver.findElement(By.cssSelector("[class='context-menu-item context-menu-icon context-menu-icon-edit']"));
        actions.moveToElement(edit).click().perform();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();
    }
}
