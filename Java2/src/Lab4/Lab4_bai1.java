/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Lab4;


import java.sql.*;
/**
 *
 * @author admin
 */
public class Lab4_bai1 {

   public static void main(String args[]) {
      try{
         String user = "sa";
         String pass = "admin";
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String url = "jdbc:sqlserver://localhost:1433;database=FPL_DaoTao;encrypt=false";
         Connection con = (Connection) DriverManager.getConnection(url, user, pass);
         System.out.println("Kết nối tới cơ sở dữ liệu thành công!");
         String sql = "select * from students";
         Statement stm = (Statement) con.createStatement();
         ResultSet rs = (ResultSet) stm.executeQuery(sql);
         while (rs.next()){
            System.out.print(rs.getString("MaSV") + ", ");
            System.out.print(rs.getString("Hoten") + ", ");
            System.out.print(rs.getString("Email") + ", ");
            System.out.print(rs.getString("SoDT") + ", ");
            System.out.println(rs.getString("Gioitinh"));
         }
         con.close();
      }
      catch(Exception e)
      {
         System.out.println(e);
         System.out.println("Kết nối tới cơ sở dữ liệu thất bại.");
      }
   }
}
