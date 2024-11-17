package model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String visa;
    private String address;

    public User() {
        name = "";
        visa = "";
        address = "";
    }

    public User(String name, String visa, String address) {
        this.name = name;
        this.visa = visa;
        this.address = address;
    }

   public String getName(){
       return name;
   }
   public String getVisa(){
       return visa;
   }

 
    public void setName(String name) {
        this.name = name;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

 
}
