package com.example.computer_shoponline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTaiKhoan;

    private String tenTaiKhoan;
    private String matKhau;
    private String tenNguoiDung;
    private String phanQuyen;
    private String email;

    @OneToMany(mappedBy = "maKhachHang")
    private List<Khachhang> customers;

    @OneToMany(mappedBy = "maNhanVien")
    private List<NhanVien> employees;

    public TaiKhoan(int maTaiKhoan, String tenTaiKhoan, String matKhau, String tenNguoiDung, String phanQuyen, String email) {
        this.maTaiKhoan = maTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.tenNguoiDung = tenNguoiDung;
        this.phanQuyen = phanQuyen;
        this.email = email;
    }

}
