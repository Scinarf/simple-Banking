package com.web.simplebank.Automations;

import java.time.LocalDate;
import java.time.Period;

public class CalculateDateOfBirth {
    public static LocalDate dateOfBirth(int age){
        LocalDate date = LocalDate.now();
        return date.minusYears(age);
    }
}
