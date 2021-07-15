package com.accounts;

import com.accounts.domain.Account;
import com.accounts.repository.AccountRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import javax.ws.rs.core.GenericEntity;
import java.util.Collections;

import static org.mockito.Mockito.when;

@Ignore
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContractVerifierBase {
    @Autowired
    private WebApplicationContext context;
    @MockBean
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp(){

        RestAssuredMockMvc.webAppContextSetup(context);

        Account account = accountRepository.findAll().get(0);

        when(accountRepository.findAll()).thenReturn(
                Collections.singletonList(

                        Account
                                .builder()
                                .customerId(account.getId())
                                .nrb(account.getNrb())
                                .currency(account.getCurrency())
                                .availableFunds(account.getAvailableFunds())
//                                .customerId(312L)
//                                .nrb("72249000059957936727967706")
//                                .currency("SEK")
//                                .availableFunds(112323.56)
                                .build()
                )
        );
    }
}
