package esp.dic2.softarchitecture.finalproject.webserver.soap;


import java.util.Date;
public class StarwarsCharacter {
    private int Id;
    private String Name;
    private Date joinDate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public StarwarsCharacter(int id, String name, Date joinDate) {
        Id = id;
        Name = name;
        this.joinDate = joinDate;
    }


}