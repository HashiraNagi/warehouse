package com.hashira.wherehouse.dto;

import com.hashira.wherehouse.models.Company;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    @NotEmpty(message = "username should not be empty")
    private String username;

    @NotEmpty(message = "password should not be empty")
    private String password;

    @Email
    @NotEmpty(message = "email should not be empty")
    private String email;

    private String company;
}
