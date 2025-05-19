package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.NhaXuatBan_Dto;

import java.util.List;

public interface NhaXuatBanService {

    NhaXuatBan_Dto createNhaXuatBan(NhaXuatBan_Dto nhaXuatBan_dto);

    NhaXuatBan_Dto getIDNhaXuatBan(int supplierId);

    List<NhaXuatBan_Dto> getAllNhaXuatBan();

    NhaXuatBan_Dto updateNhaXuatBan(int supplierId, NhaXuatBan_Dto nhaXuatBan_dto);

    void deleteNhaXuatBan(int supplierId);
}
