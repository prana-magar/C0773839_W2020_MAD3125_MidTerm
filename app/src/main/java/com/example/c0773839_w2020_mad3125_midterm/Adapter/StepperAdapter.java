package com.example.c0773839_w2020_mad3125_midterm.Adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.example.c0773839_w2020_mad3125_midterm.IncomeFragmet;
import com.example.c0773839_w2020_mad3125_midterm.PersonalDetailsFragment;
import com.example.c0773839_w2020_mad3125_midterm.SinFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class StepperAdapter  extends AbstractFragmentStepAdapter {

    String CURRENT_STEP_POSITION_KEY = "messageResourceId";

    public StepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        switch (position){
            case 0:
                final SinFragment step1 = new SinFragment();
                Bundle b1 = new Bundle();
                b1.putInt(CURRENT_STEP_POSITION_KEY, position);
                step1.setArguments(b1);
                return step1;
            case 1:
                final PersonalDetailsFragment step2 = new PersonalDetailsFragment();
                Bundle b2 = new Bundle();
                b2.putInt(CURRENT_STEP_POSITION_KEY, position);
                step2.setArguments(b2);
                return step2;
            case 2:
                final IncomeFragmet step3 = new IncomeFragmet();
                Bundle b3 = new Bundle();
                b3.putInt(CURRENT_STEP_POSITION_KEY, position);
                step3.setArguments(b3);
                return step3;

        }
        return null;    }

    @Override
    public int getCount() {
        return 3;
    }


    @NonNull
    @Override
    public StepViewModel getViewModel(int position) {
        switch (position){
            case 0:
                return new StepViewModel.Builder(context)
                        .setTitle("Sin")
                        .create();
            case 1:
                return new StepViewModel.Builder(context)
                        .setTitle("Personal")
                        .create();

            case 2:
                return new StepViewModel.Builder(context)
                        .setTitle("Income")
                        .create();

        }
        return null;
    }
}
