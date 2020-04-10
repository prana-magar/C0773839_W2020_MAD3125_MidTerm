package com.example.c0773839_w2020_mad3125_midterm.Util;

public class FederalTax  extends Tax{
    public FederalTax(float grossIncome, float RRSP) {
        super(grossIncome, RRSP);
    }



    @Override
    public double getTax() {
        float taxable = this.getTaxableIncome();
        return Math.max(Math.min(47630.0f,taxable) - 12069.0f, 0)* 0.15f +
                Math.max(Math.min(95259.0f,taxable) - 47630.0f, 0)* 0.205f +
                Math.max(Math.min(147667.0f,taxable) - 95259.0f, 0)* 0.26f +
                Math.max(Math.min(210371.0f,taxable) - 147667.0f, 0)* 0.29f +
                Math.max(taxable - 210371.0f, 0)* 0.33f;
    }
}
