package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.HoaDon_Dto;

import java.util.List;

public interface HoaDonService {
    HoaDon_Dto getIDHoaDon(int supplierId);
    List<HoaDon_Dto> getallHoaDon();
    HoaDon_Dto createHoaDon(HoaDon_Dto hoaDon_Dto);
    HoaDon_Dto updateHoaDon(int hoadonId,HoaDon_Dto hoaDon_Dto);
    void deleteHoaDon(int hoadonId);
}
