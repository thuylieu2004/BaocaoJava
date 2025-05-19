package com.example.computer_shoponline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Sach_Dto {

    private int maSach;
    private String tenSach;
    private int maTacGia;
    private int maNhaXuatBan;
    private int maTheLoai;
    private BigDecimal giaBan;
    private int soLuong;
    private String moTa;
    private String hinhAnh;

}
