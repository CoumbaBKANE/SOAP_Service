package esp.dic2.softarchitecture.finalproject.model.dao;

import esp.dic2.softarchitecture.finalproject.configs.ConfigurationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private ConfigurationManager configurationManager = ConfigurationManager.getInstance();
    private  String URL = configurationManager.getConfigValue("DATABASE_URL");
    private  String USER = configurationManager.getConfigValue("DATABASE_USER_LOGIN");
    private  String PASSWORD = configurationManager.getConfigValue("DATABASE_USER_PASSWORD");

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
