package esp.dic2.softarchitecture.finalproject.model.dao;

import  esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    Connection connexion ;

    public UserDAO() throws SQLException {
        connexion = new ConnexionBaseDonnees().getConnection() ;

    }


    public List<Utilisateur> getAll() throws SQLException {
        List<Utilisateur> users = new ArrayList<>();
        try  {
            String sql = "SELECT * FROM users_news ";
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                Utilisateur user = new Utilisateur(userName, userPassword);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Utilisateur getByLogin(String login) {
        try  {
            String sql = "SELECT * FROM users_news WHERE login = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");

                return new Utilisateur(userName, userPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(Utilisateur user){
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

    public void updateUser(Utilisateur user){
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

    public void deleteUser(Utilisateur user){
        String sql = "DELETE FROM users_news WHERE login = ? and password = ?";
        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilisateur getByLoginPass(Utilisateur user){
        String sql = "SELECT * FROM users_news WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, user.getNom());
            statement.setString(2, user.getMot_de_passe());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("login");
                String userPassword = resultSet.getString("password");
                return new Utilisateur(userName, userPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
