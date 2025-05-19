package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.service.HoaDonService;
import com.example.computer_shoponline.service.KhachHangService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/khachhangs")
public class KhachHangController {
    private KhachHangService khachHangService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<KhachHang_Dto> createkhachang(@RequestBody KhachHang_Dto khachHangDto) {
        KhachHang_Dto save_khachhang = khachHangService.createKhachHang(khachHangDto);
        return new ResponseEntity<>(save_khachhang, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<KhachHang_Dto> getByIdkhachhang(@PathVariable("id") int khachHangId) {
        KhachHang_Dto hoaDonDto = khachHangService.getKhachHangByID(khachHangId);
        return ResponseEntity.ok(hoaDonDto);
    }

    @GetMapping
    public ResponseEntity<List<KhachHang_Dto>> getAllkhachhang() {
        List<KhachHang_Dto> khachHangDtos = khachHangService.getAllKhachHang();
        return ResponseEntity.ok(khachHangDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<KhachHang_Dto> updatekhachhang(@PathVariable("id") int khachangid,
                                                   @RequestBody KhachHang_Dto khachHangDto) {
        KhachHang_Dto updated_khachhang = khachHangService.updateKhachHang(khachangid, khachHangDto);
        return ResponseEntity.ok(updated_khachhang);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehoadon(@PathVariable("id") int khachHangId) {
        khachHangService.deleteKhachHang(khachHangId);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
