package day41;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class FDCalculator {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/indus-ind-bank/fixed-deposit-calculator-IIB-BII001.html");
        driver.manage().window().maximize();

        WebElement notification = driver.findElement(By.id("wzrk-cancel"));
        notification.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        /**we need to send set of data from excel to calculator*/

        //1.step find the excel file path
        String filePath = System.getProperty("user.dir") + "\\testdata\\TestData.xlsx";

        //2.find the rows of the excel sheet
        int rows = ExcelUtils.getRowCount(filePath, "Sheet1");

        for (int i = 1; i <= rows; i++) {


            //read data from excel
            String principal = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
            String rateofinterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
            String period1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
            String period2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
            String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
            String exp_mvalue = ExcelUtils.getCellData(filePath, "Sheet1", i, 5);

            //pass above data into application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

            WebElement period = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
            Select select = new Select(period);
            select.selectByVisibleText("year(s)");

            WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
            Select select1 = new Select(frequency);
            select1.selectByVisibleText("Simple Interest");

            //validation
            WebElement calculate = driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
            calculate.click();

            String actualValue = driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();

            System.out.println(actualValue);
            if (Double.parseDouble(actualValue) == Double.parseDouble(exp_mvalue)) {
                System.out.println("Test Passed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
                ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
                ExcelUtils.setCellData(filePath, "Sheet1", i, 8, actualValue);
            } else {

                System.out.println("Test Failed");
                ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
                ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
                ExcelUtils.setCellData(filePath, "Sheet1", i, 8, actualValue);
            }

            WebElement cancel = driver.findElement(By.xpath("//img[@class='PL5']"));
            cancel.click();

        }

    }
}
