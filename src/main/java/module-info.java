module com.sio.javatd4sio2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires java.naming;


    opens com.sio.javatd4sio2 to javafx.fxml;
    exports com.sio.javatd4sio2;
}