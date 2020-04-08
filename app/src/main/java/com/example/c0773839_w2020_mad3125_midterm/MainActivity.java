package com.example.c0773839_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c0773839_w2020_mad3125_midterm.Adapter.StepperAdapter;
import com.example.c0773839_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0773839_w2020_mad3125_midterm.Model.DataSaver;
import com.example.c0773839_w2020_mad3125_midterm.Util.FederalTax;
import com.example.c0773839_w2020_mad3125_midterm.Util.OntarioTax;
import com.example.c0773839_w2020_mad3125_midterm.Util.Tax;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity implements StepperLayout.StepperListener , DataSaver {

    private StepperLayout mStepperLayout;
    private CRACustomer craCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new StepperAdapter(getSupportFragmentManager(), this));
        mStepperLayout.setListener(this);


        OntarioTax tax = new OntarioTax(100000.0,4000.0);
        FederalTax federalTax = new FederalTax(100000.0,4000.0);
        System.out.println("Tax"+tax.getTax());
        System.out.println("FTax"+federalTax.getTax());



    }

    @Override
    public void onCompleted(View completeButton) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);

    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {

    }

    @Override
    public void saveData(CRACustomer craCustomer) {
        this.craCustomer = craCustomer;
    }

    @Override
    public CRACustomer getData() {
        return this.craCustomer;
    }
}
