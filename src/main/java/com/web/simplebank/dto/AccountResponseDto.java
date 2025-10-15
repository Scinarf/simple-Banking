package com.web.simplebank.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Builder
@Data
public class AccountResponseDto {
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
