package com.example.computer_shoponline.Mapper;

import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.dto.NhanVien_Dto;
import com.example.computer_shoponline.entity.HoaDon;
import com.example.computer_shoponline.entity.Khachhang;
import com.example.computer_shoponline.entity.NhaXuatBan;


public class HoaDonMapper {
   public static HoaDon_Dto maptoHoaDonDTO(HoaDon hoaDon) {
       return new HoaDon_Dto(
               hoaDon.getMaHoaDon(),
               hoaDon.getNgayLapHoaDon(),
               hoaDon.getMaKhachHang(),
               hoaDon.getMaNhanVien()
       );
   }

   public static HoaDon maptoHoaDon(HoaDon_Dto hoaDonDto) {
       return new HoaDon(
               hoaDonDto.getMaHoaDon(),
               hoaDonDto.getNgayLapHoaDon(),
               hoaDonDto.getMaKhachHang(),
               hoaDonDto.getMaNhanVien()
       );
   }
}
