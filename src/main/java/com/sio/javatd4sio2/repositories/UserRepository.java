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



}
