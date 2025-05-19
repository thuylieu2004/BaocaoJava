package com.example.computer_shoponline.controller;


import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.dto.TaiKhoan_Dto;
import com.example.computer_shoponline.service.KhachHangService;
import com.example.computer_shoponline.service.TaiKhoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/taikhoans")
public class TaiKhoan {
    private TaiKhoanService taiKhoanService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<TaiKhoan_Dto> createtaikhoan(@RequestBody TaiKhoan_Dto taiKhoanDto) {
        TaiKhoan_Dto save_taikhoan = taiKhoanService.createTaiKhoan(taiKhoanDto);
        return new ResponseEntity<>(save_taikhoan, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<TaiKhoan_Dto> getByIdtaikhoan(@PathVariable("id") int taikhoanid) {
        TaiKhoan_Dto hoaDonDto = taiKhoanService.getTaiKhoanByID(taikhoanid);
        return ResponseEntity.ok(hoaDonDto);
    }

    @GetMapping
    public ResponseEntity<List<TaiKhoan_Dto>> getAlltaikhoan() {
        List<TaiKhoan_Dto> taiKhoanDtos = taiKhoanService.getAllTaiKhoan();
        return ResponseEntity.ok(taiKhoanDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<TaiKhoan_Dto> updatetaikhoan(@PathVariable("id") int taikhoanid,
                                                         @RequestBody TaiKhoan_Dto taiKhoanDto) {
        TaiKhoan_Dto updated_taikhoan = taiKhoanService.updateTaiKhoan(taikhoanid, taiKhoanDto);
        return ResponseEntity.ok(updated_taikhoan);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletetaikhoan(@PathVariable("id") int taikhoanid) {
        taiKhoanService.deleteTaiKhoan(taikhoanid);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
