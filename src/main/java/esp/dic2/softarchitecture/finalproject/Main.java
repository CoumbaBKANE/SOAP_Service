package esp.dic2.softarchitecture.finalproject;

import esp.dic2.softarchitecture.finalproject.webserver.soap.StarwarsService;
import jakarta.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");
        String address="http://0.0.0.0:8081/";
        Endpoint.publish(address, new StarwarsService());
        System.out.println("Started on : "+address);
    }
}