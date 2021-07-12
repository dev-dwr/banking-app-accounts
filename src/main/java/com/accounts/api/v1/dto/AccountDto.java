package com.accounts.api.v1.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private Long customerId;
    private Double availableFunds;
}
