package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.ChiTietHoaDon_Dto;
import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.entity.ChiTietHoaDon;
import com.example.computer_shoponline.entity.HoaDon;

public class ChiTietHoaDonMapper {
    public static ChiTietHoaDon_Dto maptoCTHoaDonDTO(ChiTietHoaDon chiTietHoaDon) {
        return new ChiTietHoaDon_Dto(
                chiTietHoaDon.getMaChitietHoaDon(),
                chiTietHoaDon.getMaHoaDon(),
                chiTietHoaDon.getMaSach(),
                chiTietHoaDon.getSoLuong(),
                chiTietHoaDon.getThanhTien()
        );
    }

    public static ChiTietHoaDon maptoCTHoaDon(ChiTietHoaDon_Dto chiTietHoaDonDto) {
        return new ChiTietHoaDon(
                chiTietHoaDonDto.getMaChitietHoaDon(),
                chiTietHoaDonDto.getMaHoaDon(),
                chiTietHoaDonDto.getMaSach(),
                chiTietHoaDonDto.getSoLuong(),
                chiTietHoaDonDto.getThanhTien()
        );
    }
}
