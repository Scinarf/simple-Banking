package com.web.simplebank.controller;

import com.web.simplebank.dto.AccountRequestDto;
import com.web.simplebank.dto.AccountResponseDto;
import com.web.simplebank.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void newAccount(AccountRequestDto accountRequestDto){
        accountService.createAccount(accountRequestDto);
    }

    @GetMapping("/active")
    public List<AccountResponseDto> activeAccounts(){
        return accountService.findAccounts();
    }
    @GetMapping("/myaccount/{accNumber}")
    public AccountResponseDto myAccount(@PathVariable("accNumber")String accNumber){
        return accountService.findMyAccount(accNumber);
    }

}
