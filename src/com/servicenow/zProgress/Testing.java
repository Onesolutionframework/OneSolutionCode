package com.servicenow.zProgress;

import com.servicenow.utilities.ExceptionHandler;
import org.testng.annotations.Test;

public class Testing {

    @Test
    void print() throws ExceptionHandler {
        //try {
            System.out.println("hello");
            int i=1/0;
        /*}catch (Exception e){
            throw new ExceptionHandler(e);
        }*/
    }
}
