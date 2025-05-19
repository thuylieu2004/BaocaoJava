package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.HoaDonMapper;
import com.example.computer_shoponline.Mapper.KhachHangMapper;
import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.entity.HoaDon;
import com.example.computer_shoponline.entity.Khachhang;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.KhachHangReponsitory;
import com.example.computer_shoponline.service.KhachHangService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KhachHangServiceimpl implements KhachHangService {

    private KhachHangReponsitory khachHangReponsitory;
    @Override
    public KhachHang_Dto getKhachHangByID(int khachHangId) {
        Khachhang khachhang = khachHangReponsitory.findById(khachHangId)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + khachHangId));
        return KhachHangMapper.maptoKhachHangDTO(khachhang);
    }

    @Override
    public List<KhachHang_Dto> getAllKhachHang() {
        List<Khachhang> khachhang = khachHangReponsitory.findAll();
        return khachhang.stream().map((khachhangs)
                        -> KhachHangMapper.maptoKhachHangDTO(khachhangs))
                .collect(Collectors.toList());
    }

    @Override
    public KhachHang_Dto createKhachHang(KhachHang_Dto khachHangDto) {
        Khachhang khachhang = KhachHangMapper.maptoKhachHang(khachHangDto);
        Khachhang savekhachhang = khachHangReponsitory.save(khachhang);
        return  KhachHangMapper.maptoKhachHangDTO(savekhachhang);
    }

    @Override
    public KhachHang_Dto updateKhachHang(int khachHangId, KhachHang_Dto khachHangDto) {
        Khachhang khachHang = khachHangReponsitory.findById(khachHangId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + khachHangId));

        khachHang.setTenKhachHang(khachHangDto.getTenKhachHang());
        khachHang.setDiaChi(khachHang.getDiaChi());
        khachHang.setSoDienThoai(khachHangDto.getSoDienThoai());
        khachHang.setMaTaiKhoan(khachHangDto.getMaTaiKhoan());

        Khachhang savekhachhang = khachHangReponsitory.save(khachHang);

        return KhachHangMapper.maptoKhachHangDTO(savekhachhang);
    }

    @Override
    public void deleteKhachHang(int khachHangId) {
        Khachhang khachhang = khachHangReponsitory.findById(khachHangId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + khachHangId));
        khachHangReponsitory.deleteById(khachHangId);
    }
}
