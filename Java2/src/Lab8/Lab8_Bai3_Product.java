package Lab8;

import java.io.Serializable;

public class Lab8_Bai3_Product implements Serializable{
        public String name;
        public Double price;
        public Lab8_Bai3_Product(String name, Double price){
            this.name = name;
            this.price = price;
         }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public Double getPrice(){
            return price;
        }
        public void setPrice(Double price){
            this.price = price;
        }
    }

