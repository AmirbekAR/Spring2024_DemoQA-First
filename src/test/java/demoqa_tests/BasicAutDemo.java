package demoqa_tests;

import org.testng.annotations.Test;

public class BasicAutDemo extends BaseTest {

    @Test
    public void basicAutTest() throws InterruptedException {

//        driver.get("http://swis.trade.kg/");
        driver.get("https://admin:admin@practice.expandtesting.com/digest-auth");
        Thread.sleep(5000);

    }
}
