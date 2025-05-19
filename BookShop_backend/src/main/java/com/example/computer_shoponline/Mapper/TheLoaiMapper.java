package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.TheLoai_Dto;
import com.example.computer_shoponline.entity.Theloai;

public class TheLoaiMapper {

    public static TheLoai_Dto maptoCategoryDto(Theloai theloai) {
        return new TheLoai_Dto(
                theloai.getMaTheLoai(),
                theloai.getTenTheLoai(),
                theloai.getMoTa()
        );
    }

    public static Theloai maptoCaterogy(TheLoai_Dto theLoai_dto) {
        return new Theloai(
                theLoai_dto.getMaTheLoai(),
                theLoai_dto.getTenTheLoai(),
                theLoai_dto.getMoTa()
        );
    }
}
