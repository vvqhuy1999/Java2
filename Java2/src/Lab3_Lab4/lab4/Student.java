package lab4;

public class Student {
    String maSV;
    String hoten;
    String email;
    String SDT;
    String diachi;
    Boolean gioitinh;

    public Student() {
    }

    public Student(String maSV, String hoten, String email, String SDT, Boolean gioitinh,String diachi ) {
        this.maSV = maSV;
        this.hoten = hoten;
        this.email = email;
        this.SDT = SDT;
        this.gioitinh = gioitinh;
        this.diachi = diachi;

    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
}
