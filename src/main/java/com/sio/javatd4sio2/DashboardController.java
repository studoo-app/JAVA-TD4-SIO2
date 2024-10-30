package com.sio.javatd4sio2;

import com.sio.javatd4sio2.tools.ConfigManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblAuthenticatedUser;

    public void init() {

        System.out.println("Dashboard initialized");
    }
}
