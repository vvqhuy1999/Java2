/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab4;

import ASM.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QLUser extends javax.swing.JFrame {

   /**
    * Creates new form QLDSV
    */
   public static ArrayList<Student> list = new ArrayList<>();
   public static String user = "sa";
   public static String pass = "admin";
   public static String url = "jdbc:sqlserver://localhost:1433;database=FPL_DaoTao;encrypt=false";
   static int current;
   public QLUser() {
      initComponents();
      this.setTitle("QUẢN LÝ USERS"); //tieu de
      //this.setSize(500,300); // khung
      this.setResizable(false); // co kich thuoc
      //this.getContentPane().setBackground(Color.orange); // chinh mau
      this.setLocationRelativeTo(null); // chinh o giua
      //fillToTable();
      loadDataToArray();
      display(0);
   }
   

   public void loadDataToArray(){
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "select * from students";
         Statement stm = (Statement) con.createStatement();
         ResultSet rs = (ResultSet) stm.executeQuery(sql);
         while (rs.next()){
            Student sv = new Student();
            sv.setMaSV(rs.getString("MaSV"));
            sv.setHoTen(rs.getString("Hoten"));
            sv.setMail(rs.getString("Email"));
            sv.setSoDT(rs.getString("SoDT"));
            sv.setGioiTinh(rs.getBoolean("Gioitinh"));
            sv.setDiaChi(rs.getString("Diachi"));
            list.add(sv);
         }
         
         con.close();
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
   }
   
   public void display(int i){
      Student sv = list.get(i);
      txtMaSV.setText(sv.getMaSV());
      txtName.setText(sv.getHoTen());
      txtEmail.setText(sv.getMail());
      txtDT.setText(sv.getSoDT());
      txtDC.setText(sv.getDiaChi());
      boolean gt = sv.isGioiTinh();
      if(gt){
         rdoNam.setSelected(true);
      }else{
         rdoNu.setSelected(true);
      }
      
   }
   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      buttonGroup1 = new javax.swing.ButtonGroup();
      jLabel1 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      txtMaSV = new javax.swing.JTextField();
      txtEmail = new javax.swing.JTextField();
      txtDT = new javax.swing.JTextField();
      jLabel10 = new javax.swing.JLabel();
      txtName = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      rdoNam = new javax.swing.JRadioButton();
      rdoNu = new javax.swing.JRadioButton();
      jLabel3 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtDC = new javax.swing.JTextArea();
      btnAdd = new javax.swing.JButton();
      btnSave = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();
      btnUpdate = new javax.swing.JButton();
      btnFirst = new javax.swing.JButton();
      btnNext = new javax.swing.JButton();
      btnReturn = new javax.swing.JButton();
      btnLast = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 255));
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("QUẢN LÝ USERS");

      jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

      jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel5.setText("Mã SV:");

      jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel6.setText("Email:");

      jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel7.setText("Số ĐT:");

      jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel10.setText("Họ tên:");

      jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel2.setText("Giới tính:");

      buttonGroup1.add(rdoNam);
      rdoNam.setText("Nam");

      buttonGroup1.add(rdoNu);
      rdoNu.setText("Nữ");

      jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
      jLabel3.setText("Địa chỉ:");

      txtDC.setColumns(20);
      txtDC.setRows(5);
      jScrollPane1.setViewportView(txtDC);

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                  .addComponent(txtMaSV)
                  .addComponent(txtEmail))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(rdoNam)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel10)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(rdoNam)
               .addComponent(rdoNu))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel3)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );

      btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add.png"))); // NOI18N
      btnAdd.setText("Add");
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
         }
      });

      btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
      btnSave.setText("Save");
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });

      btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Delete.png"))); // NOI18N
      btnDelete.setText("Delete");
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/update_1.png"))); // NOI18N
      btnUpdate.setText("Update");
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
         }
      });

      btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
      btnFirst.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFirstActionPerformed(evt);
         }
      });

      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
      btnNext.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNextActionPerformed(evt);
         }
      });

      btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pri.png"))); // NOI18N
      btnReturn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReturnActionPerformed(evt);
         }
      });

      btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
      btnLast.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLastActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnUpdate)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(36, 36, 36))
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(93, 93, 93)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(87, 87, 87)
                  .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addComponent(jLabel1)
            .addGap(34, 34, 34)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnSave)
                  .addGap(12, 12, 12)
                  .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnUpdate))
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btnNext)
               .addComponent(btnReturn, javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(btnLast)
               .addComponent(btnFirst))
            .addContainerGap(23, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
      current =0;
      display(current);
   }//GEN-LAST:event_btnFirstActionPerformed

   private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      // TODO add your handling code here:
      txtMaSV.setText("");
      txtName.setText("");
      txtEmail.setText("");
      txtDT.setText("");
      txtDC.setText("");
      txtMaSV.requestFocus();
   }//GEN-LAST:event_btnAddActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      if(txtMaSV.getText().equals("")){
         JOptionPane.showMessageDialog(this, "Nhập Mã SV");
         txtMaSV.requestFocus();
         return;
      }
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String sql = "delete from students where MaSV = ?" ;    //+ txtMaSV.getText()
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1,txtMaSV.getText());
         st.execute();
         JOptionPane.showMessageDialog(this, "Delete thanh cong:");
         con.close();
