package day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2#google_vignette");
        driver.manage().window().maximize();
       WebElement bootstrapDropdown =  driver.findElement(By.xpath("//button[@title='HTML, CSS']"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bootstrapDropdown));
        element.click();
        List<WebElement> drops = driver.findElements(By.cssSelector(".multiselect-container.dropdown-menu li a label input"));
        System.out.println("Total options "+ drops.size());
        for(WebElement ele:drops){
//           if(ele.getAttribute("value").equals("Java")){
//               ele.click();
//           }
//           else if(ele.getAttribute("value").equals("Oracle")){
//               ele.click();
//           }
//           else if(ele.isSelected()){
//               ele.click();
//           }
            if(!ele.isSelected()){
                ele.click();
            }

        }

    }
}
