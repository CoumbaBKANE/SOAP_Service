package esp.dic2.softarchitecture.finalproject.controllers;

import esp.dic2.softarchitecture.finalproject.services.UtilisateurService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;
import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;


import java.sql.SQLException;
import java.util.*;


//POJO

//@WebService(serviceName = "UserSoap_Service")
public class UserSoapController {

    public UtilisateurService utilisateurService = new UtilisateurService();

//
//    private boolean estValideIdentiant(final String admin_login, final String admin_pass) throws SQLException {
//
//        Utilisateur user_to_check = userDAO.getByLoginPass(new Utilisateur(admin_login, admin_pass));
//        if(user_to_check != null){
//            return true;
//        }
//        return false;
//    }
//
//    @WebMethod(operationName="ajoutUtilisateur")
//    public String ajoutUtilisateur(@WebParam(name = "token") String token, @WebParam(name = "nom_user") String nom_user, @WebParam(name = "mot_de_passe") String mot_de_passe) throws SQLException {
//        if (validateToken(token)) {
//            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
//            userDAO.addUser(user);
//            return "Utilisateur ajouté avec succès";
//        }
//        return "Utilisateur non valide";
//
//    }
//
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