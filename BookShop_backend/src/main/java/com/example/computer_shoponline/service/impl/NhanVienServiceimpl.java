package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.KhachHangMapper;
import com.example.computer_shoponline.Mapper.NhanVienMapper;
import com.example.computer_shoponline.dto.NhanVien_Dto;
import com.example.computer_shoponline.entity.Khachhang;
import com.example.computer_shoponline.entity.NhanVien;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.NhanVienReponsitory;
import com.example.computer_shoponline.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NhanVienServiceimpl implements NhanVienService {

    private NhanVienReponsitory nhanVienReponsitory;

    @Override
    public NhanVien_Dto getNhanVienByID(int nhanvienId) {
        NhanVien nhanVien = nhanVienReponsitory.findById(nhanvienId)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + nhanvienId));
        return NhanVienMapper.maptoNhanVienDTO(nhanVien);
    }

    @Override
    public List<NhanVien_Dto> getAllNhanVien() {
        List<NhanVien> nhanvien = nhanVienReponsitory.findAll();
        return nhanvien.stream().map((nhanviens)
                        -> NhanVienMapper.maptoNhanVienDTO(nhanviens))
                .collect(Collectors.toList());
    }

    @Override
    public NhanVien_Dto createNhanVien(NhanVien_Dto nhanvienDto) {
        NhanVien nhanVien = NhanVienMapper.maptoNhanVien(nhanvienDto);
        NhanVien savenhanvien = nhanVienReponsitory.save(nhanVien);
        return  NhanVienMapper.maptoNhanVienDTO(savenhanvien);
    }

    @Override
    public NhanVien_Dto updateNhanVien(int nhanvienId, NhanVien_Dto nhanvienDto) {
        NhanVien nhanVien = nhanVienReponsitory.findById(nhanvienId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + nhanvienId));

        nhanVien.setTenNhanVien(nhanvienDto.getTenNhanVien());
        nhanVien.setDiaChi(nhanVien.getDiaChi());
        nhanVien.setSoDienThoai(nhanVien.getSoDienThoai());
        nhanVien.setMaTaiKhoan(nhanVien.getMaTaiKhoan());

        NhanVien savenhanvien = nhanVienReponsitory.save(nhanVien);

        return NhanVienMapper.maptoNhanVienDTO(savenhanvien);
    }

    @Override
    public void deleteNhanVien(int nhanvienId) {
        NhanVien nhanVien = nhanVienReponsitory.findById(nhanvienId).orElseThrow(()
                -> new ResourceNotFoundException("ComputerParts not found" + nhanvienId));
        nhanVienReponsitory.deleteById(nhanvienId);
    }
}
