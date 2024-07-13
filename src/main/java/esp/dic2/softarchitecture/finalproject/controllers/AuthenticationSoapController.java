package esp.dic2.softarchitecture.finalproject.controllers;

import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;
import esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;
import esp.dic2.softarchitecture.finalproject.services.AuthentificationService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


//POJO

@WebService(serviceName = "AuthenticationSoap_Service")
public class AuthenticationSoapController {

    public AuthentificationService authentificationService = AuthentificationService.getInstance();

    @WebMethod(operationName ="authentification")
    public String authentification(String login, String mot_de_passe ) throws SQLException {
        return authentificationService.authentification(login, mot_de_passe);
    }


//    @WebMethod(operationName="generateur_token")
//    public String genererToken(@WebParam(name = "admin_login") String admin_login, @WebParam(name="admin_pass") String admin_pass) throws SQLException {
//        if(estValideIdentiant(admin_login, admin_pass)){
//            String token = UUID.randomUUID().toString();
//            tokens.put(token, admin_login);
//            return token;
//        }
//        return "Echec dans l'authentification";
//    }

//    private boolean estValideIdentiant(final String admin_login, final String admin_pass) throws SQLException {
//
//        Utilisateur user_to_check = userDAO.getByLoginPass(new Utilisateur(admin_login, admin_pass));
//        if(user_to_check != null){
//            return true;
//        }
//        return false;
//    }

//    @WebMethod(operationName = "validateToken")
//    public boolean validateToken(@WebParam(name = "token") String token) {
//        return tokens.containsKey(token);
//    }


}