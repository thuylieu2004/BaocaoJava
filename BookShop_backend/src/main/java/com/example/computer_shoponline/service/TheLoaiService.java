package com.example.computer_shoponline.service;

import com.example.computer_shoponline.dto.TheLoai_Dto;

import java.util.List;

public interface TheLoaiService {
   TheLoai_Dto getTheLoai(int categoryId);

   TheLoai_Dto createTheLoai(TheLoai_Dto category);

   TheLoai_Dto updateTheLoai(int categoryId, TheLoai_Dto category);

   void deleteTheLoai(int categoryId);

   List<TheLoai_Dto> getAllTheLoai();

}
