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
public class ChiTietHoaDon_Dto {

    private int maChitietHoaDon;
    private int maHoaDon;
    private int maSach;
    private int soLuong;
    private BigDecimal thanhTien;

}
