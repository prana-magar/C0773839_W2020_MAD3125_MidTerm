package com.example.c0773839_w2020_mad3125_midterm;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.c0773839_w2020_mad3125_midterm.Model.CRACustomer;
import com.example.c0773839_w2020_mad3125_midterm.Model.DataSaver;
import com.example.c0773839_w2020_mad3125_midterm.Model.Gender;
import com.example.c0773839_w2020_mad3125_midterm.Util.Validation;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalDetailsFragment extends Fragment  implements BlockingStep ,DatePickerDialog.OnDateSetListener{


    private DataSaver dataSaver;
    TextInputEditText firstNameEditText, lastNameEditText, dobEditText;
    RadioGroup genderRadio;
    RadioButton genderRadioSelected;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
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
            return;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateDob = LocalDate.parse(dobString,dateTimeFormatter);
        if(!Validation.ageGreaterEqual(dateDob,18)){
            dobEditText.setError("A person must be atleast 18 years old.");
            return;
        }

        int selectedId = genderRadio.getCheckedRadioButtonId();
        genderRadioSelected = getView().findViewById(selectedId);


        CRACustomer craCustomer = dataSaver.getData();
        craCustomer.setFirstName(firstName);
        craCustomer.setLastName(lastName);
        craCustomer.setDateOfBirth(LocalDate.parse(dobString));
        Gender gender = Gender.Male;
        switch (genderRadioSelected.getText().toString()){
            case "Male":
                gender = Gender.Male;
                break;

            case "Female":
                gender = Gender.Female;
                break;

            case "Other":
                gender = Gender.Other;
                break;

        }
        craCustomer.setGender(gender);
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
        String month_str = Integer.toString(month);
        if(month<10){
            month_str = "0"+month_str;
        }

        String day_str = Integer.toString(dayOfMonth);
        if(dayOfMonth<10){
            day_str = "0"+day_str;
        }
        String dateStr = year+"/"+month_str+"/"+day_str;
        dobEditText.setText(dateStr);
    }
}
