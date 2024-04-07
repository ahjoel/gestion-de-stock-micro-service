package org.lerob.accountservice.web;

import lombok.RequiredArgsConstructor;
import org.lerob.accountservice.config.http_client.CustomerRestClient;
import org.lerob.accountservice.entities.BankAccount;
import org.lerob.accountservice.entities.model.Customer;
import org.lerob.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class BankAccountRestControlleur {

    private final BankAccountRepository bankAccountRepository;

    private final CustomerRestClient customerRestClient;


    @GetMapping("/all")
    public List<BankAccount> accounts() {
        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(bankAccount -> {
            bankAccount.setCustomer( customerRestClient.findCustomerById( bankAccount.getCustomerId() ) );
        } );
        return accountList;
    }

    @GetMapping("/{id}")
    public BankAccount bankAccountById(@PathVariable("id") String accountID) {
        BankAccount bankAccount = bankAccountRepository.findById( accountID ).orElseThrow();
        Customer customerById = customerRestClient.findCustomerById( bankAccount.getCustomerId() );
        bankAccount.setCustomer( customerById );
        return bankAccount;
    }

}
