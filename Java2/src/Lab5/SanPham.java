/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab5;

/**
 *
 * @author admin
 */
public class SanPham {
   String maSanPham;
   String tenSp;
   double donGia;
   int soLuong;
   LoaiSanPham loaiSanPham;
   
   public SanPham(){}

   public SanPham(String maSanPham, String tenSp, double donGia, int soLuong, LoaiSanPham loaiSanPham) {
      this.maSanPham = maSanPham;
      this.tenSp = tenSp;
      this.donGia = donGia;
      this.soLuong = soLuong;
      this.loaiSanPham = loaiSanPham;
   }

   public String getMaSanPham() {
      return maSanPham;
   }

   public void setMaSanPham(String maSanPham) {
      this.maSanPham = maSanPham;
   }

   public String getTenSp() {
      return tenSp;
   }

   public void setTenSp(String tenSp) {
      this.tenSp = tenSp;
   }

   public double getDonGia() {
      return donGia;
   }

   public void setDonGia(double donGia) {
      this.donGia = donGia;
   }

   public int getSoLuong() {
      return soLuong;
   }

   public void setSoLuong(int soLuong) {
      this.soLuong = soLuong;
   }

   public LoaiSanPham getLoaiSanPham() {
      return loaiSanPham;
   }

   public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
      this.loaiSanPham = loaiSanPham;
   }
   
}
