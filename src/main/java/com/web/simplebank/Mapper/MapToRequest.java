package com.web.simplebank.Mapper;

import com.web.simplebank.Automations.CalculateDateOfBirth;
import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;


public class MapToRequest {
    public static AccountRequestDto mapToRequest(AccountEntity acc){
        return AccountRequestDto.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .age(acc.getAge())
                .accountNumber(acc.getAccountNumber())
                .accBalance(acc.getAccBalance())
                .dateOfBirth(CalculateDateOfBirth.dateOfBirth(acc.getAge()))
                .idNumber(acc.getIdNumber())
                .password(acc.getPassword())
                .phoneNumber(acc.getPhoneNumber())
                .build();
    }
}
