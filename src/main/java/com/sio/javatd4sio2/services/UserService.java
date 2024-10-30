package com.sio.javatd4sio2.services;

import com.sio.javatd4sio2.models.User;
import com.sio.javatd4sio2.repositories.UserRepository;
import com.sio.javatd4sio2.tools.ConfigManager;

public class UserService {
    private final UserRepository userRepository;
    private final ConfigManager cm;

    public UserService() {
        this.userRepository = new UserRepository();
        this.cm = new ConfigManager();
    }



}
