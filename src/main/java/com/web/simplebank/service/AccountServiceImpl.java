package com.web.simplebank.service;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.Mapper.MapToEntity;
import com.web.simplebank.Mapper.MapToRequest;
import com.web.simplebank.Mapper.MapToResponse;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.exceptions.InvalidAccountNumberException;
import com.web.simplebank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository repo;

    @Autowired
    public AccountServiceImpl(AccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {
        AccountEntity accountEntity = MapToEntity.mapToEntity(accountRequestDto);
        return MapToResponse.mapToResponseDto(repo.save(accountEntity));
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
