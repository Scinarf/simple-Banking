package com.web.simplebank.service;

import com.web.simplebank.Entity.AccountEntity;
import com.web.simplebank.Mapper.MapToEntity;
import com.web.simplebank.Mapper.MapToRequest;
import com.web.simplebank.Mapper.MapToResponse;
import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.dto.AccountUpdateDto;
import com.web.simplebank.exceptions.InvalidAccountNumberException;
import com.web.simplebank.exceptions.InvalidPasswordException;
import com.web.simplebank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.coyote.http11.Constants.a;

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
                        new InvalidAccountNumberException("This Account Number doesnt exist in our database"));
        return MapToResponse.mapToResponseDto(myAccount);
    }

    @Override
    public List<AccountResponseDto> findAccounts() {
        List<AccountEntity> accountEntity = repo.findAll();
        return accountEntity.stream()
                .map(a -> MapToResponse.mapToResponseDto(a))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMyAccount(String accNumber, int password){
        AccountEntity accountEntity = repo.findByAccountNumber(accNumber)
                .orElseThrow(()
                        -> new InvalidAccountNumberException("This Account Number doesnt exist in our database"));
        if(accountEntity.getPassword() == password)
            repo.deleteByAccountNumber(accNumber);
        else {
            throw new InvalidPasswordException("The password provided doesnt exist in our database");
        }

    }

    public AccountResponseDto updateMyAccount(String accNumber, AccountUpdateDto accountUpdateDto){
        AccountEntity accountEntity = repo.findByAccountNumber(accNumber).orElseThrow(()
                -> new InvalidAccountNumberException("This Account Number doesnt exist in our database"));

        return MapToResponse.mapToResponseFromEntity(accountEntity, accountUpdateDto);

    }
}
