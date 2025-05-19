package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.Sach_Dto;
import com.example.computer_shoponline.entity.Sach;

public class SachMapper {

    public static Sach_Dto maptoSach_Dto(Sach sach) {
        return new Sach_Dto(
                sach.getMaSach(),
                sach.getTenSach(),
                sach.getMaTacGia(),
                sach.getMaNhaXuatBan(),
                sach.getMaTheLoai(),
                sach.getGiaBan(),
                sach.getSoLuong(),
                sach.getMoTa(),
                sach.getHinhAnh()
        );
    }

    public static Sach maptoSach(Sach_Dto sach_Dto) {
        return new Sach(
                sach_Dto.getMaSach(),
                sach_Dto.getTenSach(),
                sach_Dto.getMaTacGia(),
                sach_Dto.getMaNhaXuatBan(),
                sach_Dto.getMaTheLoai(),
                sach_Dto.getGiaBan(),
                sach_Dto.getSoLuong(),
                sach_Dto.getMoTa(),
                sach_Dto.getHinhAnh()
        );

    }
}
