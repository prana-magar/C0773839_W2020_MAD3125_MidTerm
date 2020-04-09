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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        craCustomer = (CRACustomer) intent.getSerializableExtra("craCustomer");
        ///
    }
}
