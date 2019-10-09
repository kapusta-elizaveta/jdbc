package com.gym.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static DataBaseConnection instance;
    private String url ="jdbc:postgresql://localhost:5433/gym" ;
    private String user = "postgres";
    private String password = "**************";
    private Connection connectin;
    {
        try {
            connectin = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnectin() {
        return connectin;
    }

    public void setConnectin(Connection connectin) {
        this.connectin = connectin;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBaseConnection();
        } else if (instance.getConnectin().isClosed()) {
            instance = new DataBaseConnection();
        }

        return instance;
    }
}
