package com.example.computer_shoponline.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon_Dto {

    private int maHoaDon;
    private LocalDateTime ngayLapHoaDon;
    private int maKhachHang;
    private int maNhanVien;

}
