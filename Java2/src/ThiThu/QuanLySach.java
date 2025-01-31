/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ThiThu;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class QuanLySach extends javax.swing.JFrame {

   /**
    * Creates new form QuanLySach
    */
   DefaultTableModel model;
   List<Sach> DSSach = new ArrayList<>();
   int index = 0;
   public static String user = "sa";
   public static String pass = "admin";
   public static String url = "jdbc:sqlserver://localhost:1433;database=QuanLySach;encrypt=false";
   public QuanLySach() {
      initComponents();
      this.setTitle("QUẢN LÝ SÁCH");
      this.setLocationRelativeTo(null);
      model = (DefaultTableModel)tblSach.getModel();
      String [] columnNames = {"Mã Sách","Tên sách","Giá","Năm XB"};
      model.setColumnIdentifiers(columnNames);
      loadDataTolist();
      fillToTable();
      //showDetail(index);
      tblSach.setRowSelectionInterval(index, index);
      showDetail(index);
      
      
   }
   
   public void loadDataTolist(){
      String [] headers = {"Mã Sách","Tên sách","Giá","Năm XB"};
      DefaultTableModel tblModel = new DefaultTableModel(headers,0);
      DSSach.clear();
      tblModel.setRowCount(0);
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
      String sql = "select masach,tensach,gia,namxb from Sach";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while (rs.next()){
            Sach s = new Sach();
            s.setMasach(rs.getString("masach"));
            s.setTensach(rs.getString("tensach"));
            s.setGia(rs.getFloat("gia"));
            s.setNam(rs.getInt("namxb"));
            DSSach.add(s);
         }
      conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }  
   }
   public void fillToTable(){ 
      model.setRowCount(0);
      for(int i =0 ; i< DSSach.size(); i++){
         model.addRow(new Object[]{
                  DSSach.get(i).getMasach(),
                  DSSach.get(i).getTensach(),
                  DSSach.get(i).getGia(),
                  DSSach.get(i).getNam()
                 });
      }
   }
   
   public void showDetail(int index){
        txtMa.setText(DSSach.get(index).getMasach());
        txtTen.setText(DSSach.get(index).getTensach());
        txtGia.setText(DSSach.get(index).getGia() + "");
        txtNam.setText(DSSach.get(index).getNam()+ "");
    }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      txtMa = new javax.swing.JTextField();
      txtTen = new javax.swing.JTextField();
      txtGia = new javax.swing.JTextField();
      txtNam = new javax.swing.JTextField();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblSach = new javax.swing.JTable();
      btnNew = new javax.swing.JButton();
      btnInsert = new javax.swing.JButton();
      btnFilter = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("QUẢN LÝ SÁCH");

      jLabel2.setText("Mã sách:");

      jLabel3.setText("Tên Sách:");

      jLabel4.setText("Giá sách:");

      jLabel5.setText("Năm xuất bản:");

      txtMa.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtMaActionPerformed(evt);
         }
      });

      tblSach.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblSachMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tblSach);

      btnNew.setText("Clear");
      btnNew.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
         }
      });

      btnInsert.setText("Add");
      btnInsert.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnInsertActionPerformed(evt);
         }
      });

      btnFilter.setText("Top 2");
      btnFilter.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFilterActionPerformed(evt);
         }
      });

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
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(123, 123, 123)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(65, 65, 65)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNam, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(txtMa)
                           .addComponent(txtTen)
                           .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))))
               .addGroup(layout.createSequentialGroup()
                  .addGap(34, 34, 34)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addGap(28, 28, 28)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addContainerGap(34, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnNew)
               .addComponent(btnInsert)
               .addComponent(btnFilter)
               .addComponent(btnDelete))
            .addContainerGap(43, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtMaActionPerformed

   public Sach readForm(){
       Sach s = new Sach();
        s.setMasach(txtMa.getText());
        s.setTensach(txtTen.getText());
        s.setGia(Float.valueOf(txtGia.getText()));
        s.setNam(Integer.valueOf(txtNam.getText()));
        return s;
    } 
   
   private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
      index = tblSach.getSelectedRow();
      showDetail(index);
   }//GEN-LAST:event_tblSachMouseClicked

   private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      txtMa.setText("");
      txtTen.setText("");
      txtGia.setText("");
      txtNam.setText("");
   }//GEN-LAST:event_btnNewActionPerformed

   public int InsertSV(Sach s){
      int rs =0;
      int gia = Integer.parseInt(txtGia.getText());
      //JOptionPane.showMessageDialog(this, gia + 10);
      if(gia > 0 && gia <200){
         try{
            Connection conn = DriverManager.getConnection(url, user, pass);

            String insert_sql = "insert into Sach (masach,tensach,gia,namxb) values (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(insert_sql);
            st.setString(1,s.getMasach());
            st.setString(2,s.getTensach());
            st.setFloat(3,s.getGia());
            st.setInt(4,s.getNam());
            rs = st.executeUpdate();
            conn.close();
         }
         catch(Exception e){
            System.out.println(e);
         }
      }else
         JOptionPane.showMessageDialog(this, "Giá phải lớn hơn 0 và bé hơn 200");
      
     return rs;
    }
   
   private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
      // TODO add your handling code here:
      Sach s = readForm();
        int rs = InsertSV(s);
      if(rs >0){
         JOptionPane.showMessageDialog(this, "Thêm Điểm thành công");
         loadDataTolist();
         fillToTable();
         tblSach.setRowSelectionInterval(DSSach.size()-1, DSSach.size()-1);
         index = DSSach.size()-1;
      }
      else {
         JOptionPane.showMessageDialog(this, "Thêm Điểm Thất bại");
         loadDataTolist();
         fillToTable();
         showDetail(DSSach.size()-1);
         //JOptionPane.showMessageDialog(this, DSSach.size());
         tblSach.setRowSelectionInterval(DSSach.size()-1, DSSach.size()-1);
         
      }
   }//GEN-LAST:event_btnInsertActionPerformed

   public void SapXep(){
      Comparator<Sach> comp = new Comparator<Sach>() {
            @Override 
            public int compare(Sach s1, Sach s2) {
                return Double.compare(s1.getGia(),s2.getGia());
            }
        };
        //Collections.sort(lStudent, comp);
        Collections.sort(DSSach, Collections.reverseOrder(comp));
   }
   
   public void fillToTableFilter(){ 
      model.setRowCount(0);
      for(int i =0 ; i< 2; i++){
         model.addRow(new Object[]{
                  DSSach.get(i).getMasach(),
                  DSSach.get(i).getTensach(),
                  DSSach.get(i).getGia(),
                  DSSach.get(i).getNam()
                 });
      }
      showDetail(0);
      tblSach.setRowSelectionInterval(index, index);
   }
   
   
   private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
      SapXep();
      fillToTableFilter();
   }//GEN-LAST:event_btnFilterActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      // TODO add your handling code here:
      if(txtMa.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Nhập Mã SV");
         txtMa.requestFocus();
         return;
      }
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String sql = "delete from sach where masach = ?" ;
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1,txtMa.getText());
         st.execute();
         JOptionPane.showMessageDialog(this, "Delete thanh cong:");
         con.close();
         if(index == 0){
            showDetail(index+1);
         }
         showDetail(index -1);
         
      }catch (Exception e){
         System.out.println(e);
      }
      loadDataTolist(); 
      fillToTable();
   }//GEN-LAST:event_btnDeleteActionPerformed

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
         java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new QuanLySach().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnFilter;
   private javax.swing.JButton btnInsert;
   private javax.swing.JButton btnNew;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblSach;
   private javax.swing.JTextField txtGia;
   private javax.swing.JTextField txtMa;
   private javax.swing.JTextField txtNam;
   private javax.swing.JTextField txtTen;
   // End of variables declaration//GEN-END:variables
}
