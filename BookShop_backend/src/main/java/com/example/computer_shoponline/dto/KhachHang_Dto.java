package com.example.computer_shoponline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang_Dto {

    private int maKhachHang;
    private String tenKhachHang;
    private String diaChi;
    private int soDienThoai;
    private int maTaiKhoan;

}
