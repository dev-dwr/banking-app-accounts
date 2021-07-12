package com.accounts.bootstrap;

import com.accounts.domain.Account;
import com.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAccounts();
    }
    private void loadAccounts(){

        Account account1 = new Account();
        account1.setCurrency("PLN");
        account1.setAvailableFunds(65245455445455.3);
        account1.setNrb("72249000059957936727967706");
        account1.setCustomerId(123456L);

        accountRepository.save(account1);

        Account account2 = new Account();
        account2.setCurrency("EUR");
        account2.setAvailableFunds(622.45);
        account2.setNrb("722490000599579123213146");
        account2.setCustomerId(678910L);

        accountRepository.save(account2);

        Account account3 = new Account();
        account3.setCurrency("SEK");
        account3.setAvailableFunds(112323.56);
        account3.setNrb("72249000059957936727967706");
        account3.setCustomerId(321L);

        accountRepository.save(account3);

        Account account4 = new Account();
        account4.setCurrency("PLN");
        account4.setAvailableFunds(13.56);
        account4.setNrb("23123213");
        account4.setCustomerId(321L);
        accountRepository.save(account4);

        System.out.println("Account Loaded: " + accountRepository.count());
    }
}
