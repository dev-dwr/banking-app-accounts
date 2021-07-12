package com.accounts.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountListDto {
    List<AccountDto> accounts;
}
