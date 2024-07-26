package Lab8;

import java.io.Serializable;

public class Lab8_Bai4_ProductDAO extends Lab8_Bai3_DAO<Lab8_Bai3_Product>{

    @Override
    public void update(Lab8_Bai3_Product product) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equalsIgnoreCase(product.getName())){
            list.set(i, product);
            break;
            }
        }   
    }

    @Override
    public Lab8_Bai3_Product find(Serializable id) {
        for(Lab8_Bai3_Product p : list){
            if (p.getName().equals(id)){
                return p;
            }
        }
        return null;
    }

    void update(String propdat) {
   
    }
    
}
