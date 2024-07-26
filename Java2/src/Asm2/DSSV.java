package Asm2;


import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSSV extends javax.swing.JFrame {
   DefaultTableModel model;
    List<QLSV> DSSV = new ArrayList<>();
    int index = -1;
   String imageName;
   
   public static String user = "sa";
   public static String pass = "admin";
   public static String url = "jdbc:sqlserver://localhost:1433;database=FPL_DaoTao;encrypt=false";
    public DSSV() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel)tblStudent.getModel();
        String [] columnNames = {"Mã SV","Họ tên","Email","Số ĐT","Giới Tính","Địa chỉ","Hình" };
        model.setColumnIdentifiers(columnNames);
        model = (DefaultTableModel)tblStudent.getModel();
        model.setRowCount(0);
        loadDataTolist();
        fillToTable();
        showDetail(0);
         
        //tblStudent.setRowSelectionInterval(index, index);
    }
    public void LoadImg(String img){
      ImageIcon imageIcon = new ImageIcon(new ImageIcon("E:\\fpoly\\java2\\Java2\\src\\Image\\" + img).getImage().getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_DEFAULT));
      lblHinh.setIcon(imageIcon);
    };
    
    public void loadDataTolist(){
      String [] headers = {"Mã SV","Họ tên","Email","Số ĐT","Giới Tính","Địa chỉ","Hình"};
      DefaultTableModel tblModel = new DefaultTableModel(headers,0);
      DSSV.clear();
      tblModel.setRowCount(0);
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
      String sql  ="select * from students";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while (rs.next()){
            QLSV sv = new QLSV();
            sv.setMasv(rs.getString("masv"));
            sv.setHoten(rs.getString("hoten"));
            sv.setEmail(rs.getString("email"));
            sv.setSdt(rs.getString("sodt"));
            sv.setGioitinh(rs.getBoolean("gioitinh"));
            sv.setDiachi(rs.getString("diachi"));
            sv.setHinh(rs.getString("hinh"));
            DSSV.add(sv);
         }
      conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      
       for(QLSV sv : DSSV){
         tblModel.addRow(new Object[]{sv.getMasv(),sv.getHoten(),sv.getEmail(),
            sv.getSdt(),sv.isGioitinh(),sv.getDiachi(),sv.getHinh()});
      }
      tblStudent.setModel(tblModel);
      
   }
    
    public void fillToTable(){ 
    model.setRowCount(0);
        for (QLSV sv : DSSV){
            model.addRow(new Object[]{
                sv.getMasv(),
                sv.getHoten(),
                sv.getEmail(),
                sv.getSdt(),
                sv.isGioitinh(),
                sv.getDiachi(),
                sv.getHinh()
            });
        }
    }
   
    
    public void showDetail(int index){
        txtMaSV.setText(DSSV.get(index).getMasv());
        txtHoTen.setText(DSSV.get(index).getHoten());
        txtEmail.setText(DSSV.get(index).getEmail());
        txtSoDT.setText(DSSV.get(index).getSdt());
        boolean gt = DSSV.get(index).isGioitinh();
//        System.out.println(gt);
         if(gt == false){
            rdoNu.setSelected(true);
         }else{
            rdoNam.setSelected(true);
         }
        txtDiaChi.setText(DSSV.get(index).getDiachi());   
        //lblHinh.set
        LoadImg(DSSV.get(index).getHinh());
    }

   /*public void showDetail(QLSV sv){
        txtMaSV.setText(sv.getMasv());
        txtHoTen.setText(sv.getHoten());
        txtEmail.setText(sv.getEmail());
        txtSoDT.setText(sv.getSdt());
        boolean gt = DSSV.get(index).isGioitinh();
//        System.out.println(gt);
         if(gt == false){
            rdoNu.setSelected(true);
         }else{
            rdoNam.setSelected(true);
         }
        txtDiaChi.setText(sv.getSdt());  
        LoadImg(DSSV.get(index).getHinh());
   }
    */
    
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      GPPhai = new javax.swing.ButtonGroup();
      lblQuanLy = new javax.swing.JLabel();
      lblMaSV = new javax.swing.JLabel();
      lblHoTen = new javax.swing.JLabel();
      lblEmail = new javax.swing.JLabel();
      lblSoDT = new javax.swing.JLabel();
      lblGioiTinh = new javax.swing.JLabel();
      lblDiaChi = new javax.swing.JLabel();
      txtMaSV = new javax.swing.JTextField();
      txtHoTen = new javax.swing.JTextField();
      txtEmail = new javax.swing.JTextField();
      txtSoDT = new javax.swing.JTextField();
      rdoNam = new javax.swing.JRadioButton();
      rdoNu = new javax.swing.JRadioButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      txtDiaChi = new javax.swing.JTextArea();
      btnSave = new javax.swing.JButton();
      btnUpdate = new javax.swing.JButton();
      vdsv = new javax.swing.JPanel();
      lblHinh = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      tblStudent = new javax.swing.JTable();
      btnNew = new javax.swing.JButton();
      btndelete = new javax.swing.JButton();
      jButton1 = new javax.swing.JButton();
      btnLogout = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Quản Lý Sinh Viên");

      lblQuanLy.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
      lblQuanLy.setForeground(new java.awt.Color(0, 0, 255));
      lblQuanLy.setText("Quản Lý Sinh Viên");

      lblMaSV.setText("MaSV:");

      lblHoTen.setText("Họ Tên:");

      lblEmail.setText("Email:");

      lblSoDT.setText("Số ĐT:");

      lblGioiTinh.setText("Giới tính:");

      lblDiaChi.setText("Địa chỉ:");

      txtMaSV.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtMaSVActionPerformed(evt);
         }
      });

      GPPhai.add(rdoNam);
      rdoNam.setText("Nam");

      GPPhai.add(rdoNu);
      rdoNu.setText("Nữ");

      txtDiaChi.setColumns(20);
      txtDiaChi.setRows(5);
      jScrollPane1.setViewportView(txtDiaChi);

      btnSave.setText("Save");
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });

      btnUpdate.setText("Update");
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
         }
      });

      vdsv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

      lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblHinhMouseClicked(evt);
         }
      });

      javax.swing.GroupLayout vdsvLayout = new javax.swing.GroupLayout(vdsv);
      vdsv.setLayout(vdsvLayout);
      vdsvLayout.setHorizontalGroup(
         vdsvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
      );
      vdsvLayout.setVerticalGroup(
         vdsvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
      );

      tblStudent.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null}
         },
         new String [] {
            "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"
         }
      ));
      tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblStudentMouseClicked(evt);
         }
      });
      jScrollPane2.setViewportView(tblStudent);

      btnNew.setText("New");
      btnNew.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
         }
      });

      btndelete.setText("delete");
      btndelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btndeleteActionPerformed(evt);
         }
      });

      jButton1.setText("< Back");

      btnLogout.setText("Logout");
      btnLogout.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLogoutActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(14, 14, 14)
                  .addComponent(jButton1)
                  .addGap(28, 28, 28)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(lblSoDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(lblMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(rdoNam)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                              .addComponent(txtSoDT, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(txtMaSV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(18, 18, 18)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                 .addGroup(layout.createSequentialGroup()
                                    .addComponent(btndelete)
                                    .addGap(20, 20, 20))
                                 .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)))
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                           .addGroup(layout.createSequentialGroup()
                              .addGap(1, 1, 1)
                              .addComponent(vdsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(btnLogout))))
               .addGroup(layout.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap(8, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(lblQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButton1)
               .addComponent(btnLogout))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblMaSV)
                     .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(lblHoTen)
                     .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblEmail)
                     .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(lblSoDT)
                     .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(8, 8, 8)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(rdoNam)
                     .addComponent(rdoNu)
                     .addComponent(lblGioiTinh)))
               .addComponent(vdsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnSave)
                     .addComponent(btnNew))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btndelete)
                     .addComponent(btnUpdate))
                  .addGap(8, 8, 8))
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(lblDiaChi)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "update students set Hoten = ?, Email = ?, "
                 + "SoDT = ?, GioiTinh = ?, Diachi = ?,Hinh =? where MaSV = ?";
         /*
            + txtMaSV.getText() + "," 
                        + txtName.getText() + "," + txtEmail.getText() + "," 
                        + txtDT.getText() + "," + txtDC.getText() +
         */
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1,txtHoTen.getText());
         st.setString(2,txtEmail.getText());
         st.setString(3,txtSoDT.getText());
         st.setBoolean(4,rdoNam.isSelected());
         st.setString(5,txtDiaChi.getText());
         st.setString(6,imageName);
         st.setString(7,txtMaSV.getText());
         st.executeUpdate();
         JOptionPane.showMessageDialog(this, "Update thanh cong:");
         con.close();
         loadDataTolist();
      }catch (Exception e){
         System.out.println(e);
      }
    }//GEN-LAST:event_btnUpdateActionPerformed

   private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
      // TODO add your handling code here:
      index = tblStudent.getSelectedRow();
      showDetail(index);
   }//GEN-LAST:event_tblStudentMouseClicked

   private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "insert into students (MaSV,HoTen,Email,SoDT, GioiTinh,DiaChi,Hinh) values(?,?,?,?,?,?,?)";
         PreparedStatement  st = conn.prepareStatement(sql);
         st.setString(1,txtMaSV.getText());
         st.setString(2,txtHoTen.getText());
         st.setString(3,txtEmail.getText());
         st.setString(4,txtSoDT.getText());
         st.setBoolean(5,rdoNam.isSelected());
         st.setString(6,txtDiaChi.getText());
         st.setString(7,imageName);
         st.executeUpdate();
         JOptionPane.showMessageDialog(this, "Save thanh cong:");
         conn.close();
         
      }catch (Exception e){
         System.out.println(e);
      }
      loadDataTolist();
   }//GEN-LAST:event_btnSaveActionPerformed

   private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
      // TODO add your handling code here:
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
         if(index == 0){
            showDetail(index+1);
         }
         showDetail(index -1);
         
      }catch (Exception e){
         System.out.println(e);
      }
      loadDataTolist();
   }//GEN-LAST:event_btndeleteActionPerformed

   public void clearForm(){
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSoDT.setText("");
        GPPhai.clearSelection();
        txtDiaChi.setText("");
        LoadImg("");
        tblStudent.clearSelection();
        index = -1;
    }
   private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      // TODO add your handling code here:
      clearForm();
   }//GEN-LAST:event_btnNewActionPerformed

   private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
      // TODO add your handling code here:
      JFileChooser filechoose = new JFileChooser("E:\\fpoly\\java2\\Java2\\src\\Image");
      int k = filechoose.showOpenDialog(this);
        if( k==JFileChooser.APPROVE_OPTION) {
            try{
                File f = filechoose.getSelectedFile();
                imageName = f.getName();
                FileOutputStream out =new FileOutputStream("src/image/" + imageName);
                Files.copy(f.toPath(), out);
                /* show lên label */
                ImageIcon ic = new ImageIcon("src\\Image\\" + imageName);
                lblHinh.setIcon(ic);
                Image im = ic.getImage().getScaledInstance(
                lblHinh.getWidth(),lblHinh.getHeight(),Image.SCALE_SMOOTH);
                ic.setImage(im);
            } catch (IOException ex){
                System.out.println(ex.getStackTrace());
            }
        }
   }//GEN-LAST:event_lblHinhMouseClicked

   private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtMaSVActionPerformed

   private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
      // TODO add your handling code here:
      Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
   }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(DSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               try {
                  new DSSV().setVisible(true);
               } catch (IOException ex) {
                  Logger.getLogger(DSSV.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.ButtonGroup GPPhai;
   private javax.swing.JButton btnLogout;
   private javax.swing.JButton btnNew;
   private javax.swing.JButton btnSave;
   private javax.swing.JButton btnUpdate;
   private javax.swing.JButton btndelete;
   private javax.swing.JButton jButton1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JLabel lblDiaChi;
   private javax.swing.JLabel lblEmail;
   private javax.swing.JLabel lblGioiTinh;
   private javax.swing.JLabel lblHinh;
   private javax.swing.JLabel lblHoTen;
   private javax.swing.JLabel lblMaSV;
   private javax.swing.JLabel lblQuanLy;
   private javax.swing.JLabel lblSoDT;
   private javax.swing.JRadioButton rdoNam;
   private javax.swing.JRadioButton rdoNu;
   private javax.swing.JTable tblStudent;
   private javax.swing.JTextArea txtDiaChi;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JTextField txtHoTen;
   private javax.swing.JTextField txtMaSV;
   private javax.swing.JTextField txtSoDT;
   private javax.swing.JPanel vdsv;
   // End of variables declaration//GEN-END:variables
}
