package org.lerob.accountservice;

import org.lerob.accountservice.entities.AccountType;
import org.lerob.accountservice.entities.BankAccount;
import org.lerob.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
		return args -> {
			BankAccount bankAccount1 = new BankAccount();
				bankAccount1.setId(UUID.randomUUID().toString());
				bankAccount1.setCurrency("XAF");
				bankAccount1.setBalance(15_000_000);
				bankAccount1.setCreatedAt(LocalDate.now());
				bankAccount1.setAccountType(AccountType.CURRENT_ACCOUNT);
				bankAccount1.setCustomerId(1L);

			BankAccount bankAccount2 = new BankAccount();
				bankAccount2.setId(UUID.randomUUID().toString());
				bankAccount2.setCurrency("$");
				bankAccount2.setBalance(18_000_000);
				bankAccount2.setCreatedAt(LocalDate.now());
				bankAccount2.setAccountType(AccountType.SAVING_ACCOUNT);
				bankAccount2.setCustomerId(2L);

			System.out.println(bankAccount1.getId());
			System.out.println(bankAccount2.getId());

			bankAccountRepository.save( bankAccount1 );
			bankAccountRepository.save( bankAccount2 );
		};
	}

}
