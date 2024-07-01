package day29;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckBoxes {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //select check box
//        WebElement sunday = driver.findElement(By.id("sunday"));
//        System.out.println(sunday.isSelected());
//        sunday.click();
//        System.out.println(sunday.isSelected());

        //check all checkbox and make sure they are checked
        List<WebElement> checkbox = driver.findElements(By.xpath("(//*[@class='form-group'])[4]/div/input"));
        System.out.println("Total checkboxes "+ checkbox.size());
        for(WebElement element:checkbox){
            System.out.println(element.getAttribute("value")+" "+ element.isSelected());
            element.click();
            System.out.println(element.getAttribute("value")+" "+ element.isSelected());
        }

        //uncheck selected checkboxes
        List<WebElement> checkbox1 = driver.findElements(By.xpath("(//*[@class='form-group'])[4]/div/input"));
        System.out.println("Total checkboxes1 "+ checkbox1.size());
        for(WebElement element:checkbox1){
            if(element.isSelected()){
                element.click();
            }
            System.out.println(element.getAttribute("value")+" "+ element.isSelected());
        }

        //select random checkboxes
        List<WebElement> checkbox2 = driver.findElements(By.xpath("(//*[@class='form-group'])[4]/div/input"));
        for(int i=0;i<checkbox2.size();i++){
            if(i==0||i==3||i==5||i==6){
                checkbox2.get(i).click();
            }
        }



        //driver.quit();
    }
}
