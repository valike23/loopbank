package com.loopbank.loopbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loopbank.loopbank.entity.WithdrawalResponse;
import com.loopbank.loopbank.service.AccountService;

@RestController
@RequestMapping("/api/withdraw")
public class WithdrawalController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountNumber}")
    public ResponseEntity<String> withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
       String result = accountService.withdraw(accountNumber, amount);
        return ResponseEntity.ok(result);
    }
}
