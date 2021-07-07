package com.accounts.services;

import com.accounts.api.v1.dto.AccountListDto;
import com.accounts.api.v1.mapper.AccountMapper;
import com.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountListDto getAccountsOfGivenCustomer(Long customerId){
        return new AccountListDto(accountRepository
                .findAll()
                .stream()
                .filter(account -> account.getCustomerId().equals(customerId))
                .map(accountMapper::accountToAccountDto)
                .collect(Collectors.toList()));
    }
}
