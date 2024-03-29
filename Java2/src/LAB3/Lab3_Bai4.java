
package Lab3;

import java.io.File;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Lab3_Bai4 extends javax.swing.JFrame {

    
    public Lab3_Bai4() {
        initComponents();
        this.setTitle("QUAN LY NHAN VIEN");
        this.setLocationRelativeTo(null);
        loadDataToList();
        fillToTable();
    }

    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      lbName = new javax.swing.JLabel();
      lbSalary = new javax.swing.JLabel();
      txtName = new javax.swing.JTextField();
      txtSalary = new javax.swing.JTextField();
      btnAdd = new javax.swing.JButton();
      btnSave = new javax.swing.JButton();
      btnRead = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      tbMain = new javax.swing.JTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(255, 51, 51));
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("Quản Lý Nhân Viên");

      lbName.setText("Họ và tên");

      lbSalary.setText("Lương");

      btnAdd.setText("Thêm");
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
         }
      });

      btnSave.setText("Lưu");
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });

      btnRead.setText("Đọc");
      btnRead.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReadActionPerformed(evt);
         }
      });

      tbMain.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null},
            {null, null},
            {null, null},
            {null, null}
         },
         new String [] {
            "Họ và Tên ", "Lương"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.Object.class
         };
         boolean[] canEdit = new boolean [] {
            false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane1.setViewportView(tbMain);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(90, 90, 90)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(130, 130, 130))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnAdd)
                  .addGap(49, 49, 49)
                  .addComponent(btnSave)
                  .addGap(43, 43, 43)
                  .addComponent(btnRead))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(lbSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(txtName)
                     .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(46, 46, 46))
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addComponent(jLabel1)
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lbName))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(6, 6, 6)
                  .addComponent(lbSalary))
               .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnAdd)
               .addComponent(btnSave)
               .addComponent(btnRead))
            .addGap(40, 40, 40)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents
    
    List<Staff> list = new ArrayList<>();
    public static String path = "e:/fpoly/java2/staff.dat";
    //public static String path = System.getProperty("user.home") +
    //        File.separator +"Desktop" +File.separator+ "staff.dat";
    
    
    
    public boolean checkNull(){
      
      if(txtName.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên");
         txtName.requestFocus();
         return false;
      }
      else if(txtSalary.getText().isEmpty()){
         JOptionPane.showMessageDialog(this, "Vui lòng nhập Lương");
         txtSalary.requestFocus();
         return false;
      }
      
      return true;
   }
    
    private void addStaff(){
        
        if(checkNull()){
           String name = txtName.getText();
           Double luong = Double.parseDouble(txtSalary.getText());
            Staff nv = new Staff(name,luong);
            list.add(nv);
        }
        
    }
    
    public void loadDataToList(){
      list.add(new Staff("Quang Huy",5465634));
      list.add(new Staff("Minh",4534534));
      list.add(new Staff("Hoang",38457));
    }

    private void removetxt(){
       txtName.setText("");
       txtSalary.setText("");
    }
    private void fillToTable(){
      DefaultTableModel model = (DefaultTableModel) tbMain.getModel();
      model.setRowCount(0);
      
      for(Staff nv: list){
        Object[] row = new Object[]{nv.fullname,nv.salary};
        model.addRow(row);
      }
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       JOptionPane.showMessageDialog(this,path);
       XFile.writeObject(path, list);
        list.removeAll(list);
        JOptionPane.showMessageDialog(this, "Thông tin đã lưu.");
        fillToTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addStaff();
        fillToTable();
        removetxt();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
      list = (List<Staff>) XFile.readObject(path);
      JOptionPane.showMessageDialog(this, "Đã đọc file thành công");
      fillToTable();
    }//GEN-LAST:event_btnReadActionPerformed

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
            java.util.logging.Logger.getLogger(Lab3_Bai4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab3_Bai4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab3_Bai4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab3_Bai4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab3_Bai4().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAdd;
   private javax.swing.JButton btnRead;
   private javax.swing.JButton btnSave;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JLabel lbName;
   private javax.swing.JLabel lbSalary;
   private javax.swing.JTable tbMain;
   private javax.swing.JTextField txtName;
   private javax.swing.JTextField txtSalary;
   // End of variables declaration//GEN-END:variables
}
