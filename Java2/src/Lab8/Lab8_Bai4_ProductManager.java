package Lab8;

public class Lab8_Bai4_ProductManager {
    public static void main(String args[]) {
        Lab8_Bai3_Product p1 = new Lab8_Bai3_Product("Iphone 13", 5000.0);
        Lab8_Bai3_Product p2 = new Lab8_Bai3_Product("Iphone 13 Pro", 7000.0);
        
        Lab8_Bai4_ProductDAO dao = new Lab8_Bai4_ProductDAO();
        dao.add(p1);
        dao.add(p2);
        try{
            //dao.write("data.dat");
            //System.out.println("Saved");
            
            dao.read("data.dat");
            Lab8_Bai3_Product p = dao.find("Iphone 13");
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
