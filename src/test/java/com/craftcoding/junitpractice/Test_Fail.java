package com.craftcoding.junitpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class Test_Fail {
    @Test
    public void testTheMethodNotYetImplemented(){
        fail("method not yet Implemented!!!");
    }

    @Test
    void testTheMethodNotYetImplemented1(){
        fail(()->"method not yet implemented!!!");
    }

    @Test
    void testTheMethodNotYetImplemented2(){
        try{
            int i =10;
            int j = 0;
            int result = i/j;
            fail("failed expected Exception but not raised");
        }
        catch (Exception e){

        }
    }


}
