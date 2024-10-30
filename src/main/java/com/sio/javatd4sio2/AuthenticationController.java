package com.sio.javatd4sio2;

import com.sio.javatd4sio2.services.UserService;
import com.sio.javatd4sio2.tools.ConfigManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthenticationController {

    @FXML
    private TextField inputEmail;
    @FXML
    private PasswordField pwdPassword;

    @FXML
    public void btnAuthenticateClicked(ActionEvent event) {
        if (inputEmail.getText().isEmpty() || pwdPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please fill in all fields");
            alert.showAndWait();
            return;
        }

        // Authenticate
        System.out.println("Initializing authentication...");
        System.out.println("Email: " + inputEmail.getText());
        System.out.println("Password: " + pwdPassword.getText());

        // Open dashboard
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = fxmlLoader.load();
            DashboardController controller = fxmlLoader.getController();
            controller.init();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("VeliKo Admin - Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Récupérer le stage actuel via le bouton cliqué
        Stage authStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        authStage.close(); // Fermer la fenêtre
    }
}