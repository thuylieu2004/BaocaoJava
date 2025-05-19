package com.example.computer_shoponline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan_Dto {

    private int maTaiKhoan;
    private String tenTaiKhoan;
    private String matKhau;
    private String tenNguoiDung;
    private String phanQuyen;
    private String email;

}
