package day41;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReadingPropertiesFile {

    public static void main(String[] args) throws IOException {

        //Location of property file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");

        //Loading properties file
        Properties properties = new Properties();
        properties.load(file);

        //Reading data from properties file
        String url = properties.getProperty("appurl");
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        String orderid = properties.getProperty("orderid");
        String customerid = properties.getProperty("customerid");

        System.out.println(url + " " + email + " " + password + " " + orderid + " " + customerid);

        //reading all the keys from properties file
        //if all keys string
        Set<String> keys =  properties.stringPropertyNames();
        for(String key:keys){
            System.out.println(key);
        }

        //when keys are different types
        Set<Object> keySet = properties.keySet();
        System.out.println(keySet);


        //Reading all the values from properties file
        Collection<Object> values = properties.values();
        System.out.println(values);
    }
}
