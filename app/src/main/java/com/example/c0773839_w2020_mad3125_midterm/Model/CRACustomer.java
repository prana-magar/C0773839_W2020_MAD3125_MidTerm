package com.example.c0773839_w2020_mad3125_midterm.Model;

import java.time.LocalDate;
import java.util.Date;

enum Gender{
    Male,
    Femalie,
    Other
}

public class CRACustomer {

    private String SIN;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Float grossIncome;
    private Float RRSP;


    public CRACustomer() {
    }


    public CRACustomer(String SIN, String firstName, String lastName, LocalDate dateOfBirth, Gender gender, Float grossIncome, Float RRSP) {
        this.SIN = SIN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.RRSP = RRSP;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
