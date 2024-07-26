
package lamthudethi.ui;

import lamthudethi.dao.ProductDAO;
import lamthudethi.entity.Product;
import lamthudethi.utils.XDate;
import lamthudethi.utils.XJDBC;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductUI extends javax.swing.JFrame {

   DefaultTableModel model;
   /**
    * Creates new form ProductUIx 
    */
   public static int index=0;
   public ProductUI() {
      initComponents();
      this.setLocationRelativeTo(null);
      model = (DefaultTableModel)tblProduct.getModel();
      String [] columnNames = {"Id","Name","Price","Date","Image"};
      model.setColumnIdentifiers(columnNames);
      fillTable();
      tblProduct.setRowSelectionInterval(index, index);
      showDetail(index);
   }
   
   ProductDAO product = new ProductDAO();
   public List<Product> list = product.selectAll();
   public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        model.setRowCount(0);
        try {
            for (Product pr : list) {
                Object[] row = {
                    pr.getId(),
                    pr.getName(),
                    pr.getPrice(),
                    XDate.toString(pr.getCreateDate(), "MM/dd/yyyy"),
                    pr.getImage()
                };
                model.addRow(row);
            }
        } 
        catch (Exception e) {
            
        }
    }
   
   public void showDetail(int index){
        txtId.setText(list.get(index).getId());
        txtName.setText(list.get(index).getName());
        txtPrice.setText(list.get(index).getPrice()+ "");
        txtImage.setText(list.get(index).getImage()+ "");
        txtDate.setText(list.get(index).getCreateDate() + "");
    }
   
   public Product readForm(){
       Product p = new Product();
        p.setId(txtId.getText());
        p.setName(txtName.getText());
        p.setPrice(Float.valueOf(txtPrice.getText()));
        p.setImage(txtImage.getText());
        p.setCreateDate(XDate.toDate(txtDate.getText(), "MM/dd/yyyy"));
        return p;
    }
   public void clearForm(){
      txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
        txtImage.setText("");
        txtDate.setText("");
   }
   
   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      txtId = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      txtPrice = new javax.swing.JTextField();
      jLabel3 = new javax.swing.JLabel();
      txtDate = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      txtName = new javax.swing.JTextField();
      txtImage = new javax.swing.JTextField();
      btnCreate = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();
      btnReset = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblProduct = new javax.swing.JTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText("Id");

      txtId.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtIdActionPerformed(evt);
         }
      });

      jLabel2.setText("Price");

      jLabel3.setText("Create Date");

      jLabel4.setText("Name");

      jLabel5.setText("Image");

      txtName.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtNameActionPerformed(evt);
         }
      });

      btnCreate.setText("Create");
      btnCreate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateActionPerformed(evt);
         }
      });

      btnDelete.setText("Delete");
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      btnReset.setText("Reset");
      btnReset.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnResetActionPerformed(evt);
         }
      });

      tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
      tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblProductMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tblProduct);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(106, 106, 106)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnCreate)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnDelete)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnReset))
               .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                     .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING))
                  .addGap(50, 50, 50)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                     .addComponent(txtImage))))
            .addContainerGap(97, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(46, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(39, 39, 39)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(27, 27, 27)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnCreate)
               .addComponent(btnDelete)
               .addComponent(btnReset))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtIdActionPerformed

   private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtNameActionPerformed

   private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
      // TODO add your handling code here:
      Product p = readForm();
      // TODO add your handling code here:
      try {
         product.insert(p);
         this.clearForm();
         list.clear();
         list = product.selectAll();
         JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
         this.fillTable();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
      }
      
      
   }//GEN-LAST:event_btnCreateActionPerformed

   private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
      // TODO add your handling code here:
        this.clearForm();
   }//GEN-LAST:event_btnResetActionPerformed

   private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
      // TODO add your handling code here:
      index = tblProduct.getSelectedRow();
      showDetail(index);
   }//GEN-LAST:event_tblProductMouseClicked

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      // TODO add your handling code here:
      
      try {
         String id = txtId.getText();
         product.delete(id);
         this.clearForm();
         list.clear();
         list = product.selectAll();
         JOptionPane.showMessageDialog(this, "Xóa thành công!");
         this.fillTable();
      } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Xóa thất bại!");
      }
      
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
         java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(ProductUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new ProductUI().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCreate;
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnReset;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblProduct;
   private javax.swing.JTextField txtDate;
   private javax.swing.JTextField txtId;
   private javax.swing.JTextField txtImage;
   private javax.swing.JTextField txtName;
   private javax.swing.JTextField txtPrice;
   // End of variables declaration//GEN-END:variables
}
