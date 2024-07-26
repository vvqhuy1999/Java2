/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThiThu;

/**
 *
 * @author admin
 */
public class Sach {
   public String masach;
   public String tensach;
   public float gia;
   public int nam;

   public Sach() {
   }

   public Sach(String masach, String tensach, float gia, int nam) {
      this.masach = masach;
      this.tensach = tensach;
      this.gia = gia;
      this.nam = nam;
   }

   public String getMasach() {
      return masach;
   }

   public void setMasach(String masach) {
      this.masach = masach;
   }

   public String getTensach() {
      return tensach;
   }

   public void setTensach(String tensach) {
      this.tensach = tensach;
   }

   public float getGia() {
      return gia;
   }

   public void setGia(float gia) {
      this.gia = gia;
   }

   public int getNam() {
      return nam;
   }

   public void setNam(int nam) {
      this.nam = nam;
   }
 
}
