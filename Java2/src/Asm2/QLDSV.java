package Asm2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.*;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLDSV extends javax.swing.JFrame {
    DefaultTableModel model;
    List<Students> lStudent = new ArrayList<>();
    int index = 0;
   public static String user = "sa";
   public static String pass = "admin";
   public static String url = "jdbc:sqlserver://localhost:1433;database=FPL_DaoTao;encrypt=false";
   public QLDSV() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel)tblStudent.getModel();
        String [] columnNames = {"Mã SV","Họ tên","Tiếng Anh","Tin học","GDTC","Điểm TB" };
        model.setColumnIdentifiers(columnNames);
        loadDataTolist();
        SapXep();
        fillToTable();
        index = 0;
        showDetail(index);
        //tblStudent.setRowSelectionInterval(index, index);
    }

    //public void loadDataTolist(){
        //lStudent.add (new Students("PS0001","Nguyễn Văn Nam",10,5,5,9));        
    //}
    
    public void loadDataTolist(){
      String [] headers = {"MaSV","Họ tên","Tiếng Anh","Tin học","GDTC","Điểm TB"};
      DefaultTableModel tblModel = new DefaultTableModel(headers,0);
      lStudent.clear();
      tblModel.setRowCount(0);
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
      String sql = "select s.MASV, s.HoTen, g.TiengAnh, g.TinHoc, g.GDTC\n" +
         "from STUDENTS s left join GRADE g\n" +
         "on s.MASV =  g.MASV;";
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      while (rs.next()){
            Students std = new Students();
            std.setMaSV(rs.getString("masv"));
            std.setHoten(rs.getString("hoten"));
            std.setTiengAnh(rs.getDouble("TiengAnh"));
            std.setTinhoc(rs.getDouble("TinHoc"));
            std.setGiaoducTC(rs.getDouble("GDTC"));
            lStudent.add(std);
         }
      conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      
//       for(Students s : lStudent){
//         tblModel.addRow(new Object[]{s.getMaSV(),s.getHoten(),s.getTiengAnh(),s.getTinhoc(),s.getGiaoducTC(),s.getDiemTb()});
//      }
      //tblStudent.setModel(tblModel);
   }
    
    public void fillToTable(){ 
      model.setRowCount(0);
      for(int i =0 ; i< 3; i++){
         model.addRow(new Object[]{
                  lStudent.get(i).getMaSV(),
                  lStudent.get(i).getHoten(),
                  lStudent.get(i).getTiengAnh(),
                  lStudent.get(i).getTinhoc(),
                  lStudent.get(i).getGiaoducTC(),
                  lStudent.get(i).getDiemTb()
                 });
      }
//        for (Students st : lStudent){
//            model.addRow(new Object[]{
//                st.getMaSV(),
//                st.getHoten(),
//                st.getTiengAnh(),
//                st.getTinhoc(),
//                st.getGiaoducTC(),
//                st.getDiemTb()
//            });
//        }
    }
    
   public void SapXep(){
      Comparator<Students> comp = new Comparator<Students>() {
            @Override 
            public int compare(Students s1, Students s2) {
                return Double.compare(s1.getDiemTb(),s2.getDiemTb());
            }
        };
        //Collections.sort(lStudent, comp);
        Collections.sort(lStudent, Collections.reverseOrder(comp));

   }
    
    public void showDetail(int index){
        txtMaSV.setText(lStudent.get(index).getMaSV());
        lblTen.setText(lStudent.get(index).getHoten());
        txtTiengAnh.setText(lStudent.get(index).getTiengAnh()+"");
        txtTinHoc.setText(lStudent.get(index).getTinhoc()+"");
        txtGiaoDucTC.setText(lStudent.get(index).getGiaoducTC()+"");
        lblDiem.setText(lStudent.get(index).getDiemTb()+"");        
    }
    
    public void showDetail(Students st){
        txtMaSV.setText(st.getMaSV());
        lblTen.setText(st.getHoten());
        txtTiengAnh.setText(st.getTiengAnh()+"");
        txtTinHoc.setText(st.getTinhoc()+"");
        txtGiaoDucTC.setText(st.getGiaoducTC()+"");
        lblDiem.setText(st.getDiemTb()+"");        
    }
    
    public void clearForm(){
        txtMaSV.setText("");
        lblTen.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        txtGiaoDucTC.setText("");
        lblDiem.setText("0.0");
        txtMaSV.requestFocus();
        tblStudent.clearSelection();
        index = -1;
    }

    public Students readForm(){
       Students st = new Students();
        st.setMaSV(txtMaSV.getText());
        st.setHoten("");
        st.setTiengAnh(Double.valueOf(txtTiengAnh.getText()));
        st.setTinhoc(Double.valueOf(txtTinHoc.getText()));
        st.setGiaoducTC(Double.valueOf(txtGiaoDucTC.getText()));
        return st;
    }
    
    public int ThemSV(Students s){
      int rs =0;
      try{
         Connection conn = DriverManager.getConnection(url, user, pass);
         
         String insert_sql = "insert into GRADE (masv,tienganh,tinhoc,gdtc) values (?,?,?,?)";
         PreparedStatement st = conn.prepareStatement(insert_sql);
         //st.setString(1,);
         st.setString(1,s.getMaSV());
         st.setDouble(2,s.getTiengAnh());
         st.setDouble(3,s.getTinhoc());
         st.setDouble(4,s.getGiaoducTC());
         rs = st.executeUpdate();
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
     return rs;
    }
    
    public Students TimtheoMa(String MaSV){
        for(Students st: lStudent){
            if(st.getMaSV().equalsIgnoreCase(MaSV)){
               return st; 
            }
        }
        return null;
    }
    
    public int capNhat(Students newst){
      int rs = 0 ;
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         String sql = "select MaSV from GRADE where MaSV = ?";
         PreparedStatement  st = con.prepareStatement(sql);
         st.setString(1, txtMaSV.getText());
         ResultSet rss = st.executeQuery();
         
         if(rss.next()){
             sql = "update GRADE set TiengAnh = ?, TinHoc = ?, GDTC = ? where MaSV = ?";
             st = con.prepareStatement(sql);
             st.setString(1, txtTiengAnh.getText());
             st.setString(2, txtTinHoc.getText());
             st.setString(3, txtGiaoDucTC.getText());
             st.setString(4, txtMaSV.getText());
             rs = st.executeUpdate();
         }else{
            JOptionPane.showMessageDialog(null, "Ko có MaSV vui Lưu dữ liệu");
         }
         con.close();
      }catch (Exception e){
         System.out.println(e);
      }
      return rs;
    }
    
    public void XoaSV(){
       if(txtMaSV.getText().equals("")){
         JOptionPane.showMessageDialog(this, "Nhập Mã SV");
         txtMaSV.requestFocus();
         return;
      }
      try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String sql = "delete from GRADE where MaSV = ?" ;    //+ txtMaSV.getText()
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
      SapXep();
      fillToTable();
//        lStudent.remove(index);
//        fillToTable();
//        clearForm();
//        JOptionPane.showMessageDialog(this, "Đã xóa");
    }
    
    public void FirstSV(){
        index = 0;
        tblStudent.setRowSelectionInterval(index, index);
        showDetail(index);
    }

    public void LastSV(){
        index = 2;
        //JOptionPane.showMessageDialog(this,index);
        tblStudent.setRowSelectionInterval(index, index);
        showDetail(index);
    }
    
    public void PriSV(){
        if(index == 0){
         JOptionPane.showMessageDialog(null, "Dang o dau danh sach");
         return;
      }
        index --;
        tblStudent.setRowSelectionInterval(index, index);
        showDetail(index);
    }
    public void NextSV(){
       if(index == 2){
         JOptionPane.showMessageDialog(null, "Dang o cuoi danh sach");
         return;
      } 
      index ++;   
      tblStudent.setRowSelectionInterval(index, index);
      showDetail(index);
    }
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTable2 = new javax.swing.JTable();
      jScrollPane4 = new javax.swing.JScrollPane();
      jTable4 = new javax.swing.JTable();
      jLabel1 = new javax.swing.JLabel();
      jPanel1 = new javax.swing.JPanel();
      lblMaSV = new javax.swing.JLabel();
      txtSearch = new javax.swing.JTextField();
      btnSearch = new javax.swing.JButton();
      jPanel2 = new javax.swing.JPanel();
      lblHoTen = new javax.swing.JLabel();
      lblMa = new javax.swing.JLabel();
      lblTiengAnh = new javax.swing.JLabel();
      lblTinhoc = new javax.swing.JLabel();
      lblGiaoDucTC = new javax.swing.JLabel();
      txtMaSV = new javax.swing.JTextField();
      txtTiengAnh = new javax.swing.JTextField();
      txtTinHoc = new javax.swing.JTextField();
      txtGiaoDucTC = new javax.swing.JTextField();
      lblDiemTB = new javax.swing.JLabel();
      lblDiem = new javax.swing.JLabel();
      lblTen = new javax.swing.JLabel();
      btnNew = new javax.swing.JButton();
      btnSave = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();
      btnUpdate = new javax.swing.JButton();
      btnFrist = new javax.swing.JButton();
      btnPri = new javax.swing.JButton();
      btnNext = new javax.swing.JButton();
      btnLast = new javax.swing.JButton();
      btnSinhVien = new javax.swing.JLabel();
      jScrollPane5 = new javax.swing.JScrollPane();
      tblStudent = new javax.swing.JTable();
      btnBack = new javax.swing.JButton();
      btnLogout = new javax.swing.JButton();

      jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane1.setViewportView(jTable1);

      jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane2.setViewportView(jTable2);

      jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane4.setViewportView(jTable4);

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Quản Lý Điểm Sinh Viên");

      jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 255));
      jLabel1.setText("Quản Lý Điểm Sinh Viên");

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

      lblMaSV.setText("Mã SV:");

      txtSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSearchActionPerformed(evt);
         }
      });

      btnSearch.setText("Search");
      btnSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(23, 23, 23)
            .addComponent(lblMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnSearch)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblMaSV)
               .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

      lblHoTen.setText("Họ tên SV:");

      lblMa.setText("Mã SV:");

      lblTiengAnh.setText("Tiếng Anh:");

      lblTinhoc.setText("Tin học:");

      lblGiaoDucTC.setText("Giáo dục TC:");

      txtMaSV.setEditable(false);
      txtMaSV.setForeground(new java.awt.Color(51, 51, 255));

      lblDiemTB.setText("Điểm TB:");

      lblDiem.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
      lblDiem.setForeground(new java.awt.Color(0, 0, 255));
      lblDiem.setText("9");

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(lblGiaoDucTC, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
               .addComponent(lblTinhoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lblTiengAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lblMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                     .addComponent(txtTiengAnh)
                     .addComponent(txtTinHoc)
                     .addComponent(txtGiaoDucTC))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDiemTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                     .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, Short.MAX_VALUE))))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(lblHoTen)
               .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblMa)
               .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblTiengAnh)
               .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblDiemTB))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblTinhoc)
                     .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(lblDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(15, 15, 15)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblGiaoDucTC)
               .addComponent(txtGiaoDucTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      btnNew.setText("New");
      btnNew.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
         }
      });

      btnSave.setText("Save");
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });

      btnDelete.setText("Delete");
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      btnUpdate.setText("Update");
      btnUpdate.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
         }
      });

      btnFrist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/first.png"))); // NOI18N
      btnFrist.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnFristActionPerformed(evt);
         }
      });

      btnPri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pri.png"))); // NOI18N
      btnPri.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnPriActionPerformed(evt);
         }
      });

      btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/next.png"))); // NOI18N
      btnNext.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNextActionPerformed(evt);
         }
      });

      btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/last.png"))); // NOI18N
      btnLast.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLastActionPerformed(evt);
         }
      });

      btnSinhVien.setForeground(new java.awt.Color(0, 0, 255));
      btnSinhVien.setText("3 Sinh viên có điểm cao nhất :");

      tblStudent.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null}
         },
         new String [] {
            "Mã SV", "Họ Tên", "Tiếng Anh", "Tin học", "GDTC", "Điểm TB"
         }
      ));
      tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblStudentMouseClicked(evt);
         }
      });
      jScrollPane5.setViewportView(tblStudent);

      btnBack.setText("< Back");
      btnBack.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
         }
      });

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
                  .addGap(5, 5, 5)
                  .addComponent(btnBack)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btnLogout))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(6, 6, 6)
                              .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(btnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(46, 46, 46)
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(btnFrist)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPri)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnNext)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLast))
                                 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(11, 11, 11))
                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                           .addComponent(btnNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING))))
                  .addGap(0, 22, Short.MAX_VALUE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnBack))
               .addGroup(layout.createSequentialGroup()
                  .addGap(12, 12, 12)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(btnLogout)
                     .addComponent(jLabel1))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addComponent(btnNew)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnSave)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnDelete)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btnUpdate))
               .addGroup(layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(34, 34, 34)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btnFrist)
               .addComponent(btnPri)
               .addComponent(btnNext)
               .addComponent(btnLast))
            .addGap(17, 17, 17)
            .addComponent(btnSinhVien)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Students st = readForm();
        int rs = ThemSV(st);
      if(rs >0){
         JOptionPane.showMessageDialog(this, "Thêm Điểm thành công");
         loadDataTolist();
         SapXep();
         fillToTable();
      }
      else 
         JOptionPane.showMessageDialog(this, "Thêm Điểm Thất bại");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        index = tblStudent.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        XoaSV();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
       Students st = readForm(); 
       int rs = capNhat(st);
      if(rs >0){
         JOptionPane.showMessageDialog(this, "Cập nhật thành công");
         loadDataTolist();
         SapXep();
         fillToTable();
      }
      else 
         JOptionPane.showMessageDialog(this, "Cập nhật Điểm Thất bại");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(TimtheoMa(txtSearch.getText()) == null){
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
        }else{
            showDetail(TimtheoMa(txtSearch.getText()));
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFristActionPerformed
        FirstSV();
    }//GEN-LAST:event_btnFristActionPerformed

    private void btnPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriActionPerformed

       PriSV();
    }//GEN-LAST:event_btnPriActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        NextSV();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        LastSV();
    }//GEN-LAST:event_btnLastActionPerformed

   private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_txtSearchActionPerformed

   private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      // TODO add your handling code here:
    
   }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDSV().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnBack;
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnFrist;
   private javax.swing.JButton btnLast;
   private javax.swing.JButton btnLogout;
   private javax.swing.JButton btnNew;
   private javax.swing.JButton btnNext;
   private javax.swing.JButton btnPri;
   private javax.swing.JButton btnSave;
   private javax.swing.JButton btnSearch;
   private javax.swing.JLabel btnSinhVien;
   private javax.swing.JButton btnUpdate;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JTable jTable1;
   private javax.swing.JTable jTable2;
   private javax.swing.JTable jTable4;
   private javax.swing.JLabel lblDiem;
   private javax.swing.JLabel lblDiemTB;
   private javax.swing.JLabel lblGiaoDucTC;
   private javax.swing.JLabel lblHoTen;
   private javax.swing.JLabel lblMa;
   private javax.swing.JLabel lblMaSV;
   private javax.swing.JLabel lblTen;
   private javax.swing.JLabel lblTiengAnh;
   private javax.swing.JLabel lblTinhoc;
   private javax.swing.JTable tblStudent;
   private javax.swing.JTextField txtGiaoDucTC;
   private javax.swing.JTextField txtMaSV;
   private javax.swing.JTextField txtSearch;
   private javax.swing.JTextField txtTiengAnh;
   private javax.swing.JTextField txtTinHoc;
   // End of variables declaration//GEN-END:variables
}
