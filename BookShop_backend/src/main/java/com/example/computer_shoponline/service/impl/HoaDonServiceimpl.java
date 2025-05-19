package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.HoaDonMapper;
import com.example.computer_shoponline.Mapper.SachMapper;
import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.dto.Sach_Dto;
import com.example.computer_shoponline.entity.HoaDon;
import com.example.computer_shoponline.entity.Sach;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.HoaDonReponsitory;
import com.example.computer_shoponline.reponsitory.SachReponsitory;
import com.example.computer_shoponline.service.HoaDonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HoaDonServiceimpl implements HoaDonService {

    private HoaDonReponsitory hoaDonReponsitory;
    @Override
    public HoaDon_Dto getIDHoaDon(int hoadonID) {
        HoaDon hoaDon = hoaDonReponsitory.findById(hoadonID)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + hoadonID));
        return HoaDonMapper.maptoHoaDonDTO(hoaDon);
    }

    @Override
    public List<HoaDon_Dto> getallHoaDon() {
        List<HoaDon> hoadon = hoaDonReponsitory.findAll();
        return hoadon.stream().map((hoaDon)
                        -> HoaDonMapper.maptoHoaDonDTO(hoaDon))
                .collect(Collectors.toList());
    }

    @Override
    public HoaDon_Dto createHoaDon(HoaDon_Dto hoaDon_Dto) {
        HoaDon hoaDon = HoaDonMapper.maptoHoaDon(hoaDon_Dto);
        HoaDon savehoadon = hoaDonReponsitory.save(hoaDon);
        return  HoaDonMapper.maptoHoaDonDTO(savehoadon);
    }

    @Override
    public HoaDon_Dto updateHoaDon(int hoaDonID, HoaDon_Dto hoaDonDto) {
        HoaDon hoaDon = hoaDonReponsitory.findById(hoaDonID).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + hoaDonDto));
        hoaDon.setNgayLapHoaDon(hoaDonDto.getNgayLapHoaDon());
        hoaDon.setMaNhanVien(hoaDonDto.getMaNhanVien());
        hoaDon.setMaKhachHang(hoaDonDto.getMaKhachHang());

        HoaDon savehoadon = hoaDonReponsitory.save(hoaDon);

        return HoaDonMapper.maptoHoaDonDTO(savehoadon);
    }

    @Override
    public void deleteHoaDon(int hoadonID) {
        HoaDon hoaDon = hoaDonReponsitory.findById(hoadonID).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + hoadonID));
        hoaDonReponsitory.deleteById(hoadonID);
    }



}
