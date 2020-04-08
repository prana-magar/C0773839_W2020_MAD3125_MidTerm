package com.example.c0773839_w2020_mad3125_midterm.Util;

public class FederalTax  extends Tax{
    public FederalTax(Double grossIncome, Double RRSP) {
        super(grossIncome, RRSP);
    }

    @Override
    double getTaxRate(Double grossIncome) {
        if(grossIncome <=  12069.0) {
            return 0.0;
        }
        else if(grossIncome > 12069.0 && grossIncome <= 47630.0){
            return 15;
        }
        else if(grossIncome > 47630.0 && grossIncome <= 95259.0){
            return 20.50;
        }
        else if(grossIncome > 95259.0 && grossIncome <= 147667.0){
            return 26;
        }
        else if(grossIncome > 147667.0 && grossIncome <= 210371.0){
            return 29;
        }
        else {
            return 33;
        }

    }
}
