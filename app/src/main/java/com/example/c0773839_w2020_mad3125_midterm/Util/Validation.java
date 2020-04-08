package com.example.c0773839_w2020_mad3125_midterm.Util;

public class Validation {

    static boolean sin(String SIN){
        return SIN.matches("^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$\n");
    }
}
