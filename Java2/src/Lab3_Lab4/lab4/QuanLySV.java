
package lab4;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class QuanLySV extends javax.swing.JFrame {
    Connection conn = Lab4b1.conntoSQLServer("sa","1231211ok",1433,"QLSinhVien");
    ArrayList<Student> list = new ArrayList<>();
   /* private String url ="jdbc:sqlserver://localhost:" + "1433" + 
                ";databaseName = " + "QLSinhVien" + 
                ";encrypt=false" ; ;
    */
    int curr =0; //vị trí đang xử lí
    
       void luu()
    {
        if (tfMaSV.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Không bỏ trống mã sinh viên.");
            tfMaSV.setBackground(Color.red);
            tfMaSV.requestFocus();
        }
        else
        {
            tfMaSV.setBackground(Color.WHITE);
            try 
            {
            //    Connection con = DriverManager.getConnection(url);
                String sql  = "insert into Student values(?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, tfMaSV.getText());
                st.setString(2, tfHoten.getText());
                st.setString(3, tfEmail.getText());
                st.setString(4, tfSDT.getText());
                boolean gt = false;
                if (rbtNam.isSelected())
                    gt = true;
                
                else
                    gt = false;
                st.setBoolean(5, gt);
                st.setString(6, tfDC.getText());
                st.execute();
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
                
                list.clear();
                ThemDSSV();
                //conn.close();
            } 
            catch (Exception ex) 
            {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Lưu thất bại!");
            }
        }
    }
        
    void XoaVB()
    {
        tfMaSV.setText(null);
        tfHoten.setText(null);
        tfEmail.setText(null);
        tfSDT.setText(null);
        rbtNam.setSelected(false);
        rbtNu.setSelected(true);
        tfDC.setText(null);
        tfMaSV.requestFocus();
    }
    
        void them()
    {
        XoaVB();
    }
    
        void capnhat()
    {
        if (tfMaSV.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Nhập mã thành công");
            tfMaSV.requestFocus();
            tfMaSV.setText(null);
        }
        try 
        {
        //    Connection con = DriverManager.getConnection(url);
            String sql  = "update Student set HoTen = ?, Email = ?, Sdt = ?, GioiTinh = ?, DiaChi = ? where MaSV = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, tfHoten.getText());
            st.setString(2, tfEmail.getText());
            st.setString(3, tfSDT.getText());
            boolean gt = false;
            if (rbtNam.isSelected())
                gt = true;
            else
                gt = false;
            st.setBoolean(4, gt);
            st.setString(5, tfDC.getText());
            st.setString(6, tfMaSV.getText());
            st.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            list.clear();
            ThemDSSV();
            //conn.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
    }
    
    void xoa()
    {
        if (tfMaSV.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Nhập mã sv");
            tfMaSV.requestFocus();
            tfMaSV.setText(null);
        }
        try {
            int r = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION)
            {
            //    Connection con = DriverManager.getConnection(url);
                String sql  = "delete from Student where MASV = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, tfMaSV.getText());
                st.execute();
                JOptionPane.showMessageDialog(this, "Xác Nhận thành công");
                XoaVB();
                list.clear();
                ThemDSSV();
                //conn.close();
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
    }
    
         
    void HienThi(int i)
    {
        Student hs = list.get(i);
        tfMaSV.setText(hs.getMaSV());
        tfHoten.setText(hs.getHoten());
        tfEmail.setText(hs.getEmail());
        tfSDT.setText(hs.getSDT());
        boolean gt = hs.getGioitinh();
        if (gt == true)
            rbtNam.setSelected(true);
        else
            rbtNu.setSelected(true);
        tfDC.setText(hs.getDiachi());
    }
    
    void ThemDSSV(){
        try 
        {
            //    Connection con = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String sql  = "Select * from Student";
            ResultSet rs = st.executeQuery(sql);
            list.clear();
            while(rs.next())
            {
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                String sdt = rs.getString(4);
                boolean gt = rs.getBoolean(5);
                String diachi = rs.getString(6);
                Student hs = new Student(masv, hoten, email, sdt, gt, diachi);
                list.add(hs);
            }
            //conn.close();
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }
    
    public QuanLySV() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        ThemDSSV();
        HienThi(curr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLab4 = new javax.swing.JLabel();
        lbMaSV = new javax.swing.JLabel();
        btNew = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        tfMaSV = new javax.swing.JTextField();
        lbHoten = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        tfHoten = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        lbSex = new javax.swing.JLabel();
        rbtNam = new javax.swing.JRadioButton();
        rbtNu = new javax.swing.JRadioButton();
        lbDC = new javax.swing.JLabel();
        btLast = new javax.swing.JButton();
        btNext = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        btFirst = new javax.swing.JButton();
        tfDC = new javax.swing.JTextField();
        btClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbLab4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbLab4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLab4.setText("QUẢN LÝ USERS");

        lbMaSV.setText("Mã SV:");

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        btNew.setText("New");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Delete.png"))); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/update_1.png"))); // NOI18N
        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Save.png"))); // NOI18N
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        lbHoten.setText("Họ tên:");

        lbEmail.setText("Email:");

        lbSDT.setText("Số ĐT:");

        tfHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHotenActionPerformed(evt);
            }
        });

        lbSex.setText("Giới tính:");

        rbtNam.setText("Nam");

        rbtNu.setText("Nữ");

        lbDC.setText("Địa chỉ:");

        btLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/last.png"))); // NOI18N
        btLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLastActionPerformed(evt);
            }
        });

        btNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/next.png"))); // NOI18N
        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });

        btBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pri.png"))); // NOI18N
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        btFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/first.png"))); // NOI18N
        btFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFirstActionPerformed(evt);
            }
        });

        tfDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDCActionPerformed(evt);
            }
        });

        btClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Close.png"))); // NOI18N
        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btLast, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btNext, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbSex)
                                    .addComponent(lbDC))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(rbtNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtNu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(tfDC))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbHoten))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUpdate)
                            .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btClose))
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(lbLab4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbLab4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaSV)
                    .addComponent(btNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoten)
                    .addComponent(tfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSDT)
                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSex)
                    .addComponent(rbtNam)
                    .addComponent(rbtNu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDC)
                    .addComponent(tfDC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btNewActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tfHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHotenActionPerformed

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextActionPerformed
        curr++;
        if (curr >= list.size())
        {
        JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách!");
        return;
        }
        HienThi(curr);
    
            
    }//GEN-LAST:event_btNextActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        curr--;
        if (curr < 0)
        {
            JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách!");
            return;
        }
        HienThi(curr);
    }//GEN-LAST:event_btBackActionPerformed

    private void btFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFirstActionPerformed
        // TODO add your handling code here:
        curr = 0;
        HienThi(curr);
        JOptionPane.showMessageDialog(this, "Đang ở đầu danh sách!");
    }//GEN-LAST:event_btFirstActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        // TODO add your handling code here:
        capnhat();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLastActionPerformed
        // TODO add your handling code here:
        curr = list.size() - 1;
        HienThi(curr);
        JOptionPane.showMessageDialog(this, "Đang ở cuối danh sách!");
    }//GEN-LAST:event_btLastActionPerformed

    private void tfDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDCActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        try {
            // TODO add your handling code here:
            JOptionPane.showMessageDialog(this, "Ngắt kết nối thành công!");
            conn.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi ngắt kết nối!");
        }
    }//GEN-LAST:event_btCloseActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btClose;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btFirst;
    private javax.swing.JButton btLast;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btUpdate;
    private javax.swing.JLabel lbDC;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHoten;
    private javax.swing.JLabel lbLab4;
    private javax.swing.JLabel lbMaSV;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbSex;
    private javax.swing.JRadioButton rbtNam;
    private javax.swing.JRadioButton rbtNu;
    private javax.swing.JTextField tfDC;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfHoten;
    private javax.swing.JTextField tfMaSV;
    private javax.swing.JTextField tfSDT;
    // End of variables declaration//GEN-END:variables
}
