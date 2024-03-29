
package LAB2;

public class Student {
   public String name;
   public double marks;
   public String course;
   
   public Student(){}
   
   public String getGrade(){
      if(this.marks < 3){
         return "Kém";
      }
      if(this.marks < 5){
         return "Yếu";
      }
      if(this.marks < 6.5){
         return "Trung bình";
      }
      if(this.marks < 7.5){
         return "Khá";
      }
      if(this.marks < 9){
         return "Giỏi";
      }
      return "Xuất sắc";
   }
   
   public boolean isBonus(){
      return this.marks >= 7.5;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getMarks() {
      return marks;
   }

   public void setMarks(double marks) {
      this.marks = marks;
   }

   public String getCourse() {
      return course;
   }

   public void setCourse(String course) {
      this.course = course;
   }

   public Student(String name, double marks, String course) {
      this.name = name;
      this.marks = marks;
      this.course = course;
   }
   
   
   
}
