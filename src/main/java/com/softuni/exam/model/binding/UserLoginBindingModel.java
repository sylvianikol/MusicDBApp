package com.softuni.exam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.softuni.exam.constant.ValidationErrorMessages.*;

public class UserLoginBindingModel {

    private String username;
    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = USERNAME_BLANK)
    @Size(min = 3, max = 20, message = USERNAME_LENGTH)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = PASSWORD_BLANK)
    @Size(min = 5, max = 20, message = PASSWORD_LENGTH)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
