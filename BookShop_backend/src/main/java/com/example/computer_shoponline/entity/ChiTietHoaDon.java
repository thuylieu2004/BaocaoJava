package com.example.computer_shoponline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chi_tiet_hoa_don")

public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maChitietHoaDon;

    private int maHoaDon;
    private int maSach;
    private int soLuong;
    private BigDecimal thanhTien;

    @ManyToOne
    @JoinColumn(name = "maHoaDon", insertable = false, updatable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "maSach", insertable = false, updatable = false)
    private Sach sach;

    public ChiTietHoaDon(int  maChitietHoaDon, int  maHoaDon, int maSach, int soLuong, BigDecimal thanhTien ) {
        this.maChitietHoaDon = maChitietHoaDon;
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }
}
