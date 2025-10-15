package com.web.simplebank.service;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface AccountService {
    AccountEntity createAccount (AccountRequestDto accountRequestDto);

    AccountResponseDto findMyAccount(String accountNumber);

    List<AccountResponseDto> findAccounts();
}
