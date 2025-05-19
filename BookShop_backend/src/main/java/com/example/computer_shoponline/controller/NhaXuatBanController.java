package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.NhaXuatBan_Dto;
import com.example.computer_shoponline.service.NhaXuatBanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/nhaxuatbans")
public class NhaXuatBanController {

    private NhaXuatBanService nhaXuatBanService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<NhaXuatBan_Dto> createSupplier(@RequestBody NhaXuatBan_Dto nhaXuatBan_dto) {
        NhaXuatBan_Dto saved_supplier = nhaXuatBanService.createNhaXuatBan(nhaXuatBan_dto);
        return new ResponseEntity<>(saved_supplier, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<NhaXuatBan_Dto> getByIdSupplier(@PathVariable("id") int supplierId) {
        NhaXuatBan_Dto supplierDto = nhaXuatBanService.getIDNhaXuatBan(supplierId);
        return ResponseEntity.ok(supplierDto);
    }

    @GetMapping
    public ResponseEntity<List<NhaXuatBan_Dto>> getAllSuppliers() {
        List<NhaXuatBan_Dto> supplierDtos = nhaXuatBanService.getAllNhaXuatBan();
        return ResponseEntity.ok(supplierDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<NhaXuatBan_Dto> updateSupplier(@PathVariable("id") int supplierid,
                                                         @RequestBody NhaXuatBan_Dto nhaXuatBan_dto) {
        NhaXuatBan_Dto updated_supplier = nhaXuatBanService.updateNhaXuatBan(supplierid, nhaXuatBan_dto);
        return ResponseEntity.ok(updated_supplier);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable("id") int supplierId) {
        nhaXuatBanService.deleteNhaXuatBan(supplierId);
        return ResponseEntity.ok("Supplier Delete succesfully!");
    }
}
