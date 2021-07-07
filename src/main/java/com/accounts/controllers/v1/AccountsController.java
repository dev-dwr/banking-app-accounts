package com.accounts.controllers.v1;


import com.accounts.api.v1.dto.AccountListDto;
import com.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    @GetMapping
    public AccountListDto getAccountsList(@RequestParam Long customerId){
        return accountService.getAccountsOfGivenCustomer(customerId);
    }
}
