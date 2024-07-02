package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "ENTER a Name")
    @Size(min = 1, max = 15, message = "Name should be between 1 and 15 characters")
    @Column(name = "name", columnDefinition = "VARCHAR(15)")
    private String name;

    @NotEmpty(message = "ENTER a SurName")
    @Size(min = 1, max = 15, message = "Name should be between 1 and 15 characters")
    @Column(name = "surName", columnDefinition = "VARCHAR(15)")
    private String surName;

//    @NotEmpty(message = "Username should not be empty")
    @Size(min = 1, max = 15, message = "Username should be between 1 and 15 characters")
    @Column(name = "username", columnDefinition = "VARCHAR(15)")
    private String username;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 5, max = 15, message = "Username should be between 5 and 15 characters")
    @Column(name = "password", columnDefinition = "VARCHAR(15)")
    private String password;

    public User() {}

    public User(String name, String surName, String username, String password) {
        this.name = name;
        this.surName = surName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
