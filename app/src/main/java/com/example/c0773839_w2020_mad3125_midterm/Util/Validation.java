package com.example.c0773839_w2020_mad3125_midterm.Util;

import java.time.LocalDate;
import java.util.Date;

public class Validation {

    public static boolean sin(String SIN){
        return SIN.matches("^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$\n");
    }


    public static boolean age(LocalDate dob, Int checkAge){

    }
}
