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
@Table(name = "nha_xuat_ban")
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maNhaXuatBan;

    private String tenNhaXuatBan;
    private String diaChi;
    private String email;

    @OneToMany(mappedBy = "maNhaXuatBan")
    private List<Sach> saches;

    public NhaXuatBan(int maNhaXuatBan, String tenNhaXuatBan, String diaChi, String email) {
        this.maNhaXuatBan = maNhaXuatBan;
        this.tenNhaXuatBan = tenNhaXuatBan;
        this.diaChi = diaChi;
        this.email = email;
    }
}
