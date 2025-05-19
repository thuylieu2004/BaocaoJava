package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.ChiTietHoaDon_Dto;
import com.example.computer_shoponline.service.ChiTietHoaDonService;
import com.example.computer_shoponline.service.HoaDonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/chitiethoadons")
public class ChiTietHoaDonController {
    private final HoaDonService hoaDonService;
    private ChiTietHoaDonService chiTietHoaDonService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<ChiTietHoaDon_Dto> createHoaDon(@RequestBody ChiTietHoaDon_Dto chiTietHoaDonDto) {
        ChiTietHoaDon_Dto save_ctHoadon = chiTietHoaDonService.createCTHoaDon(chiTietHoaDonDto);
        return new ResponseEntity<>(save_ctHoadon, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<ChiTietHoaDon_Dto> getByIdchitiethoadon(@PathVariable("id") int chiTietHoadonId) {
        ChiTietHoaDon_Dto chitiethoaDonDto = chiTietHoaDonService.getIDChiTietHoaDon(chiTietHoadonId);
        return ResponseEntity.ok(chitiethoaDonDto);
    }

    @GetMapping
    public ResponseEntity<List<ChiTietHoaDon_Dto>> getAllhoadon() {
        List<ChiTietHoaDon_Dto> cthoaDonDtos = chiTietHoaDonService.getallCTHoaDon();
        return ResponseEntity.ok(cthoaDonDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<ChiTietHoaDon_Dto> updateHoadon(@PathVariable("id") int cthoadonid,
                                                   @RequestBody ChiTietHoaDon_Dto cthoaDonDto) {
        ChiTietHoaDon_Dto updated_cthoadon = chiTietHoaDonService.updateCTHoaDon(cthoadonid, cthoaDonDto);
        return ResponseEntity.ok(updated_cthoadon);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletehoadon(@PathVariable("id") int cthoadonid) {
        chiTietHoaDonService.deleteCTHoaDon(cthoadonid);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
