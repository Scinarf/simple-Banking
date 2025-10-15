package com.web.simplebank.Mapper;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountResponseDto;

public class MapToDto {
    public static AccountResponseDto mapToDto(AccountEntity acc){
        return AccountResponseDto.builder()
                .firstName(acc.getFirstName())
                .lastName(acc.getLastName())
                .age(acc.getAge())
                .accountNumber(acc.getAccountNumber())
                .accBalance(acc.getAccBalance())
                .build();
    }
}
