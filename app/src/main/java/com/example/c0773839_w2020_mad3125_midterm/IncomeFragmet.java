package com.example.c0773839_w2020_mad3125_midterm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncomeFragmet extends Fragment implements BlockingStep {

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
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        Toast.makeText(this.getContext(), "Next Clicked", Toast.LENGTH_SHORT).show();

        callback.goToNextStep();

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        Toast.makeText(this.getContext(), "Complete clicked frag", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {

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
}
