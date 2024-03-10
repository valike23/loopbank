package com.loopbank.loopbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loopbank.loopbank.service.AccountService;

@RestController
@RequestMapping("/api/balance")
public class BalanceInquiryController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Double> getBalance(@PathVariable String accountNumber) {
        double balance = accountService.getBalance(accountNumber);
        return ResponseEntity.ok(balance);
    }
}
