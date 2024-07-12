package day43;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

    @Test
    void test(){
        // Create a SoftAssert instance
        SoftAssert softAssert = new SoftAssert();

        // Perform assertions
        System.out.println("Starting test...");
        softAssert.assertEquals(1, 2, "First assertion failed");
        System.out.println("First assertion completed");



        softAssert.assertTrue(false, "Second assertion failed");
        System.out.println("Second assertion completed");

        softAssert.assertFalse(true, "Third assertion failed");
        System.out.println("Third assertion completed");

        softAssert.assertFalse(false, "Fourth assertion passed");
        System.out.println("Fourth assertion completed");

        // Call assertAll() to aggregate results and report all failures
        System.out.println("All assertions checked");
        softAssert.assertAll();

    }

    @Test
    void test1(){
        //softAssert = new SoftAssert();

    }
}
