package org.lerob.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.lerob.accountservice.entities.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;

    private double balance;

    private LocalDate createdAt;

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Transient  // demande a jpa d'ignorer cet attribut lors de l'interaction avec la BD
    private Customer customer;

    private Long customerId;

}
