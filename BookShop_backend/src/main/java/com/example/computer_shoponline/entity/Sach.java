package com.example.computer_shoponline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSach;

    private String tenSach;
    private int maTacGia;
    private int maNhaXuatBan;
    private int maTheLoai;
    private BigDecimal giaBan;
    private int soLuong;
    private String moTa;
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "maNhaXuatBan", insertable = false, updatable = false)
    private NhaXuatBan nhaXuatBan;

    @ManyToOne
    @JoinColumn(name = "maTacGia", insertable = false, updatable = false)
    private TacGia tacGia;

    @ManyToOne
    @JoinColumn(name = "maTheLoai", insertable = false, updatable = false)
    private Theloai theloai;

    @OneToMany(mappedBy = "maSach")
    private List<ChiTietHoaDon> chiTietHoaDons;



    public Sach(int maSach, String tenSach, int maTacGia, int maNhaXuatBan, int maTheLoai, BigDecimal giaBan, int soLuong, String moTa, String hinhAnh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maTacGia = maTacGia;
        this.maNhaXuatBan = maNhaXuatBan;
        this.maTheLoai = maTheLoai;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.hinhAnh = hinhAnh;
    }
}
