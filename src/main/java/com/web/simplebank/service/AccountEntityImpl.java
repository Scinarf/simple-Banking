package com.web.simplebank.service;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.Mapper.MapToDto;
import com.web.simplebank.Mapper.MapToEntity;
import com.web.simplebank.Mapper.MapToResponse;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.exceptions.InvalidAccountNumberException;
import com.web.simplebank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountEntityImpl implements AccountService{
    private AccountRepository repo;

    @Autowired
    public AccountEntityImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public AccountEntity createAccount(AccountRequestDto accountRequestDto) {
        AccountEntity accountEntity = MapToEntity.mapToEntity(accountRequestDto);
        return repo.save(accountEntity);
    }

    @Override
    public AccountResponseDto findMyAccount(String accountNumber){
        AccountEntity myAccount = repo.findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new InvalidAccountNumberException("This Account Number doesnt exist on our database"));
        return MapToResponse.mapToResponseDto(myAccount);
    }

    @Override
    public List<AccountResponseDto> findAccounts() {
        List<AccountEntity> accountEntity = repo.findAll();
        return accountEntity.stream()
                .map(a -> MapToResponse.mapToResponseDto(a))
                .collect(Collectors.toList());
    }
}
