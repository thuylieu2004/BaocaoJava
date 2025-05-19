package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.dto.NhanVien_Dto;
import com.example.computer_shoponline.entity.Khachhang;
import com.example.computer_shoponline.entity.NhanVien;

public class NhanVienMapper {
    public static NhanVien_Dto maptoNhanVienDTO(NhanVien nhanVien) {
        return new NhanVien_Dto(
                nhanVien.getMaNhanVien(),
                nhanVien.getTenNhanVien(),
                nhanVien.getDiaChi(),
                nhanVien.getSoDienThoai(),
                nhanVien.getMaTaiKhoan()
        );
    }

    public static NhanVien maptoNhanVien(NhanVien_Dto nhanVienDto) {
        return new NhanVien(
                nhanVienDto.getMaNhanVien(),
                nhanVienDto.getTenNhanVien(),
                nhanVienDto.getDiaChi(),
                nhanVienDto.getSoDienThoai(),
                nhanVienDto.getMaTaiKhoan()
        );
    }
}
