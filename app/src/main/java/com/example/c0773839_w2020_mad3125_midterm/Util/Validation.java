package com.example.c0773839_w2020_mad3125_midterm.Util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Validation {

    public static boolean sin(String SIN){
        return SIN.matches("^(\\d{3}-\\d{3}-\\d{3})|(\\d{9})$\n");
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static boolean ageGreaterEqual(LocalDate dob, int checkAge){
        int age = Period.between(dob, LocalDate.now()).getYears();
        return age >= checkAge;
    }
}
