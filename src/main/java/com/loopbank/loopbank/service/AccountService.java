package com.loopbank.loopbank.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.loopbank.loopbank.entity.Account;
import com.loopbank.loopbank.repos.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount() {
        String accountNumber = generateUniqueAccountNumber();
        Account account = new Account(accountNumber);

        System.out.println(account.toString() + " created");
        return accountRepository.save(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        Account acc = accountRepository.findByAccountNumber(accountNumber);

        return acc;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = generateAccountNumber();
        } while (accountRepository.existsByAccountNumber(accountNumber));
        System.out.println("the account number to use is" + accountNumber);
        return accountNumber;
    }

    private String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public double getBalance(String accountNumber){
        Account acc = accountRepository.findByAccountNumber(accountNumber);
        if(acc == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The specified account does not exist.");
        return acc.getBalance();
    }
}
