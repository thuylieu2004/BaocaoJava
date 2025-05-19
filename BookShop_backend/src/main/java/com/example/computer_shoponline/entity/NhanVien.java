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
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhanVien;

    private String tenNhanVien;
    private String diaChi;
    private int soDienThoai;
    private int maTaiKhoan;

    @ManyToOne
    @JoinColumn(name = "maTaiKhoan", insertable = false, updatable = false)
    private TaiKhoan taiKhoan;


    public NhanVien(int maNhanVien, String tenNhanVien,String diaChi, int soDienThoai, int maTaiKhoan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.maTaiKhoan = maTaiKhoan;
    }
}
