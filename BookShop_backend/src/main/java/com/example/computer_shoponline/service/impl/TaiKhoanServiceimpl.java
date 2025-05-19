package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.HoaDonMapper;
import com.example.computer_shoponline.Mapper.KhachHangMapper;
import com.example.computer_shoponline.Mapper.TacGiaMapper;
import com.example.computer_shoponline.Mapper.TaiKhoanMapper;
import com.example.computer_shoponline.dto.TaiKhoan_Dto;
import com.example.computer_shoponline.entity.*;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.TaiKhoanReponsitory;
import com.example.computer_shoponline.service.TaiKhoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaiKhoanServiceimpl implements TaiKhoanService {

    private TaiKhoanReponsitory taiKhoanReponsitory;

    @Override
    public TaiKhoan_Dto getTaiKhoanByID(int taiKhoanId) {
        TaiKhoan taiKhoan = taiKhoanReponsitory.findById(taiKhoanId)
                .orElseThrow(() -> new ResourceNotFoundException("ComputerParts not found" + taiKhoanId));
        return TaiKhoanMapper.maptoTaiKHoanDTO(taiKhoan);
    }

    @Override
    public List<TaiKhoan_Dto> getAllTaiKhoan() {
        List<TaiKhoan> taiKhoan = taiKhoanReponsitory.findAll();
        return taiKhoan.stream().map((taikhoans)
                        -> TaiKhoanMapper.maptoTaiKHoanDTO(taikhoans))
                .collect(Collectors.toList());
    }

    @Override
    public TaiKhoan_Dto createTaiKhoan(TaiKhoan_Dto taiKhoandto) {
        TaiKhoan taikhoan = TaiKhoanMapper.maptoTaikhoan(taiKhoandto);
        TaiKhoan save_taikhoan = taiKhoanReponsitory.save(taikhoan);
        return  TaiKhoanMapper.maptoTaiKHoanDTO(save_taikhoan);
    }

    @Override
    public TaiKhoan_Dto updateTaiKhoan(int taiKhoanId, TaiKhoan_Dto taiKhoandto) {
        TaiKhoan taikhoan = taiKhoanReponsitory.findById(taiKhoanId).orElseThrow(()
                -> new ResourceNotFoundException("Brand not found" + taiKhoanId));
        taikhoan.setTenTaiKhoan(taiKhoandto.getTenTaiKhoan());
        taikhoan.setMatKhau(taiKhoandto.getMatKhau());
        taikhoan.setTenNguoiDung(taiKhoandto.getTenNguoiDung());
        taikhoan.setPhanQuyen(taiKhoandto.getPhanQuyen());
        taikhoan.setEmail(taiKhoandto.getEmail());

        TaiKhoan saveTaiKhoan = taiKhoanReponsitory.save(taikhoan);

        return TaiKhoanMapper.maptoTaiKHoanDTO(saveTaiKhoan);
    }

    @Override
    public void deleteTaiKhoan(int taiKhoanId) {
        TaiKhoan taikhoan = taiKhoanReponsitory.findById(taiKhoanId).orElseThrow(()
                -> new ResourceNotFoundException("Category not found" + taiKhoanId));
        taiKhoanReponsitory.deleteById(taiKhoanId);
    }
}
