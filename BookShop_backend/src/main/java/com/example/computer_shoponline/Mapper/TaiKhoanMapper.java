package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.TaiKhoan_Dto;
import com.example.computer_shoponline.entity.TaiKhoan;

public class TaiKhoanMapper {
    public static TaiKhoan_Dto maptoTaiKHoanDTO(TaiKhoan taiKhoan) {
        return new TaiKhoan_Dto(
                taiKhoan.getMaTaiKhoan(),
                taiKhoan.getTenTaiKhoan(),
                taiKhoan.getMatKhau(),
                taiKhoan.getTenNguoiDung(),
                taiKhoan.getPhanQuyen(),
                taiKhoan.getEmail()
        );
    }

    public static TaiKhoan maptoTaikhoan(TaiKhoan_Dto taiKhoanDto) {
        return new TaiKhoan(
                taiKhoanDto.getMaTaiKhoan(),
                taiKhoanDto.getTenTaiKhoan(),
                taiKhoanDto.getMatKhau(),
                taiKhoanDto.getTenNguoiDung(),
                taiKhoanDto.getPhanQuyen(),
                taiKhoanDto.getEmail()
        );
    }
}
