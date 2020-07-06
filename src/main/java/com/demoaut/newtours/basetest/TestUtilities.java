package com.demoaut.newtours.basetest;

public class TestUtilities extends Base {

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
