package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.ChiTietHoaDonMapper;
import com.example.computer_shoponline.Mapper.HoaDonMapper;
import com.example.computer_shoponline.dto.ChiTietHoaDon_Dto;
import com.example.computer_shoponline.entity.ChiTietHoaDon;
import com.example.computer_shoponline.entity.HoaDon;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.ChiTietHoaDonReponsitory;
import com.example.computer_shoponline.service.ChiTietHoaDonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChiTietHoaDonserviceimpl  implements ChiTietHoaDonService {
    private ChiTietHoaDonReponsitory CThoaDonReponsitory;

    @Override
    public ChiTietHoaDon_Dto getIDChiTietHoaDon(int chitiethoadonId) {
        ChiTietHoaDon chiTietHoaDon = CThoaDonReponsitory.findById(chitiethoadonId)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + chitiethoadonId));
        return ChiTietHoaDonMapper.maptoCTHoaDonDTO(chiTietHoaDon);
    }

    @Override
    public List<ChiTietHoaDon_Dto> getallCTHoaDon() {
        List<ChiTietHoaDon> chiTietHoaDons = CThoaDonReponsitory.findAll();
        return chiTietHoaDons.stream().map((chiTietHoaDon)
                        -> ChiTietHoaDonMapper.maptoCTHoaDonDTO(chiTietHoaDon))
                .collect(Collectors.toList());
    }

    @Override
    public ChiTietHoaDon_Dto createCTHoaDon(ChiTietHoaDon_Dto cthoadonDto) {
        ChiTietHoaDon chiTietHoaDon = ChiTietHoaDonMapper.maptoCTHoaDon(cthoadonDto);
        ChiTietHoaDon savecthoadon = CThoaDonReponsitory.save(chiTietHoaDon);
        return  ChiTietHoaDonMapper.maptoCTHoaDonDTO(savecthoadon);
    }

    @Override
    public ChiTietHoaDon_Dto updateCTHoaDon(int chitiethoadonId, ChiTietHoaDon_Dto cthoadonDto) {
        ChiTietHoaDon cthoaDon = CThoaDonReponsitory.findById(chitiethoadonId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + chitiethoadonId));

        cthoaDon.setMaHoaDon(cthoadonDto.getMaHoaDon());
        cthoaDon.setMaSach(cthoadonDto.getMaSach());
        cthoaDon.setSoLuong(cthoadonDto.getSoLuong());
        cthoaDon.setThanhTien(cthoadonDto.getThanhTien());

        ChiTietHoaDon savecthoadon = CThoaDonReponsitory.save(cthoaDon);

        return ChiTietHoaDonMapper.maptoCTHoaDonDTO(savecthoadon);
    }

    @Override
    public void deleteCTHoaDon(int chitiethoadonId) {
        ChiTietHoaDon chiTietHoaDon = CThoaDonReponsitory.findById(chitiethoadonId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + chitiethoadonId));
        CThoaDonReponsitory.deleteById(chitiethoadonId);
    }
}
