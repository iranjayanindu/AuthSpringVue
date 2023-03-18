package com.lk.veu.test.auth.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("USERS")
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
