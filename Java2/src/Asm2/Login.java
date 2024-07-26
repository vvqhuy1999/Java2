
package Asm2;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.*;
import java.util.ArrayList;

public class Login extends javax.swing.JFrame {
    ArrayList<Users> lUsers = new ArrayList<>(); 
    public static String user = "sa";
    public static String pass = "admin";
    public static String url  = "jdbc:sqlserver://localhost:1433;database=FPL_DaoTao;encrypt=false";
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        //ThemSV();
        loadDataTolist();
        //JOptionPane.showMessageDialog(null, lUsers.size());
    }
     
    
    public void loadDataTolist(){
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
      String sql = "select * from USERS";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while (rs.next()){
            Users u = new Users();
            u.setUser(rs.getString("username"));
            u.setPass(rs.getString("password"));
            u.setRole(rs.getString("role"));
            lUsers.add(u);
         }
      conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
   }
    public boolean CheckChon(){
        String username = txtUsername.getText();
        String password = String.valueOf(pwdPass.getPassword()).trim();

        if (username.equals(" ") || username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền username");
            return false;
        }
        if (password.equals(" ") || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy điền password");
            return false;
        }
        return true;
    }
     
    public int ThemUser(Users u){
       int rs =0;
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
            for(Users b: lUsers){
               if(b.getUser().equalsIgnoreCase(txtUsername.getText())){
                  JOptionPane.showMessageDialog(this, "Tk đã có");
                  return 0;
               }
            }
            //lUsers.clear();
            String insert_sql = "insert into USERS (username,password,role) values (?,?,?)";
            PreparedStatement st = conn.prepareStatement(insert_sql);
            st.setString(1,u.getUser());
            st.setString(2,u.getPass());
            st.setString(3,u.getRole());
            rs = st.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return rs;
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      lblUsername = new javax.swing.JLabel();
      lblPass = new javax.swing.JLabel();
      txtUsername = new javax.swing.JTextField();
      btnLogin = new javax.swing.JButton();
      btnCancel = new javax.swing.JButton();
      pwdPass = new javax.swing.JPasswordField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Login");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));

      lblUsername.setText("User name:");

      lblPass.setText("Password:");

      txtUsername.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtUsernameActionPerformed(evt);
         }
      });

      btnLogin.setText("Login");
      btnLogin.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoginActionPerformed(evt);
         }
      });

      btnCancel.setText("Cancel");
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(28, 28, 28)
                  .addComponent(btnCancel)
                  .addGap(16, 16, 16))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(txtUsername)
                     .addComponent(pwdPass, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                  .addContainerGap(38, Short.MAX_VALUE))))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblUsername)
               .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblPass)
               .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnLogin)
               .addComponent(btnCancel))
            .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(29, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = new String(pwdPass.getPassword());
        boolean check = false;
        if(CheckChon()){
           try{
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               Connection con = (Connection) DriverManager.getConnection(url, user, pass);
               String sql = "select username,password from users where username = ? and password =?";
               PreparedStatement  st = con.prepareStatement(sql);
               st.setString(1, txtUsername.getText());
               st.setString(2,  new String(pwdPass.getPassword()));
               ResultSet rss = st.executeQuery();
               if (rss.next()) {
                  JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                  for (Users x : lUsers) {
                   if (username.equals(x.getUser()) && password.equals(x.getPass())) {
                    if (x.getRole().equals("admin")) {
                        Menu mn = new Menu();
                        mn.setVisible(true);
                        this.setVisible(false);
                        break;
                    } else if (x.getRole().equals("manager")) {
                       try {
                          DSSV qlsv = new DSSV();
                          qlsv.setVisible(true);
                          this.setVisible(false);
                          break;
                       } catch (IOException ex) {
                          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    } else {
                        QLDSV qld = new QLDSV();
                        qld.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                   }
                
            }
               } else {
                  JOptionPane.showMessageDialog(this, "Đăng nhập Thất bại!");
               }
               con.close();
            }catch (Exception e){
               System.out.println(e);
            }
        } 
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
;
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnLogin;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JLabel lblPass;
   private javax.swing.JLabel lblUsername;
   private javax.swing.JPasswordField pwdPass;
   private javax.swing.JTextField txtUsername;
   // End of variables declaration//GEN-END:variables
}
