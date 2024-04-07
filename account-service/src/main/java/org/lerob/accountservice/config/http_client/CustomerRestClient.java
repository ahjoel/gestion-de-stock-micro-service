package org.lerob.accountservice.config.http_client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.lerob.accountservice.entities.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker( name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable  Long id);

    @GetMapping("/customer/all")
    @CircuitBreaker( name = "customerService", fallbackMethod = "getDefaultAllCustomer")
    List<Customer> findAllCustomer();

    default Customer getDefaultCustomer(Long id, Exception e) {
        return Customer.builder()
            .email( "@notFind--email" )
            .firstName( "@notFind--firstName" )
            .lastName( "@notFind--lastName" )
            .build();
    }
    default List<Customer> getDefaultAllCustomer(Long id, Exception e) {
        return List.of();
    }

}
