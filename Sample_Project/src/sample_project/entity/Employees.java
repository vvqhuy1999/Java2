package sample_project.entity;

import java.util.Date;

public class Employees {
   private String id;
   private String Name;
   private Double Salary;
   private Date Birthday = new Date();
   private String Photo;

   public Employees() {
   }

   public Employees(String id, String Name, Double Salary, String Photo) {
      this.id = id;
      this.Name = Name;
      this.Salary = Salary;
      this.Photo = Photo;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return Name;
   }

   public void setName(String Name) {
      this.Name = Name;
   }

   public Double getSalary() {
      return Salary;
   }

   public void setSalary(Double Salary) {
      this.Salary = Salary;
   }

   public Date getBirthday() {
      return Birthday;
   }

   public void setBirthday(Date Birthday) {
      this.Birthday = Birthday;
   }

   public String getPhoto() {
      return Photo;
   }

   public void setPhoto(String Photo) {
      this.Photo = Photo;
   }
   
   
}
