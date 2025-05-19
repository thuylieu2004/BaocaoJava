package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.HoaDon_Dto;
import com.example.computer_shoponline.dto.NhaXuatBan_Dto;
import com.example.computer_shoponline.service.HoaDonService;
import com.example.computer_shoponline.service.NhaXuatBanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hoadons")
public class HoaDonController {
    private HoaDonService hoaDonService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<HoaDon_Dto> createHoaDon(@RequestBody HoaDon_Dto hoaDonDto) {
        HoaDon_Dto save_Hoadon = hoaDonService.createHoaDon(hoaDonDto);
        return new ResponseEntity<>(save_Hoadon, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<HoaDon_Dto> getByIdhoadon(@PathVariable("id") int hoadonid) {
        HoaDon_Dto hoaDonDto = hoaDonService.getIDHoaDon(hoadonid);
        return ResponseEntity.ok(hoaDonDto);
    }

    @GetMapping
    public ResponseEntity<List<HoaDon_Dto>> getAllhoadon() {
        List<HoaDon_Dto> hoaDonDtos = hoaDonService.getallHoaDon();
        return ResponseEntity.ok(hoaDonDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<HoaDon_Dto> updateHoadon(@PathVariable("id") int hoadonid,
                                                         @RequestBody HoaDon_Dto hoaDonDto) {
        HoaDon_Dto updated_hoadon = hoaDonService.updateHoaDon(hoadonid, hoaDonDto);
        return ResponseEntity.ok(updated_hoadon);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehoadon(@PathVariable("id") int hoadonid) {
        hoaDonService.deleteHoaDon(hoadonid);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
