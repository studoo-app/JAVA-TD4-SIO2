package com.sio.javatd4sio2;

import com.sio.javatd4sio2.tools.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblAuthenticatedUser;

    private final ConfigManager cm = new ConfigManager();

    public void init() {
        String email = cm.getProperty("user.email");
        String id = cm.getProperty("user.id");
        lblAuthenticatedUser.setText(id +" / " +email);
        System.out.println("Dashboard initialized");
    }
}
