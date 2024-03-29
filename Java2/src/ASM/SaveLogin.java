/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASM;

/**
 *
 * @author admin
 */
public class SaveLogin {
   public char[] pass;
   public String user;

   public char[] getPass() {
      return pass;
   }

   public void setPass(char[] pass) {
      this.pass = pass;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public SaveLogin( String user,char[] pass) {
      this.pass = pass;
      this.user = user;
   }

  

   public SaveLogin() {
   }
   
   
   
}
