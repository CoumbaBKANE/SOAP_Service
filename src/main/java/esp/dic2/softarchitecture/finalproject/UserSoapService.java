package esp.dic2.softarchitecture.finalproject;

import esp.dic2.softarchitecture.finalproject.services.AuthentificationService;
import esp.dic2.softarchitecture.finalproject.services.UtilisateurService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


import java.sql.SQLException;


//POJO

@WebService(serviceName = "UserSoap_Service")
public class UserSoapService {

    public UtilisateurService utilisateurService = new UtilisateurService();
    public AuthentificationService authentificationService = AuthentificationService.getInstance();

    @WebMethod(operationName ="authentification")
    public String authentification(String login, String mot_de_passe ) throws SQLException {
        return authentificationService.authentification(login, mot_de_passe);
    }

    @WebMethod(operationName="ajoutUtilisateur")
    public String ajoutUtilisateur(@WebParam(name = "token") String token, @WebParam(name = "nom_user") String nom_user, @WebParam(name = "mot_de_passe") String mot_de_passe) throws SQLException {
        return utilisateurService.ajoutUtilisateur(token, nom_user, mot_de_passe);
    }

//    @WebMethod(operationName="listeUtilisateurs")
//    public List<Utilisateur> listeUtilisateur(@WebParam(name = "token") String token) throws Exception {
//        if (validateToken(token)) {
//            try {
//                return userDAO.getAll();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                throw new Exception("Error while fetching users", e);
//            }
//        } else {
//            throw new Exception("Invalid token");
//        }
//    }
//
//    @WebMethod(operationName = "modifUtilisateur")
//    public String modifUtilisateur(@WebParam(name = "token") String token,
//                                   @WebParam(name = "nom_user") String nom_user,
//                                   @WebParam(name = "mot_de_passe") String mot_de_passe) throws Exception {
//        if (validateToken(token)) {
//            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
//            userDAO.updateUser(user);
//            return "Utilisateur modifié avec succès";
//        } else {
//            throw new Exception("Invalid token");
//        }
//    }
//
//
//    @WebMethod(operationName = "supprimerUtilisateur")
//    public String supprimerUtilisateur(@WebParam(name = "token") String token,
//                                       @WebParam(name = "nom_user") String nom_user,
//                                       @WebParam(name = "mot_de_passe") String mot_de_passe) throws Exception {
//        if (validateToken(token)) {
//            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
//            userDAO.deleteUser(user);
//            return "Utilisateur supprimé avec succès";
//        } else {
//            throw new Exception("Invalid token");
//        }
//    }

}