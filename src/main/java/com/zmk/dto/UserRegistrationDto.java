package com.zmk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String password;

    private String confirm;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    @NotNull
    private String lastName;

    @NotEmpty
    @NotNull
    private String birthday;

    @NotEmpty
    @NotNull
    private String mobilePhone;

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday.trim();
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone.trim();
    }
}
