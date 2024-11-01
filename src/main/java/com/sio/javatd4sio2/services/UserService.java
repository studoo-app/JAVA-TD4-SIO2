package com.sio.javatd4sio2.services;

import com.sio.javatd4sio2.models.User;
import com.sio.javatd4sio2.repositories.UserRepository;
import com.sio.javatd4sio2.tools.ConfigManager;
import com.sio.javatd4sio2.tools.PasswhordHasher;

public class UserService {
    private final UserRepository userRepository;
    private final ConfigManager cm;
    private final PasswhordHasher hasher;

    public UserService() {
        this.userRepository = new UserRepository();
        this.cm = new ConfigManager();
        this.hasher = new PasswhordHasher();
    }

    // Version 1 : No Hashing Method

    public void createUser(String username, String password) {
        this.userRepository.createUser(username, password);
    }

    public void authenticate(String email, String password) {
        User user = this.userRepository.getUser(email, password);
        if (user == null) {
            System.out.println("Invalid credentials");
            return;
        }

       this.storeUser(user);
    }

    // Version 2 :  Hashing deleagate to DB Method

    public void createUserWithDbHashing(String username, String password) {
        this.userRepository.createUserWithDbHashing(username, password);
    }

    public void authenticateWithDbHashing(String email, String password) {
        User user = this.userRepository.getUserWithDbHashing(email, password);
        if (user == null) {
            System.out.println("Invalid credentials");
            return;
        }

        this.storeUser(user);
    }

    // Version 3 : Argon Hashing Method

    public void createUserWithArgonHashing(String username, String password) {

        String hashedPassword = this.hasher.hashPassword(password);

        this.userRepository.createUser(username, hashedPassword);
    }

    public void authenticateWithArgonHashing(String email, String password) {

        User user = this.userRepository.getUserByEmail(email);
        if (user == null) {
            System.out.println("Invalid user");
            return;
        }
        System.out.println("User found: " + user.getEmail() + " - " + user.getPassword());
        boolean valid = this.hasher.verifyPassword(user.getPassword(), password);
        if (!valid) {
            System.out.println("Invalid credentials");
            return;
        }

        this.storeUser(user);
    }

    // Utils methods

    private void storeUser(User user) {
        System.out.println("Storing authenticated User");
        this.cm.setProperty("user.id",  String.valueOf(user.getId()));
        this.cm.setProperty("user.email", user.getEmail());
        this.cm.save();
        System.out.println("User logged in successfully");
    }

    public void clearUserFromStorage() {
        System.out.println("Clearing authenticated User");
        this.cm.setProperty("user.id", "");
        this.cm.setProperty("user.email", "");
        this.cm.save();
        System.out.println("User logged out successfully");
    }

}
