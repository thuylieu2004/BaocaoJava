package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.NhanVien_Dto;

import java.util.List;

public interface NhanVienService {
    NhanVien_Dto getNhanVienByID(int nhanvienId);
    List<NhanVien_Dto> getAllNhanVien();
    NhanVien_Dto createNhanVien(NhanVien_Dto nhanvienDto);
    NhanVien_Dto updateNhanVien(int nhanvienId, NhanVien_Dto nhanvienDto);
    void deleteNhanVien(int nhanvienId);
}
