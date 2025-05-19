package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.TheLoaiMapper;
import com.example.computer_shoponline.dto.TheLoai_Dto;
import com.example.computer_shoponline.entity.Theloai;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.TheLoaiReponsitory;
import com.example.computer_shoponline.service.TheLoaiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TheLoaiServiceimpl implements TheLoaiService {

    private TheLoaiReponsitory theLoaiReponsitory;




    @Override
    public TheLoai_Dto getTheLoai(int categoryId) {
        Theloai theloai = theLoaiReponsitory.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found" + categoryId));
        return TheLoaiMapper.maptoCategoryDto(theloai);
    }

    @Override
    public TheLoai_Dto createTheLoai(TheLoai_Dto theLoai_dto) {
        Theloai theloai = TheLoaiMapper.maptoCaterogy(theLoai_dto);
        Theloai savecategory = theLoaiReponsitory.save(theloai);
        return  TheLoaiMapper.maptoCategoryDto(savecategory);
    }

    @Override
    public TheLoai_Dto updateTheLoai(int categoryId, TheLoai_Dto category) {
        Theloai theloai = theLoaiReponsitory.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category not found" + categoryId));
        theloai.setTenTheLoai(category.getTenTheLoai());
        theloai.setMoTa(category.getMoTa());

        Theloai savedcategory = theLoaiReponsitory.save(theloai);

        return TheLoaiMapper.maptoCategoryDto(savedcategory);
    }

    @Override
    public void deleteTheLoai(int categoryId) {
        Theloai theloai = theLoaiReponsitory.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category not found" + categoryId));
        theLoaiReponsitory.deleteById(categoryId);
    }

    @Override
    public List<TheLoai_Dto> getAllTheLoai() {
        List<Theloai> caterogies = theLoaiReponsitory.findAll();
        return caterogies.stream().map((caterogy) -> TheLoaiMapper.maptoCategoryDto(caterogy))
                .collect(Collectors.toList());
    }
}
