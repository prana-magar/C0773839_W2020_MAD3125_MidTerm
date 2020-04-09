package com.example.c0773839_w2020_mad3125_midterm.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.c0773839_w2020_mad3125_midterm.Util.FederalTax;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;



public class CRACustomer implements Serializable {

    private String SIN;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Float grossIncome;
    private Float RRSP;
    private LocalDate taxFilingDate;

    public CRACustomer() {
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public CRACustomer(String SIN, String firstName, String lastName, LocalDate dateOfBirth, Gender gender, Float grossIncome, Float RRSP) {
        this.SIN = SIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.RRSP = RRSP;

    }

    public String getFullName() {
        return this.lastName +", "+ this.firstName;
    }
    public String getSIN() {
        return SIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Float getGrossIncome() {
        return grossIncome;
    }

    public Float getRRSP() {
        return RRSP;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.taxFilingDate = LocalDate.now();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGrossIncome(Float grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setRRSP(Float RRSP) {
        this.RRSP = RRSP;
    }

    public Float getCarryForwardRRSP() {
        float eligible_rrsp = this.getGrossIncome()*0.18f;
        return eligible_rrsp - this.getRRSP() ;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getAge(){
        return Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    }

    public LocalDate getTaxFilingDate() {
        return taxFilingDate;
    }
}
