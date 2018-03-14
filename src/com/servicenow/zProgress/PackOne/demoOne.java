package com.servicenow.zProgress.PackOne;

import org.testng.annotations.Test;

public class demoOne {
    @Test(timeOut=1000)
    public void firstTestCase() throws InterruptedException
    {
        System.out.println("im in first test case from demoOne Class");
        Thread.sleep(1500);
    }
    @Test
    public void secondTestCase()
    {
        System.out.println("im in second test case from demoOne Class");
    }
}