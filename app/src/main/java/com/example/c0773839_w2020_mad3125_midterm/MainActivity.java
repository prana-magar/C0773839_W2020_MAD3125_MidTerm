package com.example.c0773839_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.c0773839_w2020_mad3125_midterm.Util.FederalTax;
import com.example.c0773839_w2020_mad3125_midterm.Util.OntarioTax;
import com.example.c0773839_w2020_mad3125_midterm.Util.Tax;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        OntarioTax tax = new OntarioTax(100000.0,4000.0);
        FederalTax federalTax = new FederalTax(100000.0,4000.0);
        System.out.println("Tax"+tax.getTax());
        System.out.println("FTax"+federalTax.getTax());



    }
}
