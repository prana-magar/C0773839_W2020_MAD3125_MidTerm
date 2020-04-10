package com.example.c0773839_w2020_mad3125_midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0773839_w2020_mad3125_midterm.Model.DataSaver;
import com.example.c0773839_w2020_mad3125_midterm.Util.FederalTax;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.text.ParseException;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragmet extends Fragment implements BlockingStep {

    TextInputEditText grossIncomeEditText, RRSPEditText;
    TextInputLayout grossHolder, RRSPHolder;

    private  DataSaver dataSaver;
    public IncomeFragmet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_income_fragmet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        grossIncomeEditText = view.findViewById(R.id.GrossIncomeEditText);
        RRSPEditText = view.findViewById(R.id.RRSPEditText);
        grossHolder = view.findViewById(R.id.GrossIncomeHolder);
        RRSPHolder = view.findViewById(R.id.RRSP_holder);
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {



        callback.goToNextStep();

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        float grossIncome = 0.0F;

        try{
            String grossIncomeString = grossIncomeEditText.getText().toString();
            if(grossIncomeString.isEmpty()){
                grossHolder.setError("Cant be empty");
                return;
            }
            grossIncome = Float.parseFloat(grossIncomeString);
        }
        catch (NumberFormatException e){
            grossHolder.setError("Invalid Format");
            return;
        }

        float rrsp = 0.0F;

        try{
            String rrspString = RRSPEditText.getText().toString();
            if(!rrspString.isEmpty()){
                rrsp = Float.parseFloat(rrspString);
            }

        }
        catch (NumberFormatException e){
            RRSPHolder.setError("Invalid Format");
            return;
        }

        if(rrsp > grossIncome*0.18){
            RRSPHolder.setError("RRSP Exceeds allowed Amount: "+ grossIncome*0.18 );
            return;
        }

        CRACustomer craCustomer = dataSaver.getData();
        craCustomer.setGrossIncome(grossIncome);
        craCustomer.setRRSP(rrsp);
        callback.complete();

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DataSaver) {
            dataSaver = (DataSaver) context;
        } else {
            throw new IllegalStateException("Activity must implement DataManager interface!");
        }
    }
}
