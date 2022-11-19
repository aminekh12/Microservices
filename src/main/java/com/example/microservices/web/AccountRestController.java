package com.example.microservices.web;


import com.example.microservices.entitites.BankAccount;
import com.example.microservices.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    public AccountRestController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository=bankAccountRepository;

    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();

    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("%s doesn't exist",id)));

    }
    @PostMapping("/bankAccounts/")
    public BankAccount save(BankAccount ba){
        return bankAccountRepository.save(ba);

    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,BankAccount ba){
        BankAccount bank=bankAccountRepository.findById(id).orElseThrow();
        if(bank.getBalance()!=0)bank.setBalance(ba.getBalance());
        if(bank.getCreatedAt()!=null)bank.setCreatedAt(new Date());
        if(bank.getType()!=null)bank.setType(ba.getType());
        if(bank.getCurrency()!=null)bank.setCurrency(ba.getCurrency());
        return bankAccountRepository.save(ba);

    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteaccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);

    }
}
