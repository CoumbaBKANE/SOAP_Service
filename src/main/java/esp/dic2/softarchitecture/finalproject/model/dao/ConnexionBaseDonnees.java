package esp.dic2.softarchitecture.finalproject.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBaseDonnees {
    private  String URL = "jdbc:mysql://localhost:3306/mglsi_news";
    private  String USER = "root";
    private  String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
