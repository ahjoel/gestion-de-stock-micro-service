package org.lerob.accountservice.entities.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@Builder
@ToString
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
}
