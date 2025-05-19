package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.TacGia_Dto;

import java.util.List;

public interface TacGiaService {
    TacGia_Dto getTacGia(int id);
    List<TacGia_Dto> getAllTacGia();
    TacGia_Dto createTacGia(TacGia_Dto brand);
    TacGia_Dto updateTacGia(int brandId, TacGia_Dto brand);
    void deleteTacGia(int brandId);
}
