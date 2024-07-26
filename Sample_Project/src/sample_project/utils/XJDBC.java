package sample_project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJDBC {
   private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   private static final String DB_URL = "jdbc:sqlserver://WebStore.mssql.somee.com;database=WebStore;encrypt=true;trustServerCertificate=true;";
   private static final String USERNAME = "songlong_SQLLogin_1";
   private static final String PASSWORD = "p5xhkkw67t";
   static{
        try {            
            Class.forName(DRIVER);
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
        public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);
        }
        else{
            pstmt = connection.prepareStatement(sql);
        }
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static void update(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJDBC.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public static ResultSet query(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJDBC.getStmt(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
        public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = XJDBC.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
