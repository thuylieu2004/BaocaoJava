package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.KhachHang_Dto;
import com.example.computer_shoponline.dto.NhanVien_Dto;
import com.example.computer_shoponline.service.KhachHangService;
import com.example.computer_shoponline.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/nhanviens")
public class NhanVienController {
    private NhanVienService nhanVienService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<NhanVien_Dto> createnhanvien(@RequestBody NhanVien_Dto nhanVien_dto) {
        NhanVien_Dto save_nhanvien = nhanVienService.createNhanVien(nhanVien_dto);
        return new ResponseEntity<>(save_nhanvien, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<NhanVien_Dto> getByIdnhanvien(@PathVariable("id") int nhanvienid) {
        NhanVien_Dto nhanVien_dto = nhanVienService.getNhanVienByID(nhanvienid);
        return ResponseEntity.ok(nhanVien_dto);
    }

    @GetMapping
    public ResponseEntity<List<NhanVien_Dto>> getAllnhanvien() {
        List<NhanVien_Dto> nhanVienDtos = nhanVienService.getAllNhanVien();
        return ResponseEntity.ok(nhanVienDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<NhanVien_Dto> updatenhanvien(@PathVariable("id") int nhanvienid,
                                                         @RequestBody NhanVien_Dto nhanVien_dto) {
        NhanVien_Dto updated_nhanvien = nhanVienService.updateNhanVien(nhanvienid, nhanVien_dto);
        return ResponseEntity.ok(updated_nhanvien);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehoadon(@PathVariable("id") int nhanvienid) {
        nhanVienService.deleteNhanVien(nhanvienid);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
