package esp.dic2.softarchitecture.finalproject.webserver.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import esp.dic2.softarchitecture.finalproject.model.domain.Utilisateur;
import esp.dic2.softarchitecture.finalproject.model.dao.UserDAO;


import java.sql.SQLException;
import java.util.*;


//POJO

@WebService(serviceName = "Soap_Service")
public class UserSoapService {

    private UserDAO userDAO = new UserDAO();

    private HashMap<String, String> tokens = new HashMap<>();

    public UserSoapService() throws SQLException {

    }

    // @WebMethod(operationName = "Utilisateur")
    // public Utilisateur getUtilisateur(@WebParam int id,@WebParam String nom, @WebParam String mot_de_passe){
    //     return new Utilisateur(nom,mot_de_passe);
    // }

    @WebMethod(operationName ="authentification")
    public String authentification(String login, String mot_de_passe ) throws SQLException {
        Utilisateur auth_user = userDAO.getByLoginPass(new Utilisateur(login, mot_de_passe));
        if(auth_user != null){
            return "Authentification effectuée avec succes";
        }
        return "Identifiants incorrects";
    }

    @WebMethod(operationName="generateur_token")
    public String genererToken(@WebParam(name = "admin_login") String admin_login, @WebParam(name="admin_pass") String admin_pass) throws SQLException {
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

    @WebMethod(operationName = "validateToken")
    public boolean validateToken(@WebParam(name = "token") String token) {
        return tokens.containsKey(token);
    }

    @WebMethod(operationName="ajoutUtilisateur")
    public String ajoutUtilisateur(@WebParam(name = "token") String token, @WebParam(name = "nom_user") String nom_user, @WebParam(name = "mot_de_passe") String mot_de_passe) throws SQLException {
        if (validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.addUser(user);
            return "Utilisateur ajouté avec succès";
        }
        return "Utilisateur non valide";

    }

    @WebMethod(operationName="listeUtilisateurs")
    public List<Utilisateur> listeUtilisateur(@WebParam(name = "token") String token) throws Exception {
        if (validateToken(token)) {
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

    @WebMethod(operationName = "modifUtilisateur")
    public String modifUtilisateur(@WebParam(name = "token") String token,
                                   @WebParam(name = "nom_user") String nom_user,
                                   @WebParam(name = "mot_de_passe") String mot_de_passe) throws Exception {
        if (validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.updateUser(user);
            return "Utilisateur modifié avec succès";
        } else {
            throw new Exception("Invalid token");
        }
    }


    @WebMethod(operationName = "supprimerUtilisateur")
    public String supprimerUtilisateur(@WebParam(name = "token") String token,
                                       @WebParam(name = "nom_user") String nom_user,
                                       @WebParam(name = "mot_de_passe") String mot_de_passe) throws Exception {
        if (validateToken(token)) {
            Utilisateur user = new Utilisateur(nom_user, mot_de_passe);
            userDAO.deleteUser(user);
            return "Utilisateur supprimé avec succès";
        } else {
            throw new Exception("Invalid token");
        }
    }





}