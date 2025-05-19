package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.SachMapper;
import com.example.computer_shoponline.dto.Sach_Dto;
import com.example.computer_shoponline.entity.Sach;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.SachReponsitory;
import com.example.computer_shoponline.service.SachService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SachServiceimpl implements SachService {

    private SachReponsitory sachReponsitory;



    @Override
    public Sach_Dto createSach(Sach_Dto sach_dto) {
        Sach sach = SachMapper.maptoSach(sach_dto);
        Sach savesachs = sachReponsitory.save(sach);
        return  SachMapper.maptoSach_Dto(savesachs);
    }

    @Override
    public List<Sach_Dto> getAllSach() {
        List<Sach> sach = sachReponsitory.findAll();
        return sach.stream().map((sachs)
                 -> SachMapper.maptoSach_Dto(sachs))
                .collect(Collectors.toList());
    }

    @Override
    public Sach_Dto updateSach(int sachId, Sach_Dto sach_dto) {
        Sach sach = sachReponsitory.findById(sachId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + sachId));
        sach.setTenSach(sach_dto.getTenSach());
        sach.setMaTacGia(sach_dto.getMaTacGia());
        sach.setMaNhaXuatBan(sach_dto.getMaNhaXuatBan());
        sach.setMaTheLoai(sach_dto.getMaTheLoai());
        sach.setGiaBan(sach_dto.getGiaBan());
        sach.setSoLuong(sach_dto.getSoLuong());
        sach.setMoTa(sach_dto.getMoTa());
        sach.setHinhAnh(sach_dto.getHinhAnh());

        Sach saveSach = sachReponsitory.save(sach);

        return SachMapper.maptoSach_Dto(saveSach);
    }

    @Override
    public void deleteSach(int sachId) {
        Sach sach = sachReponsitory.findById(sachId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + sachId));
        sachReponsitory.deleteById(sachId);
    }

    @Override
    public Sach_Dto getByIDSach(int sachId) {
        Sach sach = sachReponsitory.findById(sachId)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + sachId));
        return SachMapper.maptoSach_Dto(sach);
    }
}
