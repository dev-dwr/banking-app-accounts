package com.accounts.controllers.v1;


import com.accounts.api.v1.dto.AccountDto;
import com.accounts.api.v1.dto.AccountListDto;
import com.accounts.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Slf4j
@RestController
@RefreshScope
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountService accountService;

    @Value("${app.allow-get-accounts}")
    private boolean allowGetAccounts;


    @GetMapping
    public List<AccountDto> getAccountsList(@RequestParam("customerId") Long customerId){
        if(!allowGetAccounts){
            log.info("getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        return accountService.getAccountsOfGivenCustomer(customerId).getAccounts();
    }
}
