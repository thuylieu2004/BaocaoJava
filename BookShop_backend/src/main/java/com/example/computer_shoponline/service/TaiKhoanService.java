package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.TaiKhoan_Dto;

import java.util.List;

public interface TaiKhoanService {
    TaiKhoan_Dto getTaiKhoanByID(int taiKhoanId);
    List<TaiKhoan_Dto> getAllTaiKhoan();
    TaiKhoan_Dto createTaiKhoan(TaiKhoan_Dto taiKhoan);
    TaiKhoan_Dto updateTaiKhoan(int taiKhoanId, TaiKhoan_Dto taiKhoan);
    void deleteTaiKhoan(int taiKhoanId);
}
