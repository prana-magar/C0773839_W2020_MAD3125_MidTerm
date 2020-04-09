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

    @Override
    public double getTax() {
        float taxable = this.getTaxableIncome();
        float a =  Math.max(Math.min(43906.0f,taxable) - 10582.0f, 0)* 0.0505f ;

        float b = Math.max(Math.min(87813.0f,taxable) - 43906.0f, 0)* 0.0915f;

        float c = Math.max(Math.min(150000.0f,taxable) - 87813.0f, 0)* 0.1116f ;
              float d =   Math.max(Math.min(220000.0f,taxable) - 150000.0f, 0)* 0.1216f ;
               float e =  Math.max(taxable - 220000.0f, 0)* 0.1316f;

       return a+b+c+d+e;



    }
}
