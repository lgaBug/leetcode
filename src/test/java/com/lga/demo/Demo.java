package com.lga.demo;

import org.junit.Test;

public class Demo {


    @Test
    public void testForEachException() {
            for (int i = -5; i < 10; i++) {

                try {
                    int b = 5 / i;
                }catch (Exception e) {
                    System.out.println("exception...");
                }
                System.out.println("i = " + i);

            }
        }

}
