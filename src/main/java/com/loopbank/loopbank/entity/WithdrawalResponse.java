package com.loopbank.loopbank.entity;
import lombok.Data;

public class WithdrawalResponse {
    private String message;
   public WithdrawalResponse(){}
    public WithdrawalResponse(String msg){
        this.message = msg;
    }
}
