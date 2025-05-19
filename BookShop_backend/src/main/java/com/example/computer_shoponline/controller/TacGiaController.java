package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.TacGia_Dto;
import com.example.computer_shoponline.service.TacGiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tacgias")
public class TacGiaController {

    private TacGiaService tacGiaService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<TacGia_Dto> createTacgia(@RequestBody TacGia_Dto tacGia_dto) {
        TacGia_Dto save_tacgia = tacGiaService.createTacGia(tacGia_dto);
        return new ResponseEntity<>(save_tacgia, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<TacGia_Dto> getByIdBrand(@PathVariable("id") int tacgiaId) {
        TacGia_Dto tacGia_dto = tacGiaService.getTacGia(tacgiaId);
        return ResponseEntity.ok(tacGia_dto);
    }

    @GetMapping
    public ResponseEntity<List<TacGia_Dto>> getAllBrands() {
        List<TacGia_Dto> tacGiaDtos = tacGiaService.getAllTacGia();
        return ResponseEntity.ok(tacGiaDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<TacGia_Dto> updateBrand(@PathVariable("id") int tacgiaId,
                                                  @RequestBody TacGia_Dto tacGia_dto) {
        TacGia_Dto update_tacgia = tacGiaService.updateTacGia(tacgiaId, tacGia_dto);
        return ResponseEntity.ok(update_tacgia);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int tacgiaId) {
        tacGiaService.deleteTacGia(tacgiaId);
        return ResponseEntity.ok("Brand Delete succesfully!");
    }
}
