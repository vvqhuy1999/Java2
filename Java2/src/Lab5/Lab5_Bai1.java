/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab5;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class Lab5_Bai1 extends javax.swing.JFrame {

   /**
    * Creates new form Lab5_Bai1
    */
   public static String user = "sa";
   public static String pass = "admin";
   public static String url = "jdbc:sqlserver://localhost:1433;database=Library;encrypt=false";
   public Lab5_Bai1() {
      initComponents();
      this.setTitle("Book information"); //tieu de
      this.setSize(445,500); // khung
      this.setResizable(false); // co kich thuoc
      //this.getContentPane().setBackground(Color.orange); // chinh mau
      this.setLocationRelativeTo(null); // chinh o giua
      loadData();
   }

   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel2 = new javax.swing.JLabel();
      txtTitle = new javax.swing.JTextField();
      btnSearch = new javax.swing.JButton();
      btnExit = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblBooks = new javax.swing.JTable();
      btnDelete = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

      jLabel2.setText("Title:");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(13, 13, 13)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(35, Short.MAX_VALUE))
      );

      btnSearch.setText("Search");
      btnSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchActionPerformed(evt);
         }
      });

      btnExit.setText("Exit");
      btnExit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnExitActionPerformed(evt);
         }
      });

      tblBooks.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
         },
         new String [] {
            "ID", "Title", "Price"
         }
      ));
      jScrollPane1.setViewportView(tblBooks);

      btnDelete.setText("Delete");
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(btnDelete))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(39, 39, 39)
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(btnSearch)
                     .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(348, 348, 348))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(14, 14, 14)
                  .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addComponent(btnSearch)
                  .addGap(18, 18, 18)
                  .addComponent(btnExit)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnDelete)
            .addGap(144, 144, 144))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   public void loadData(){
       String header[] = {"ID","Title","Price"};
      DefaultTableModel tblModel = new DefaultTableModel(header,0);
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
      String sql = "Select * from books";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while (rs.next()){
            Vector data = new Vector();
            data.add(rs.getInt("id"));
            data.add(rs.getString("title"));
            data.add(rs.getString("price"));
            tblModel.addRow(data);
         }
         tblBooks.setModel(tblModel);
         
      conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
   }
   
   private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      // TODO add your handling code here:
      String header[] = {"ID","Title","Price"};
      DefaultTableModel tblModel = new DefaultTableModel(header,0);
      Connection conn = null;
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "Select * from books";
         if(txtTitle.getText().length() >0){
            sql = sql + " where title like '%" + txtTitle.getText() + "%'";
         }
         Statement stm = conn.createStatement();
         ResultSet rs = stm.executeQuery(sql);
         if(rs.isBeforeFirst() == false){
            JOptionPane.showMessageDialog(this, "The Book is not available!");
            return;
         }
         while (rs.next()){
            Vector data = new Vector();
            data.add(rs.getInt("id"));
            data.add(rs.getString("title"));
            data.add(rs.getString("price"));
            tblModel.addRow(data);
         }
         tblBooks.setModel(tblModel);
      }catch(Exception e)
      {
         System.out.println(e);
      }finally{
         try{
            conn.close();
         }catch (SQLException ex){
            ex.printStackTrace();
         }
            
      }
   }//GEN-LAST:event_btnSearchActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      int ret = JOptionPane.showConfirmDialog(this, "Do you want to delete?",
                                          "Confirm",JOptionPane.YES_NO_OPTION);
      if(ret != JOptionPane.YES_OPTION) return;
      
      try{
         int id = (int) tblBooks.getValueAt(tblBooks.getSelectedRow(), 0);
         Connection conn =(Connection) DriverManager.getConnection(url, user, pass);
         String sql = "delete from Books where id = ?";
         PreparedStatement st = conn.prepareStatement(sql);
         st.setInt(1, id);
         st.executeUpdate();
         JOptionPane.showMessageDialog(this, "Xoa thanh cong");
         conn.close();
         loadData();
      }
      catch(Exception e){
         System.out.println(e);
      }
   }//GEN-LAST:event_btnDeleteActionPerformed

   private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
      // TODO add your handling code here:
      int ret = JOptionPane.showConfirmDialog(this, "Do you want to exit?",
                                          "Confirm",JOptionPane.YES_NO_OPTION);
      if(ret != JOptionPane.YES_OPTION) return;
      System.exit(0);
   }//GEN-LAST:event_btnExitActionPerformed

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
         java.util.logging.Logger.getLogger(Lab5_Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Lab5_Bai1().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnExit;
   private javax.swing.JButton btnSearch;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblBooks;
   private javax.swing.JTextField txtTitle;
   // End of variables declaration//GEN-END:variables
}
