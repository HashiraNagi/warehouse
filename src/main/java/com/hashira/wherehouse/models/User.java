package com.hashira.wherehouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    @NotEmpty(message = "username should not be empty")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "password should not be empty")
    private String password;

    @Column(name = "email")
    @Email
    @NotEmpty(message = "email should not be empty")
    private String email;

    @ManyToOne
    @JoinColumn(name ="role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name ="company_id", referencedColumnName = "id")
    private Company company;

}
