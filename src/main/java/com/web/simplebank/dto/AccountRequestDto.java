package com.web.simplebank.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class AccountRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotEmpty
    private long phoneNumber;
    @NotNull
    private String idNumber;
    @NotEmpty
    private int password;
    @NotEmpty
    private int age;
//    @NotEmpty
//    private LocalDate dateOfBirth;
//    @NotEmpty
//    private String accountNumber;
    @Positive
    private double accBalance;
}
