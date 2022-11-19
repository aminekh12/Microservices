package com.example.microservices.entitites;

import com.example.microservices.enums.AccounType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date CreatedAt;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccounType type;
}
