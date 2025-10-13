package com.web.simplebank.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
    @NotEmpty
    private LocalDate dateOfBirth;
    @NotEmpty
    private String accountNumber;
    @Positive
    private double accBalance;

    private double deposit;

}
