package esp.dic2.softarchitecture.finalproject.webserver.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;
//POJO
@WebService(serviceName = "StarwarsWS")
public class StarwarsService {
    @WebMethod(operationName = "StarwarsCharacter")
    public StarwarsCharacter getStarwarsCharacter(@WebParam int id,@WebParam String name){
        return new StarwarsCharacter(id,name,new Date());
    }
    @WebMethod(operationName = "StarwarsCharacterList")
    public List<StarwarsCharacter> starwarsCharacterList(){
        return List.of(new StarwarsCharacter(1,"Obi-One",new Date()),
                new StarwarsCharacter(2,"Anakin",new Date()),
                new StarwarsCharacter(3,"Padmé",new Date()));
    }
}