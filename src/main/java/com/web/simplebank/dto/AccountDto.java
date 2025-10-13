package com.web.simplebank.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Builder
@Data
public class AccountDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotEmpty
    private int age;
    @NotEmpty
    private String accountNumber;
    @Positive
    private double accBalance;

}
