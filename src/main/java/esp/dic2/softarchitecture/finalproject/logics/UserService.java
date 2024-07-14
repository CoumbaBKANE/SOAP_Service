package esp.dic2.softarchitecture.finalproject.logics;

import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;
import esp.dic2.softarchitecture.finalproject.model.domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    private final AuthenticationService authenticationService = AuthenticationService.getInstance();

    public String ajoutUtilisateur( String token,  String nom_user, String mot_de_passe) {
        if (authenticationService.validateToken(token)) {
            User user = new User(nom_user, mot_de_passe);
            userDAO.addUser(user);
            return "SUCCESS";
        }
        return "FAILED";
    }

    public List<User> listeUtilisateur(String token) {
        if (authenticationService.validateToken(token)) {
            try {
                return userDAO.getAll();
            } catch (SQLException e) {
//                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public String modifUtilisateur( String token,
                                    String nom_user,
                                    String mot_de_passe) {
        if (authenticationService.validateToken(token)) {
            User user = new User(nom_user, mot_de_passe);
            userDAO.updateUser(user);
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }


    public String supprimerUtilisateur( String token,
                                        String nom_user,
                                        String mot_de_passe)  {
        if (authenticationService.validateToken(token)) {
            User user = new User(nom_user, mot_de_passe);
            userDAO.deleteUser(user);
            return "SUCCESS";
        } else {
            return "FAILED";
        }
    }
}
