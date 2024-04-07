package org.lerob.accountservice.repository;


import org.lerob.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/*@RepositoryRestResource*/
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
