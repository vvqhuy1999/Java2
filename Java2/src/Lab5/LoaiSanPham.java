/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author admin
 */
public class LoaiSanPham {
   int maLoai;
   String tenLoai;
   
   public LoaiSanPham(){}

   public LoaiSanPham(int maLoai, String tenLoai) {
      this.maLoai = maLoai;
      this.tenLoai = tenLoai;
   }

   public int getMaLoai() {
      return maLoai;
   }

   public void setMaLoai(int maLoai) {
      this.maLoai = maLoai;
   }

   public String getTenLoai() {
      return tenLoai;
   }

   public void setTenLoai(String tenLoai) {
      this.tenLoai = tenLoai;
   }
   
   @Override
      public String toString() {
          return this.getTenLoai();
      }
   
}
