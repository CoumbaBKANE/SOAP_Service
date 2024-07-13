package esp.dic2.softarchitecture.finalproject.services;

import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;
import esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.sql.SQLException;
import java.util.List;

public class UtilisateurService {

    private final UserDAO userDAO = new UserDAO();
    private final AuthentificationService authentificationService = AuthentificationService.getInstance();


    public String ajoutUtilisateur( String token,  String nom_user, String mot_de_passe) throws SQLException {
        if (authentificationService.validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.addUser(user);
            return "SUCCESS";
        }
        return "FAILED";
    }

    public List<Utilisateur> listeUtilisateur( String token) throws Exception {
        if (authentificationService.validateToken(token)) {
            try {
                return userDAO.getAll();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception("Error while fetching users", e);
            }
        } else {
            throw new Exception("Invalid token");
        }
    }

    public String modifUtilisateur( String token,
                                    String nom_user,
                                    String mot_de_passe) throws Exception {
        if (authentificationService.validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.updateUser(user);
            return "Utilisateur modifié avec succès";
        } else {
            throw new Exception("Invalid token");
        }
    }


    public String supprimerUtilisateur( String token,
                                        String nom_user,
                                        String mot_de_passe) throws Exception {
        if (authentificationService.validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.deleteUser(user);
            return "Utilisateur supprimé avec succès";
        } else {
            throw new Exception("Invalid token");
        }
    }
}
