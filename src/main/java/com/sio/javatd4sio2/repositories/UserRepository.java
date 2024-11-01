package com.sio.javatd4sio2.repositories;

import com.sio.javatd4sio2.models.User;
import com.sio.javatd4sio2.tools.DataSourceProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private DataSource dataSource;
    private Connection connection;

    public UserRepository() {
        this.dataSource = DataSourceProvider.getDataSourceInstance();
    }

    // VERSION 1 : NO Hashing Method

    public void createUser(String username, String password) {

        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("INSERT INTO user (email, password,roles) VALUES (?, ?, '[\"ROLE_ADMIN\"]')");
            pSt.setString(1, username);
            pSt.setString(2, password);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public User getUser(String email, String password) {
        User user = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // VERSION 2 : Hash with SHA-256 from DB

    public void createUserWithDbHashing(String username, String password) {

        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement(
                    "INSERT INTO user (email, password,roles) VALUES (?, SHA2(?,256), '[\"ROLE_ADMIN\"]')"
            );
            pSt.setString(1, username);
            pSt.setString(2, password);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public User getUserWithDbHashing(String email, String password) {
        User user = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user WHERE email = ? AND password = SHA2(?,256)"
            );
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // VERSION 3 : Argon Hashing Method

    public void createUserWithArgonHashing(String username, String hashedPassword) {

        try {
            this.connection = this.dataSource.getConnection();
            PreparedStatement pSt = this.connection.prepareStatement("INSERT INTO user (email, password,roles) VALUES (?, ?, '[\"ROLE_ADMIN\"]')");
            pSt.setString(1, username);
            pSt.setString(2, hashedPassword);
            pSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (this.connection != null) {
                    this.connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
