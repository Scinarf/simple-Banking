package com.web.simplebank.Automations;

import java.time.LocalDate;
import java.time.Period;

public class dateOfBirth {

    public int calculatedAge(int year, int month, int day){
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }
}
