package esp.dic2.softarchitecture.finalproject.services;

import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;
import esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class AuthentificationService {

    private static AuthentificationService authentificationService;
    private AuthentificationService() {

    }

    public static AuthentificationService getInstance() {
        if (authentificationService == null)
            authentificationService = new AuthentificationService();
        return authentificationService;
    }

    private HashMap<String, String> tokens = new HashMap<>();

    private final UserDAO userDAO = new UserDAO();

    public String authentification(String login, String mot_de_passe ) throws SQLException {
        Utilisateur auth_user = userDAO.getByLoginPass(new Utilisateur(login, mot_de_passe));
        if(auth_user != null){
            return "SUCCESS";
        }
        return "FAILED";
    }

    public String genererToken( String admin_login, String admin_pass) throws SQLException {
        if(estValideIdentiant(admin_login, admin_pass)){
            String token = UUID.randomUUID().toString();
            tokens.put(token, admin_login);
            return token;
        }
        return "Echec dans l'authentification";
    }

    private boolean estValideIdentiant(final String admin_login, final String admin_pass) throws SQLException {

        Utilisateur user_to_check = userDAO.getByLoginPass(new Utilisateur(admin_login, admin_pass));
        if(user_to_check != null){
            return true;
        }
        return false;
    }

    public boolean validateToken(String token) {
        return tokens.containsKey(token);
    }

}
