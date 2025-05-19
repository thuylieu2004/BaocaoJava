package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.KhachHang_Dto;

import java.util.List;

public interface KhachHangService {
    KhachHang_Dto getKhachHangByID(int khachHangId);
    List<KhachHang_Dto> getAllKhachHang();
    KhachHang_Dto createKhachHang(KhachHang_Dto khachHangDto);
    KhachHang_Dto updateKhachHang(int khachHangId, KhachHang_Dto khachHangDto);
    void deleteKhachHang(int khachHangId);
}
