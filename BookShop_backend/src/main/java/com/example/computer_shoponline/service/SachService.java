package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.Sach_Dto;

import java.util.List;

public interface SachService {
    Sach_Dto createSach(Sach_Dto sach_dto);
    List<Sach_Dto> getAllSach();
    Sach_Dto updateSach(int computerpartsID, Sach_Dto sach_dto);
    void deleteSach(int computerPartsId);
    Sach_Dto getByIDSach(int computerPartsId);
}