//         display(current--);
      }catch (Exception e){
         System.out.println(e);
      }
   }//GEN-LAST:event_btnDeleteActionPerformed

   private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "update students set Hoten = ?, Email = ?, "
                 + "SoDT = ?, GioiTinh = ?, Diachi = ? where MaSV = ?";
         /*
            + txtMaSV.getText() + "," 
                        + txtName.getText() + "," + txtEmail.getText() + "," 
                        + txtDT.getText() + "," + txtDC.getText() +
         */
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1,txtName.getText());
         st.setString(2,txtEmail.getText());
         st.setString(3,txtDT.getText());
         st.setBoolean(4,rdoNam.isSelected());
         st.setString(5,txtDC.getText());
         st.setString(6,txtMaSV.getText());
         st.executeUpdate();
         JOptionPane.showMessageDialog(this, "Update thanh cong:");
         con.close();
         loadDataToArray();
      }catch (Exception e){
         System.out.println(e);
      }
   }//GEN-LAST:event_btnUpdateActionPerformed

   private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "insert into students (MaSV,HoTen,Email,SoDT, GioiTinh,DiaChi,Hinh) values(?,?,?,?,?,?,?)";
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1,txtMaSV.getText());
         st.setString(2,txtName.getText());
         st.setString(3,txtEmail.getText());
         st.setString(4,txtDT.getText());
         st.setBoolean(5,rdoNam.isSelected());
         st.setString(6,txtDC.getText());
          st.setString(7,"");
         st.executeUpdate();
         JOptionPane.showMessageDialog(this, "Save thanh cong:");
         con.close();
         loadDataToArray();
//         display(current--);
      }catch (Exception e){
         System.out.println(e);
      }
   }//GEN-LAST:event_btnSaveActionPerformed

   private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
      // TODO add your handling code here:
      current =list.size()-1;
      display(current);
   }//GEN-LAST:event_btnLastActionPerformed

   private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
      if(current == list.size()-1){
         JOptionPane.showMessageDialog(null, "Dang o cuoi danh sach");
         return;
      }
      current++;
      display(current);
   }//GEN-LAST:event_btnNextActionPerformed

   private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
      // TODO add your handling code here:
      if(current == 0){
         JOptionPane.showMessageDialog(null, "Dang o dau danh sach");
         return;
      }
      current--;
      display(current);
      
   }//GEN-LAST:event_btnReturnActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(QLUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new QLUser().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAdd;
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnFirst;
   private javax.swing.JButton btnLast;
   private javax.swing.JButton btnNext;
   private javax.swing.JButton btnReturn;
   private javax.swing.JButton btnSave;
   private javax.swing.JButton btnUpdate;
   private javax.swing.ButtonGroup buttonGroup1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JRadioButton rdoNam;
   private javax.swing.JRadioButton rdoNu;
   private javax.swing.JTextArea txtDC;
   private javax.swing.JTextField txtDT;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JTextField txtMaSV;
   private javax.swing.JTextField txtName;
   // End of variables declaration//GEN-END:variables
}
