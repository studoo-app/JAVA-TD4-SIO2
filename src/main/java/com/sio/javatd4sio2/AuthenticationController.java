package com.sio.javatd4sio2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        if (!validInputs()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Inputs", "Please fill in all fields.");
            return;
        }

        // Authenticate
        System.out.println("Initializing authentication...");
        System.out.println("Email: " + inputEmail.getText());
        System.out.println("Password: " + pwdPassword.getText());

        // Open dashboard
        showDashboard();


        // Récupérer le stage actuel via le bouton cliqué
        Stage authStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        authStage.close(); // Fermer la fenêtre
    }

    @FXML
    public void btnRegisterClicked(ActionEvent event) {
        if (!validInputs()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Inputs", "Please fill in all fields.");
            return;
        }

        // Authenticate
        System.out.println("Initializing Registration...");
        System.out.println("Email: " + inputEmail.getText());
        System.out.println("Password: " + pwdPassword.getText());

        showAlert(Alert.AlertType.INFORMATION, "Registration", "Success", "User registered successfully.");
    }

    private void showDashboard() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = fxmlLoader.load();
            DashboardController controller = fxmlLoader.getController();
            controller.init();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Auth Demo - Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validInputs(){
        return !inputEmail.getText().isEmpty() && !pwdPassword.getText().isEmpty();
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}