/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

/**
 *
 * @author admin
 */
public class Student {
    String maSV;
   String hoTen;
   String mail;
   String soDT;
   String diaChi;
   boolean gioiTinh;

   public Student(String maSV, String hoTen, String mail, String soDT, String diaChi, boolean gioiTinh) {
      this.maSV = maSV;
      this.hoTen = hoTen;
      this.mail = mail;
      this.soDT = soDT;
      this.diaChi = diaChi;
      this.gioiTinh = gioiTinh;
   }
   
   public Student(){}

   public String getMaSV() {
      return maSV;
   }

   public void setMaSV(String maSV) {
      this.maSV = maSV;
   }

   public String getHoTen() {
      return hoTen;
   }

   public void setHoTen(String hoTen) {
      this.hoTen = hoTen;
   }

   public String getMail() {
      return mail;
   }

   public void setMail(String mail) {
      this.mail = mail;
   }

   public String getSoDT() {
      return soDT;
   }

   public void setSoDT(String soDT) {
      this.soDT = soDT;
   }

   public String getDiaChi() {
      return diaChi;
   }

   public void setDiaChi(String diaChi) {
      this.diaChi = diaChi;
   }

   public boolean isGioiTinh() {
      return gioiTinh;
   }

   public void setGioiTinh(boolean gioiTinh) {
      this.gioiTinh = gioiTinh;
   }
}
