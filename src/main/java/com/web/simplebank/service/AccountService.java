package com.web.simplebank.service;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.dto.AccountUpdateDto;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface AccountService {
    AccountResponseDto createAccount (AccountRequestDto accountRequestDto);

    AccountResponseDto findMyAccount(String accountNumber);

    List<AccountResponseDto> findAccounts();

    void deleteMyAccount(String accNumber, int password);

    AccountResponseDto updateMyAccount(String accNumber, AccountUpdateDto accountUpdateDto);
}
