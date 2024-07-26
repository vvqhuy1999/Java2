package lamthudethi.entity;
import java.util.Date;

public class Product {
   private String Id;
   private String Name;
   private double Price;
   private Date CreateDate = new Date();
   private String Image;

   public Product() {
   }

   public Product(String Id, String Name, double Price, String Image) {
      this.Id = Id;
      this.Name = Name;
      this.Price = Price;
      this.Image = Image;
   }

   public String getId() {
      return Id;
   }

   public void setId(String Id) {
      this.Id = Id;
   }

   public String getName() {
      return Name;
   }

   public void setName(String Name) {
      this.Name = Name;
   }

   public double getPrice() {
      return Price;
   }

   public void setPrice(double Price) {
      this.Price = Price;
   }

   public Date getCreateDate() {
      return CreateDate;
   }

   public void setCreateDate(Date CreateDate) {
      this.CreateDate = CreateDate;
   }

   public String getImage() {
      return Image;
   }

   public void setImage(String Image) {
      this.Image = Image;
   }
   
}
