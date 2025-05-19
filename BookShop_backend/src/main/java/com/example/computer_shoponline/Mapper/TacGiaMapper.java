package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.TacGia_Dto;
import com.example.computer_shoponline.entity.TacGia;

public class TacGiaMapper {
    public static TacGia_Dto maptoTacGia_Dto(TacGia brand) {
        return new TacGia_Dto(
                brand.getMaTacGia(),
                brand.getTenTacGia(),
                brand.getTieuSu()
        );
    }

    public static TacGia maptoTacGia(TacGia_Dto tacGia_Dto) {
        return new TacGia(
                tacGia_Dto.getMaTacGia(),
                tacGia_Dto.getTenTacGia(),
                tacGia_Dto.getTieuSu()
        );
    }
}
