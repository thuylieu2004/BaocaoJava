package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.ChiTietHoaDon_Dto;

import java.util.List;


public interface ChiTietHoaDonService {
    ChiTietHoaDon_Dto getIDChiTietHoaDon(int chitiethoadonId);
    List<ChiTietHoaDon_Dto> getallCTHoaDon();
    ChiTietHoaDon_Dto createCTHoaDon(ChiTietHoaDon_Dto cthoadonDto);
    ChiTietHoaDon_Dto updateCTHoaDon (int chitiethoadonId, ChiTietHoaDon_Dto cthoadonDto);
    void deleteCTHoaDon (int chitiethoadonId);
}
