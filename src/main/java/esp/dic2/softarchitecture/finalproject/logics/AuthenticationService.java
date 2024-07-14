package esp.dic2.softarchitecture.finalproject.logics;

import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;
import esp.dic2.softarchitecture.finalproject.model.domain.User;

import java.util.HashMap;
import java.util.UUID;

public class AuthenticationService {

    private static AuthenticationService authenticationService;
    private AuthenticationService() {
        this.tokens.put("4256", "coumbaK");

    }

    public static AuthenticationService getInstance() {
        if (authenticationService == null)
            authenticationService = new AuthenticationService();
        return authenticationService;
    }

    private final HashMap<String, String> tokens = new HashMap<>();
    private final UserDAO userDAO = new UserDAO();

    public String authentification(String login, String mot_de_passe )  {
        User auth_user = userDAO.getByLoginPass(new User(login, mot_de_passe));
        if(auth_user != null){
            return "SUCCESS";
        }
        return "FAILED";
    }

    public String genererToken( String admin_login, String admin_pass) {
        try {
            if(estValideIdentiant(admin_login, admin_pass)){
                String token = UUID.randomUUID().toString();
                tokens.put(token, admin_login);
                return token;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return "Echec dans l'authentification";
    }

    private boolean estValideIdentiant(final String admin_login, final String admin_pass) {
        User user_to_check = userDAO.getByLoginPass(new User(admin_login, admin_pass));
        return user_to_check != null;
    }

    public boolean validateToken(String token) {
        return tokens.containsKey(token);
    }

}
