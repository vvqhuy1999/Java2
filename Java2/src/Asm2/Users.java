package Asm2;

import java.sql.*;


public class Users {
    public String user;
    public String pass;
    public String role;
    boolean currentRole = false;

    public Users() {
    }

    public Users(String user, String pass, String role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public boolean getCurrentRole(){
        return currentRole;
    }
    
    public void setCurrentRole( boolean currentRole){
        this.currentRole = currentRole;
    }
    
}
