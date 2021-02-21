package com.softuni.exam.service;

import com.softuni.exam.model.entity.User;
import com.softuni.exam.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User getById(String userId);
}
