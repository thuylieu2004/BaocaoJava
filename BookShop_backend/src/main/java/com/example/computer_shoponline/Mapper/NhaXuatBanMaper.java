package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.NhaXuatBan_Dto;
import com.example.computer_shoponline.entity.NhaXuatBan;

public class NhaXuatBanMaper {

    public static NhaXuatBan_Dto maptoNhaXuatBanDto(NhaXuatBan nhaXuatBan) {
        return new NhaXuatBan_Dto(
                nhaXuatBan.getMaNhaXuatBan(),
                nhaXuatBan.getTenNhaXuatBan(),
                nhaXuatBan.getDiaChi(),
                nhaXuatBan.getEmail()
        );
    }

    public static NhaXuatBan maptoNhaXuatBan(NhaXuatBan_Dto nhaXuatBan_dto) {
        return new NhaXuatBan(
                nhaXuatBan_dto.getMaNhaXuatBan(),
                nhaXuatBan_dto.getTenNhaXuatBan(),
                nhaXuatBan_dto.getDiaChi(),
                nhaXuatBan_dto.getEmail()
        );
    }
}
