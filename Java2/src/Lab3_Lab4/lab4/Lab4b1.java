
package lab4;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Lab4b1 {
    public static Connection conntoSQLServer(String user,String pass,int port,String databasename){
                String db_url = 
                "jdbc:sqlserver://localhost:" + port + 
                ";databaseName = " + databasename + 
                ";encrypt=false" ;
                        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(db_url,user,pass);
        } catch (SQLException ex) { 
            System.out.println("Loi ket noi!");
            return null;  }
        return conn;       
    }

    public static void main(String[] args) {
    Connection conn = conntoSQLServer("sa","1231211ok",1433,"QLSinhVien");    
    try{
        String sql = "select * from student";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            System.out.print(rs.getString("MaSV") + ", ");
            System.out.print(rs.getString("Hoten") + ", ");
            System.out.print(rs.getString("Email") + ", ");
            System.out.print(rs.getString("SoDT") + ", ");
            System.out.print(rs.getString("Gioitinh") + ", ");
            System.out.println(rs.getString("DiaChi") + ", ");
        }
        conn.close();
    } catch(Exception e){
        System.out.println("Loi du lieu!");
        System.out.println(e);
    }           
    }
    
}
