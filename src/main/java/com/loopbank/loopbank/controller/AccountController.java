package com.loopbank.loopbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loopbank.loopbank.entity.Account;
import com.loopbank.loopbank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
       @PostMapping
    public ResponseEntity<Account> createAccount() {
        Account account = accountService.createAccount();
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("/{account}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable String account) {
        Account acc = accountService.getAccountByAccountNumber(account);
        if (acc == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else 
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity <List<Account>> getAccounts() {
       List <Account> acc = accountService.getAccounts();
        if (acc == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else 
        return new ResponseEntity<>(acc, HttpStatus.OK);
    }
}
