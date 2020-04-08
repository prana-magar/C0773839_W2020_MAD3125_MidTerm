package com.example.c0773839_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_midterm.Model.DataSaver;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalDetailsFragment extends Fragment  implements BlockingStep ,DatePickerDialog.OnDateSetListener{


    private DataSaver dataSaver;
    TextInputEditText firstNameEditText, lastNameEditText, dobEditText;
    RadioGroup genderRadio;
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
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstNameEditText = view.findViewById(R.id.FirstNameEditText);
        lastNameEditText = view.findViewById(R.id.LastNameEditText);
        dobEditText = view.findViewById(R.id.DOBEditText);
        dobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        v.getContext(), PersonalDetailsFragment.this,
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.show();
            }
        });

        genderRadio = view.findViewById(R.id.gender_radio);

    }

    @Override
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {

        String firstName = firstNameEditText.getText().toString();
        if(firstName.trim().isEmpty()){
            firstNameEditText.setError("First Name can't be empty");
            return;
        }

        String lastName = lastNameEditText.getText().toString();

        String dobString = dobEditText.getText().toString();
        if(dobString.trim().isEmpty()){
            dobEditText.setError("Date of Birth can't be empty");
        }

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

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String dateStr = year+"/"+month+"/"+dayOfMonth;
        dobEditText.setText(dateStr);
    }
}
