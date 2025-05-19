package com.example.computer_shoponline.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khach_hang")
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maKhachHang;

    private String tenKhachHang;
    private String diaChi;
    private int soDienThoai;
    private int maTaiKhoan;

    @ManyToOne
    @JoinColumn(name = "maTaiKhoan", insertable = false, updatable = false)
    private TaiKhoan taiKhoan;

    public Khachhang (int maKhachHang, String tenKhachHang,String diaChi, int soDienThoai,int maTaiKhoan) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maTaiKhoan = maTaiKhoan;
    }
}
