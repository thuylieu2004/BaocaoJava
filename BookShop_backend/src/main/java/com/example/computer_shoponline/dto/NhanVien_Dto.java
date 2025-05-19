package com.example.computer_shoponline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien_Dto {
    private int maNhanVien;
    private String tenNhanVien;
    private String diaChi;
    private int soDienThoai;
    private int maTaiKhoan;
}
