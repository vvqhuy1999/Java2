package Asm2;

public class Students {
    private String MaSV , Hoten;
    private Double TiengAnh, Tinhoc, GiaoducTC; 

   public Students() {
   }

     
    public Students(String MaSV, String Hoten, Double TiengAnh, Double Tinhoc, Double GiaoducTC) {
        this.MaSV = MaSV;
        this.Hoten = Hoten;
        this.TiengAnh = TiengAnh;
        this.Tinhoc = Tinhoc;
        this.GiaoducTC = GiaoducTC;
        //this.DiemTb = DiemTb;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public Double getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(Double TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public Double getTinhoc() {
        return Tinhoc;
    }

    public void setTinhoc(Double Tinhoc) {
        this.Tinhoc = Tinhoc;
    }

    public Double getGiaoducTC() {
        return GiaoducTC;
    }

    public void setGiaoducTC(Double GiaoducTC) {
        this.GiaoducTC = GiaoducTC;
    }

    public Double getDiemTb() {
        //return (getTiengAnh() + getTinhoc() + getGiaoducTC()) /3;
        double avg = (getTiengAnh() + getTinhoc() + getGiaoducTC()) / 3.0;
         avg = Math.round(avg * 100.0) / 100.0;
         return avg;

    }    
}