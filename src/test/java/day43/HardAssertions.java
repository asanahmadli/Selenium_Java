package day43;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
    @Test
    void test() {
        Assert.assertEquals(true, true);
        Assert.assertNotEquals(123,"123");
    }

    @Test
    void test2(){
        Assert.assertTrue(1==1);
        Assert.assertFalse(1==2);
    }

    @Test
    void fail(){
        //automatically fail your test case
        Assert.fail();
    }

}