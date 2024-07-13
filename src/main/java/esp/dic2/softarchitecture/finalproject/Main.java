package esp.dic2.softarchitecture.finalproject;

import esp.dic2.softarchitecture.finalproject.controllers.AuthenticationSoapController;
import esp.dic2.softarchitecture.finalproject.controllers.UserSoapController;
import jakarta.xml.ws.Endpoint;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Starting...");
        String address="http://0.0.0.0:8081/";
        Endpoint.publish(address, new AuthenticationSoapController());
        System.out.println("Started on : "+address);

    }
}