/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

/**
 *
 * @author admin
 */
public class SanPhamDAO {
   String insert_sql = "insert into SanPham (maSP,tenSP,donGia,soLuong,maloai) values (?,?,?,?,?)";
   String update_sql = "update SanPham set tenSP = ?,donGia =? ,soLuong = ?,maloai = ? where maSP =?";
   String delete_sql = "delete from SanPham where maSP= ?";
   String select_all_sql = "select * from SanPham";
   String select_by_ID_sql = "select * from SanPham where maSP= ? ";
   String select_LoaiSP_BY_ID_sql = "select * from LoaiSanPham where MaLoai =?";
   String select_all_LoaiSP_sql = "Select * from LoaiSanPham";
   String userName = "sa";
   String password = "admin";
   String url = "jdbc:sqlserver://localhost:1433;database=QLBH;encrypt=false";
   
   public SanPhamDAO(){};
   
   public int insert (SanPham sp){
      int rs =0;
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         PreparedStatement st = conn.prepareStatement(insert_sql);
         st.setString(1,sp.getMaSanPham());
         st.setString(2,sp.getTenSp());
         st.setDouble(3,sp.getDonGia());
         st.setInt(4,sp.getSoLuong());
         st.setInt(5,sp.getLoaiSanPham().getMaLoai());
         rs = st.executeUpdate();
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return rs;
   }
   
   public int update (SanPham sp){
      int rs =0;
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         PreparedStatement st = conn.prepareStatement(update_sql);
         
         st.setString(1,sp.getTenSp());
         st.setDouble(2,sp.getDonGia());
         st.setInt(3,sp.getSoLuong());
         st.setInt(4,sp.getLoaiSanPham().getMaLoai());
         st.setString(5,sp.getMaSanPham());
         rs = st.executeUpdate();
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return rs;
   }
   
   public int delete (String maSP){
      int rs =0;
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         PreparedStatement st = conn.prepareStatement(delete_sql);
         st.setString(1, maSP);
         rs = st.executeUpdate();
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return rs;
   }
   
   // getAllSanPham: Lấy tất cả danh sách sản phẩm trong cơ sở dữ liệu
   public List<SanPham> getAllSanPham(){
      List<SanPham> list = new ArrayList<>();
//      LoaiSanPham lsp = new LoaiSanPham();
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         String sql = select_all_sql;
         Statement stm = conn.createStatement();
         ResultSet rs = stm.executeQuery(sql);
         while (rs.next()){
            SanPham sp = new SanPham();
            sp.setMaSanPham(rs.getString("maSP"));
            sp.setTenSp(rs.getString("tenSP"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setDonGia(rs.getDouble("donGia"));
            int maLoai = rs.getInt("maloai");
            sp.setLoaiSanPham(this.getLoaiSanPhamByMaLoai(maLoai));
            list.add(sp);
         }
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return list;
   }
   
   // getSanPhamByMaSanPham: Lấy sản phẩm trong cơ sở dữ liệu 
   //theo mã sản phẩm
   public SanPham getSanPhamByMaSanpham(String maSP){
      SanPham sp = new SanPham();
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         String sql = select_by_ID_sql;
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, maSP);
         ResultSet rs = stm.executeQuery();
         while (rs.next()){
            sp.setMaSanPham(rs.getString("maSP"));
            sp.setTenSp(rs.getString("tenSP"));
            sp.setSoLuong(rs.getInt("soLuong"));
            sp.setDonGia(rs.getDouble("donGia"));
            int maLoai = rs.getInt("maloai");
            sp.setLoaiSanPham(this.getLoaiSanPhamByMaLoai(maLoai));
         }
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return sp;
   }
   
   //getAllLoaiSanPham: Lấy tất cả danh sách loại sản phẩm trong cơ sở dữ liệu
   public List<LoaiSanPham> getAllLoaiSanPham(){
      List<LoaiSanPham> dslsp = new ArrayList<>();
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         String sql = select_all_LoaiSP_sql;
         Statement stm = conn.createStatement();
         ResultSet rs = stm.executeQuery(sql);
         while (rs.next()){
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setMaLoai(rs.getInt("maLoai"));
            lsp.setTenLoai(rs.getString("tenLoai"));
            dslsp.add(lsp);
         }
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return dslsp;
   }
   
   //getLoaiSanPhamByMaLoai: Lấy loại sản phẩm trong cơ sở dữ liệu theo mã loại
   public LoaiSanPham getLoaiSanPhamByMaLoai(int maLoai){
      LoaiSanPham lsp = new LoaiSanPham();
      try{
         Connection conn = DriverManager.getConnection(url,userName,password);
         String sql = select_LoaiSP_BY_ID_sql;
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setInt(1, maLoai);
         ResultSet rs = stm.executeQuery();
         while (rs.next()){
            lsp.setMaLoai(rs.getInt("maLoai"));
            lsp.setTenLoai(rs.getString("tenLoai"));
         }
         conn.close();
      }
      catch(Exception e){
         System.out.println(e);
      }
      return lsp;
   }
}
