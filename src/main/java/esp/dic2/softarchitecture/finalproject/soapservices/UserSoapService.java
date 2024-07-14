package esp.dic2.softarchitecture.finalproject.soapservices;

import esp.dic2.softarchitecture.finalproject.logics.AuthenticationService;
import esp.dic2.softarchitecture.finalproject.logics.UserService;
import esp.dic2.softarchitecture.finalproject.model.domain.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


import java.sql.SQLException;
import java.util.List;


//POJO

@WebService(serviceName = "UserSoap_Service")
public class UserSoapService {

    public UserService userService = new UserService();
    public AuthenticationService authenticationService = AuthenticationService.getInstance();

    @WebMethod(operationName ="authentification")
    public String authentification(String login, String mot_de_passe ) {
        return authenticationService.authentification(login, mot_de_passe);
    }

    @WebMethod(operationName="ajoutUtilisateur")
    public String ajoutUtilisateur(@WebParam(name = "token") String token, @WebParam(name = "nom_user") String nom_user, @WebParam(name = "mot_de_passe") String mot_de_passe) throws SQLException {
        return userService.ajoutUtilisateur(token, nom_user, mot_de_passe);
    }

    @WebMethod(operationName="listeUtilisateurs")
    public List<User> listeUtilisateur(@WebParam(name = "token") String token) {
        return userService.listeUtilisateur(token);
    }

    @WebMethod(operationName = "modifUtilisateur")
    public String modifUtilisateur(@WebParam(name = "token") String token,
                                   @WebParam(name = "nom_user") String nom_user,
                                   @WebParam(name = "mot_de_passe") String mot_de_passe) {
        return userService.modifUtilisateur(token, nom_user, mot_de_passe);
    }


    @WebMethod(operationName = "supprimerUtilisateur")
    public String supprimerUtilisateur(@WebParam(name = "token") String token,
                                       @WebParam(name = "nom_user") String nom_user,
                                       @WebParam(name = "mot_de_passe") String mot_de_passe) {

        return userService.supprimerUtilisateur(token, nom_user, mot_de_passe);
    }

}