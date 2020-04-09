package com.example.c0773839_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.c0773839_w2020_mad3125_midterm.Model.CRACustomer;

public class DetailActivity extends AppCompatActivity {

    LinearLayout lr;

    CRACustomer craCustomer;
    TextView textViewSin, textViewFullName, textViewDOB, textViewAge, textViewGender, textViewTaxFileDate,
        textViewGrossIncome, textViewEI, textViewRRSP, textViewCPP, textViewTaxableIncome, textViewTaxPayed,
        textViewFederalTax, textViewOntarioTax, textViewCarryRRSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        craCustomer = (CRACustomer) intent.getSerializableExtra("craCustomer");
        connectViews();
        textViewSin.setText(craCustomer.getSIN());
        textViewFullName.setText(craCustomer.getFullName());

    }


    void connectViews(){
        textViewSin = findViewById(R.id.textViewDetailSin);
        textViewFullName = findViewById(R.id.textViewDetailFullName);
        textViewDOB = findViewById(R.id.textViewDetailBirthDate);
        textViewAge = findViewById(R.id.textViewDetailAge);
        textViewGender = findViewById(R.id.textViewDetailGender);
        textViewTaxFileDate = findViewById(R.id.textViewDetailTaxFileDate);
        textViewGrossIncome = findViewById(R.id.textViewDetailGrossIncome);
        textViewEI = findViewById(R.id.textViewDetailEI);
        textViewRRSP = findViewById(R.id.textViewDetailRRSP);
        textViewCPP = findViewById(R.id.textViewDetailCPP);
        textViewTaxableIncome = findViewById(R.id.textViewDetailTotalTaxableIncome);
        textViewTaxPayed = findViewById(R.id.textViewDetailTotalTaxPayed);
        textViewFederalTax = findViewById(R.id.textViewDetailFederalTax);
        textViewOntarioTax = findViewById(R.id.textViewDetailOntarioTax);
        textViewCarryRRSP = findViewById(R.id.textViewDetailCarryRRSP);
    }
}
