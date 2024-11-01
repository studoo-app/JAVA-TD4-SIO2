package com.sio.javatd4sio2;

import com.sio.javatd4sio2.services.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthDemoApplication extends Application {

    private UserService userService = new UserService();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AuthDemoApplication.class.getResource("authenticate.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Auth Demo Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        this.userService.clearUserFromStorage();
        super.stop();
    }
}