/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Lab5;
import java.sql.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.String;

/**
 *
 * @author admin
 */
public class Lab5_Bai2 extends javax.swing.JFrame {

   SanPhamDAO spdao = new SanPhamDAO();
   List<SanPham> list = new ArrayList<>();
   int current =0;
   public Lab5_Bai2() {
      initComponents();
      //this.setTitle("Book information"); //tieu de
      //this.setSize(445,500); // khung
      this.setResizable(false); // co kich thuoc
      //this.getContentPane().setBackground(Color.orange); // chinh mau
      this.setLocationRelativeTo(null); // chinh o giua
      loadDataToTable();
      loadDataToCombobox();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblSanPham = new javax.swing.JTable();
      jLabel1 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      txtMa = new javax.swing.JTextField();
      txtTen = new javax.swing.JTextField();
      txtGia = new javax.swing.JTextField();
      txtSL = new javax.swing.JTextField();
      cboLoaiSP = new javax.swing.JComboBox<>();
      btnAdd = new javax.swing.JButton();
      btnUpdate = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();
      btnReset = new javax.swing.JButton();
      btnFirst = new javax.swing.JButton();
      btnPrevious = new javax.swing.JButton();
      btnNext = new javax.swing.JButton();
      btnLast = new javax.swing.JButton();
      jLabel2 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
      jPanel1.setPreferredSize(new java.awt.Dimension(390, 441));

      tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
      tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblSanPhamMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tblSanPham);

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(14, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel1.setText("Danh sách");

      jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
      jPanel2.setPreferredSize(new java.awt.Dimension(390, 242));

      jLabel3.setText("Mã SP:");

      jLabel4.setText("Tên SP:");

      jLabel5.setText("Đơn giá:");

      jLabel6.setText("Số lượng:");

      jLabel7.setText("Loại sản phẩm:");

      txtMa.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtMaActionPerformed(evt);
         }
      });

      cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

      btnAdd.setText("Thêm");
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
         }
      });

      btnUpdate.setText("Cập nhật");
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
         }
      });

      btnDelete.setText("Xóa");
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      btnReset.setText("Làm mới");
      btnReset.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnResetActionPerformed(evt);
         }
      });

      btnFirst.setText("|<");
      btnFirst.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFirstActionPerformed(evt);
         }
      });

      btnPrevious.setText("<<");
      btnPrevious.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPreviousActionPerformed(evt);
         }
      });

      btnNext.setText(">>");
      btnNext.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNextActionPerformed(evt);
         }
      });

      btnLast.setText(">|");
      btnLast.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLastActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(jPanel2Layout.createSequentialGroup()
                     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                           .addGap(31, 31, 31)
                           .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtTen)
                        .addComponent(txtGia)))
                  .addGroup(jPanel2Layout.createSequentialGroup()
                     .addGap(31, 31, 31)
                     .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                           .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                           .addComponent(cboLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                           .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                           .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(20, 20, 20)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGap(27, 27, 27)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnDelete))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(btnReset)
                     .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(19, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4))
            .addGap(20, 20, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel7)
               .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnAdd)
               .addComponent(btnUpdate)
               .addComponent(btnDelete)
               .addComponent(btnReset))
            .addGap(33, 33, 33)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnFirst)
               .addComponent(btnPrevious)
               .addComponent(btnNext)
               .addComponent(btnLast))
            .addContainerGap(94, Short.MAX_VALUE))
      );

      jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
      jLabel2.setText("Thông tin");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(27, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(jLabel2))
            .addGap(4, 4, 4)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
               .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(97, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   
   
   public void loadDataToTable(){
      list = spdao.getAllSanPham();
      String header[] ={"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm"};
      DefaultTableModel tblModel = new DefaultTableModel(header,0);
      for(SanPham sp : list){
         tblModel.addRow(new Object[]{sp.getMaSanPham(),sp.getTenSp(),sp.getLoaiSanPham().getTenLoai()});
      }
      tblSanPham.setModel(tblModel);
   }
   
   public void loadDataToCombobox(){
      List<LoaiSanPham> dslsp = spdao.getAllLoaiSanPham();
      DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiSP.getModel();
      model.removeAllElements();
      for(LoaiSanPham lsp : dslsp){        
         model.addElement(lsp);
      }   
   }
   
   // setForm(int i): dùng để hiển thị sản phẩm thứ i trong tblSanPhams lên các
   // control bên phải
   public void setForm(int i){
      SanPham sp = list.get(i);
      txtMa.setText(sp.getMaSanPham());
      txtTen.setText(sp.getTenSp());
      txtGia.setText(String.format("%,.0f",sp.getDonGia()));
      txtSL.setText(String.valueOf(sp.getSoLuong()));
      cboLoaiSP.getModel().setSelectedItem(sp.getLoaiSanPham().toString());
      tblSanPham.setRowSelectionInterval(i, i);
   }
   
   // getForm(): Lấy thông tin từ các control bên phải
    public SanPham getForm(){
        SanPham sp = new SanPham();
        sp.setMaSanPham(txtMa.getText());
        sp.setTenSp(txtTen.getText());
        sp.setDonGia(Double.valueOf(txtGia.getText().replaceAll(",", "")));
        sp.setSoLuong(Integer.valueOf(txtSL.getText()));
        sp.setLoaiSanPham((LoaiSanPham)cboLoaiSP.getSelectedItem());
        return sp;
    }
    
    
   // clearForm(): reset thông tin các control bên phải 
    public void clearForm(){
       txtMa.setText("");
      txtTen.setText("");
      txtGia.setText("");
      txtSL.setText("");
      cboLoaiSP.getModel().setSelectedItem("");
    }
    
    
   private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      // TODO add your handling code here:
      SanPham sp = getForm();
      int rs = spdao.insert(sp);
      if(rs >0){
         JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
         loadDataToTable();
      }
   }//GEN-LAST:event_btnAddActionPerformed

   private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtMaActionPerformed

   private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
      // TODO add your handling code here:
      current =0;
      setForm(current);
   }//GEN-LAST:event_btnFirstActionPerformed

   private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
      // TODO add your handling code here:
      if(current == 0){
         JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách!");
         return;
      }
      current--;
      setForm(current);
   }//GEN-LAST:event_btnPreviousActionPerformed

   private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
      // TODO add your handling code here:
      current = list.size()-1;
      setForm(current);
   }//GEN-LAST:event_btnLastActionPerformed

   private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
      // TODO add your handling code here:
      if(current == list.size()-1){
         JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách!");
         return;
      }
      current++;
      setForm(current);
   }//GEN-LAST:event_btnNextActionPerformed

   private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      // TODO add your handling code here:
      SanPham sp = getForm();
      int rs = spdao.update(sp);
      if(rs >0){
         JOptionPane.showMessageDialog(this, "Cập nhạt sản phẩm thành công");
         loadDataToTable();
      }
   }//GEN-LAST:event_btnUpdateActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      // TODO add your handling code here:
      int ret = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm?","Confirm", JOptionPane.YES_NO_OPTION);
      if(ret != JOptionPane.YES_OPTION) return;
      
      int rs = spdao.delete(txtMa.getText());
      
      if(rs>0){
         JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công!");
         loadDataToTable();
         clearForm();
      }
   }//GEN-LAST:event_btnDeleteActionPerformed

   private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
      // TODO add your handling code here:
      clearForm();
   }//GEN-LAST:event_btnResetActionPerformed

   private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
      // TODO add your handling code here:
      int selectedRow = tblSanPham.getSelectedRow();
      current = selectedRow;
      this.setForm(current);
   }//GEN-LAST:event_tblSanPhamMouseClicked

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
         java.util.logging.Logger.getLogger(Lab5_Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Lab5_Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Lab5_Bai2().setVisible(true); 
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAdd;
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnFirst;
   private javax.swing.JButton btnLast;
   private javax.swing.JButton btnNext;
   private javax.swing.JButton btnPrevious;
   private javax.swing.JButton btnReset;
   private javax.swing.JButton btnUpdate;
   private javax.swing.JComboBox<String> cboLoaiSP;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblSanPham;
   private javax.swing.JTextField txtGia;
   private javax.swing.JTextField txtMa;
   private javax.swing.JTextField txtSL;
   private javax.swing.JTextField txtTen;
   // End of variables declaration//GEN-END:variables
}
