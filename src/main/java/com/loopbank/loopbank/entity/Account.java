package com.loopbank.loopbank.entity;
import jakarta.persistence.*;;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private double balance;
    
}
