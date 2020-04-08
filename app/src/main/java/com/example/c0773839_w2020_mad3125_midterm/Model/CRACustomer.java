package com.example.c0773839_w2020_mad3125_midterm.Model;

import java.util.Date;

enum Gender{
    Male,
    Femalie,
    Other
}

public class CRACustomer {

    String SIN;
    String firstName;
    String lastName;
    Date dateOfBirth;
    Gender gender;
    Float grossIncome;
    Float RRSP;

}
