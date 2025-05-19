package com.example.computer_shoponline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoa_don")

public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHoaDon;

    private LocalDateTime ngayLapHoaDon;
    private int maKhachHang;
    private int maNhanVien;

    @OneToMany(mappedBy = "maHoaDon")
    private List<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon(int maHoaDon, LocalDateTime ngayLapHoaDon, int maKhachHang, int maNhanVien) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
    }

}
