package com.example.c0773839_w2020_mad3125_midterm.Util;

public class OntarioTax  extends Tax{

    public OntarioTax(float grossIncome, float RRSP) {
        super(grossIncome, RRSP);
    }


    @Override
    public double getTax() {
        float taxable = this.getTaxableIncome();
        return Math.max(Math.min(43906.0f,taxable) - 10582.0f, 0)* 0.0505f +
                Math.max(Math.min(87813.0f,taxable) - 43906.0f, 0)* 0.0915f +
                Math.max(Math.min(150000.0f,taxable) - 87813.0f, 0)* 0.1116f +
                Math.max(Math.min(220000.0f,taxable) - 150000.0f, 0)* 0.1216f +
                Math.max(taxable - 220000.0f, 0)* 0.1316f;



    }
}
