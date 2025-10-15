package com.web.simplebank.Mapper;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;

public class MapToResponse {
    public static AccountResponseDto mapToResponseDto(AccountEntity acc){
        return AccountResponseDto.builder()
                .accountNumber(acc.getAccountNumber())
                .lastName(acc.getLastName())
                .firstName(acc.getFirstName())
                .accBalance(acc.getAccBalance())
                .age(acc.getAge())
                .dateOfBirth(acc.getDateOfBirth())
                .build();
    }
}
