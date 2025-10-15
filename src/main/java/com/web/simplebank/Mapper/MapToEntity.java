package com.web.simplebank.Mapper;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;

public class MapToEntity {
    public static AccountEntity mapToEntity(AccountRequestDto acc){
        return AccountEntity.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .accountNumber(acc.getAccountNumber())
                .age(acc.getAge())
                .password(acc.getPassword())
                .accBalance(acc.getAccBalance())
                .phoneNumber(acc.getPhoneNumber())
                .dateOfBirth(acc.getDateOfBirth())
                .idNumber(acc.getIdNumber())
                .build();
    }
}
