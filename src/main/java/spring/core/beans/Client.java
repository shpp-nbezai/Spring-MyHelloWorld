package spring.core.beans;

/**
 *
 */
public class Client {

    private Integer id;
    private String fullName;
    private String greeting;

    public Client(Integer id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }

    public void setId(Integer newId){
        this.id = newId;
    }

    public void setFullName(String newName){
        this.fullName = newName;
    }

    public Integer getId(){
        return this.id;
    }

    public String getFullName(){
        return this.fullName;
    }

    public void setGreeting(String greeting){
        this.greeting = greeting;
    }

    public String getGreeting(){
        return greeting;
    }
}
