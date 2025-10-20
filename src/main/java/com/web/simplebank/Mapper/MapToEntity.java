package com.web.simplebank.Mapper;

import com.web.simplebank.Automations.AccountNumbers;
import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;

public class MapToEntity {
    public static AccountEntity mapToEntity(AccountRequestDto acc){
        return AccountEntity.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .accountNumber(AccountNumbers.AccountNumbers())
                .age(acc.getAge())
                .password(acc.getPassword())
                .accBalance(acc.getAccBalance())
                .phoneNumber(acc.getPhoneNumber())
//                .dateOfBirth(acc.getDateOfBirth())
                .idNumber(acc.getIdNumber())
                .build();
    }
}
