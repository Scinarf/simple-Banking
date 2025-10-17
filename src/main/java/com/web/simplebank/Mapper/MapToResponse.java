package com.web.simplebank.Mapper;

import com.web.simplebank.Automations.CalculateDateOfBirth;
import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.dto.AccountUpdateDto;

public class MapToResponse {
    public static AccountResponseDto mapToResponseDto(AccountEntity acc){
        return AccountResponseDto.builder()
                .accountNumber(acc.getAccountNumber())
                .lastName(acc.getLastName())
                .firstName(acc.getFirstName())
                .accBalance(acc.getAccBalance())
                .age(acc.getAge())
                .dateOfBirth(acc.getDateOfBirth())
                .phoneNumber(acc.getPhoneNumber())
                .idNumber(acc.getAccountNumber())
                .build();
    }

    public static AccountResponseDto mapToResponseFromEntity(AccountEntity accountEntity,AccountUpdateDto acc){
        AccountEntity accountEntity1 = AccountEntity.builder()
                .firstName(accountEntity.getFirstName())
                .lastName(accountEntity.getLastName())
                .age(accountEntity.getAge())
                .accountNumber(accountEntity.getAccountNumber())
                .accBalance(accountEntity.getAccBalance())
                .dateOfBirth(CalculateDateOfBirth.dateOfBirth(accountEntity.getAge()))
                .idNumber(acc.getIdNumber())
                .password(accountEntity.getPassword())
                .phoneNumber(acc.getPhoneNumber())
                .build();

        return mapToResponseDto(accountEntity1);
    }
}
