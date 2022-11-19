package com.example.microservices;

import com.example.microservices.entitites.BankAccount;
import com.example.microservices.enums.AccounType;
import com.example.microservices.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository banquerepo){
        return args ->{

            for(int i=0;i<=10;i++){
                BankAccount bankccount=BankAccount
                        .builder()
                        .id(UUID.randomUUID().toString()).type(Math.random()>0.5? AccounType.SAVING_ACCOUNT:AccounType.CURRENT_ACCOUNT)
                        .balance(Math.random()*90000)
                        .CreatedAt(new Date())
                        .currency("MAD")
                        .build();
                banquerepo.save(bankccount);

            }

        };

    }

}
