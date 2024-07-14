package esp.dic2.softarchitecture.finalproject.model.dao;

import esp.dic2.softarchitecture.finalproject.model.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    Connection connexion ;

    public UserDAO()  {
        try {
            connexion = new DatabaseConnection().getConnection() ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try  {
            String sql = "SELECT * FROM users_news ";
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                User user = new User(userName, userPassword);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getByLogin(String login) {
        try  {
            String sql = "SELECT * FROM users_news WHERE login = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");

                return new User(userName, userPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user){
        try{
            String sql = "INSERT INTO users_news (login, password) VALUES (?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();    
        }
    }

    public void updateUser(User user){
        try {
            String sql = "UPDATE users_news set login=?, password=? WHERE login = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            statement.setString(3, user.getNom());
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user){
        String sql = "DELETE FROM users_news WHERE login = ? and password = ?";
        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getByLoginPass(User user){
        String sql = "SELECT * FROM users_news WHERE login = ? AND password = ?";
        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                return new User(userName, userPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
