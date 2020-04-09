package com.example.c0773839_w2020_mad3125_midterm.Util;

public class OntarioTax  extends Tax{

    public OntarioTax(float grossIncome, float RRSP) {
        super(grossIncome, RRSP);
    }

    @Override
    double getTaxRate(Double grossIncome) {
        if(grossIncome <=  10582.0) {
            return 0.0;
        }
        else if(grossIncome > 10582.0 && grossIncome <= 43906.0){
            return 5.05;
        }
        else if(grossIncome > 43906.0 && grossIncome <= 87813.0){
            return 9.15;
        }
        else if(grossIncome > 87813.0 && grossIncome <= 150000.0){
            return 11.16;
        }
        else if(grossIncome > 150000.0 && grossIncome <= 220000.0){
            return 12.16;
        }
        else {
            return 13.16;
        }
    }
}
