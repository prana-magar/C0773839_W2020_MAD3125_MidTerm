package com.example.c0773839_w2020_mad3125_midterm.Util;

import com.example.c0773839_w2020_mad3125_midterm.R;

import java.util.HashMap;
import java.util.TreeMap;

public abstract class Tax {


    Double grossIncome;
    Double RRSP;


    public Tax(Double grossIncome, Double RRSP) {
        this.grossIncome = grossIncome;
        this.RRSP = RRSP;
    }

    public void setGrossIncome(Double grossIncome){
        this.grossIncome = grossIncome;
    }
    public void setRRSP(Double RRSP){
        this.RRSP = RRSP
        ;
    }

    private double getCPP(){
        if (grossIncome == null){
            System.out.println("Sett Gross income firstt");
            return 0;
        }
        return this.grossIncome>= 57400? 2927.40: this.grossIncome* 0.051;
    }

    private double getEI(){
        if (grossIncome == null){
            System.out.println("Sett Gross income firstt");
            return 0;
        }
        return this.grossIncome>= 53100? 860.22: this.grossIncome* 0.0162;
    }

    private double getRRSP(){
        if (grossIncome == null){
            System.out.println("Sett Gross income firstt");
            return 0;
        }

        if(!validateRRSP()){
            System.out.println("RRSP not valid");
            return 0;
        }
        return RRSP;
    }

     abstract double getTaxRate(Double grossIncome);


    public boolean validateRRSP(){
        if (grossIncome == null || this.RRSP  == null){
            System.out.println("Sett Gross income first and RRSP ");
            return false;
        }
        return (this.RRSP <= this.grossIncome*0.18);
    }

    private double getTaxableIncome(){
        return this.grossIncome - (getCPP() + getEI() +getRRSP());
    }

    public double getTax(){
        if (grossIncome == null || this.RRSP  == null){
            System.out.println("Sett Gross income first and RRSP ");
            return 0;
        }

        double tax_rate = 0;
        try {
            tax_rate = this.getTaxRate(getTaxableIncome());
        }
        catch (NullPointerException ne){
            System.out.println("Couldnt find in tax bracket");
        }

        double taxableIncome = getTaxableIncome();
        return  tax_rate/100 * taxableIncome;

    }



}
