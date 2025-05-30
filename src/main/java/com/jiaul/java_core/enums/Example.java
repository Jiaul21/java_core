package com.jiaul.java_core.enums;

import lombok.ToString;

@ToString
enum Season {

    WINTER(5), SPRING(10), SUMMER(15), FALL(20);
    private int val;
     Season(int val) {
        this.val = val;
    }
    public void dis(){

    }
}

public class Example {
    public static void main(String[] args) {
        Season[] s=Season.values();
        System.out.println(s[0]);       // Season.WINTER(val=5)
        System.out.println(Season.SPRING);      // Season.SPRING(val=10)
        System.out.println(Season.SPRING.ordinal());    // 1
        System.out.println(Season.valueOf("SUMMER"));   //Season.SUMMER(val=15)
    }
}
