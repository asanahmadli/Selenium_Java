package day42;

import org.testng.annotations.Test;

public class FirstTestCase {

    //Open up application
    //Login to application
    //logout

    @Test(priority = 0)
    public void openApp(){
        System.out.println("opening application...");
    }

    @Test(priority = 1)
    public void login(){
        System.out.println("Login to application...");
    }

    @Test(priority = -2)
    public void logout(){
        System.out.println("Logout from application...");
    }

}
