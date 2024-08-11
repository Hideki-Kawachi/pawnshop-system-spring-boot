package com.hideki.pawnshopSystem.model;

import com.hideki.pawnshopSystem.enums.Sex;
import com.hideki.pawnshopSystem.enums.UserType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idUser;
    private String firstName;
    private String middleName;
    private String lastName;
    private Sex sex;
    private LocalDate birthDate;
    private String email;
    private String password;
    private UserType type;

    public User(String lastName, String firstName, LocalDate birthDate, String email, String password, UserType type) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
