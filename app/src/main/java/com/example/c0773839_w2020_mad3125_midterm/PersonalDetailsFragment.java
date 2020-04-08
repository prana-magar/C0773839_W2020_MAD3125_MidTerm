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

import com.example.c0773839_w2020_mad3125_midterm.Model.DataSaver;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalDetailsFragment extends Fragment  implements BlockingStep {


    private DataSaver dataSaver;
    public PersonalDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_details, container, false);
    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {


        callback.goToNextStep();


    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

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
