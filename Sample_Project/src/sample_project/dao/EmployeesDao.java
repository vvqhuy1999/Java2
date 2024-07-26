package sample_project.dao;


import sample_project.utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample_project.entity.Employees;

public class EmployeesDao {
//   public void insert(Employees model){
//        String sql="INSERT INTO Poly_Employees (Id, Name, Salary, Birthday, Photo) VALUES (?, ?, ?, ?, ?)";
//        XJDBC.update(sql, 
//                model.getId(), 
//                model.getName(), 
//                model.getSalary(), 
//                model.getBirthday(),
//                model.getPhoto()
//        );       
//    }
   public void update(Employees model){
        String sql="UPDATE Poly_Employees SET Name=?, Salary=?, Birthday=?, Photo=? WHERE Id=?";
        XJDBC.update(sql, 
                model.getId(), 
                model.getName(), 
                model.getSalary(), 
                model.getBirthday(),
                model.getPhoto()
        );
    }
   
   public void delete(String Id){
        String sql="DELETE FROM Poly_Employees WHERE Id=?";
        XJDBC.update(sql, Id);
    }
   
   public List<Employees> selectAll(){
        String sql="SELECT * FROM Poly_Employees";
        return selectBySql(sql);
    }
    
    protected List<Employees> selectBySql(String sql, Object... args){
       List<Employees> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while(rs.next()){
                    Employees entity=new Employees();
                    entity.setId(rs.getString("Id"));
                    entity.setName(rs.getString("Name"));
                    entity.setSalary(rs.getDouble("Salary"));
                    entity.setBirthday(rs.getDate("Birthday"));
                    entity.setPhoto(rs.getString("Photo"));
                    
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Employees selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
