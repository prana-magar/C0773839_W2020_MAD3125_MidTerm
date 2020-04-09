package com.example.c0773839_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.c0773839_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0773839_w2020_mad3125_midterm.Util.FederalTax;
import com.example.c0773839_w2020_mad3125_midterm.Util.OntarioTax;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetailActivity extends AppCompatActivity {

    LinearLayout lr;

    CRACustomer craCustomer;
    TextView textViewSin, textViewFullName, textViewDOB, textViewAge, textViewGender, textViewTaxFileDate,
        textViewGrossIncome, textViewEI, textViewRRSP, textViewCPP, textViewTaxableIncome, textViewTaxPayed,
        textViewFederalTax, textViewOntarioTax, textViewCarryRRSP;

    Button restartBtn;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        craCustomer = (CRACustomer) intent.getSerializableExtra("craCustomer");
        connectViews();
        textViewSin.setText(craCustomer.getSIN());
        textViewFullName.setText(craCustomer.getFullName());
        textViewDOB.setText(formatDate(craCustomer.getDateOfBirth()));
        textViewAge.setText( String.valueOf(craCustomer.getAge()));
        textViewGender.setText(craCustomer.getGender().name());
        textViewTaxFileDate.setText(formatDate(craCustomer.getTaxFilingDate()));
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        textViewGrossIncome.setText(new DecimalFormat("$ #,###.##",symbols).format(craCustomer.getGrossIncome()));



        FederalTax tax = new FederalTax(craCustomer.getGrossIncome(),craCustomer.getRRSP());
        OntarioTax ontarioTax = new OntarioTax(craCustomer.getGrossIncome(),craCustomer.getRRSP());
        textViewEI.setText(new DecimalFormat("$ #,###.##",symbols).format(tax.getEI()));
        textViewRRSP.setText(new DecimalFormat("$ #,###.##",symbols).format(craCustomer.getRRSP()));
        textViewCPP.setText(new DecimalFormat("$ #,###.##",symbols).format(tax.getCPP()));
        textViewTaxableIncome.setText(new DecimalFormat("$ #,###.##",symbols).format(tax.getTaxableIncome()));
        textViewTaxPayed.setText(new DecimalFormat("$ #,###.##",symbols).format(tax.getTax() + ontarioTax.getTax()));
        textViewFederalTax.setText(new DecimalFormat("$ #,###.##",symbols).format(tax.getTax()));
        textViewOntarioTax.setText(new DecimalFormat("$ #,###.##",symbols).format(ontarioTax.getTax()));
        textViewCarryRRSP.setText(new DecimalFormat("$ #,###.##",symbols).format(craCustomer.getCarryForwardRRSP()));

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, MainActivity.class));
            }
        });

    }

     @RequiresApi(api = Build.VERSION_CODES.O)
     String formatDate(LocalDate localDate){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MMM YYYY");
         return formatter.format(localDate);
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
        restartBtn = findViewById(R.id.buttonRestart);
    }
}
