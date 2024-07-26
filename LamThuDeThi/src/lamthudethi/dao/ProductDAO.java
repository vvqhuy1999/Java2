package lamthudethi.dao;

import lamthudethi.entity.Product;
import lamthudethi.utils.XJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
   public void insert(Product model){
        String sql="INSERT INTO Poly_Products (Id, Name, Price, CreateDate, Image) VALUES (?, ?, ?, ?, ?)";
        XJDBC.update(sql, 
                model.getId(), 
                model.getName(), 
                model.getPrice(), 
                model.getCreateDate(),
                model.getImage());
                
    }
   public void update(Product model){
        String sql="UPDATE Poly_Products SET Name=?, Price=?, CreateDate=?, Image=? WHERE Id=?";
        XJDBC.update(sql, 
                model.getId(), 
                model.getName(), 
                model.getPrice(), 
                model.getCreateDate(),
                model.getImage());
    }
    
    public void delete(String Id){
        String sql="DELETE FROM Poly_Products WHERE Id=?";
        XJDBC.update(sql, Id);
    }
    
    public List<Product> selectAll(){
        String sql="SELECT * FROM Poly_Products";
        return selectBySql(sql);
    }
    
    protected List<Product> selectBySql(String sql, Object... args){
       List<Product> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJDBC.query(sql, args);
                while(rs.next()){
                    Product entity=new Product();
                    entity.setId(rs.getString("Id"));
                    entity.setName(rs.getString("Name"));
                    entity.setPrice(rs.getDouble("Price"));
                    entity.setCreateDate(rs.getDate("CreateDate"));
                    entity.setImage(rs.getString("Image"));
                    
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

    public Product selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
