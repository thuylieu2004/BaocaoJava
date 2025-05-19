package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.entity.HoaDon;
import com.example.computer_shoponline.entity.Khachhang;

public class KhachHangMapper {
    public static KhachHang_Dto maptoKhachHangDTO(Khachhang khachhang) {
        return new KhachHang_Dto(
                khachhang.getMaKhachHang(),
                khachhang.getTenKhachHang(),
                khachhang.getDiaChi(),
                khachhang.getSoDienThoai(),
                khachhang.getMaKhachHang()
        );
    }

    public static Khachhang maptoKhachHang(KhachHang_Dto khachHangDto) {
        return new Khachhang(
                khachHangDto.getMaKhachHang(),
                khachHangDto.getTenKhachHang(),
                khachHangDto.getDiaChi(),
                khachHangDto.getSoDienThoai(),
                khachHangDto.getMaKhachHang()
        );
    }
}
