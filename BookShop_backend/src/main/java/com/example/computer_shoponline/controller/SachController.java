package com.example.computer_shoponline.controller;


import com.example.computer_shoponline.dto.Sach_Dto;
import com.example.computer_shoponline.service.SachService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/sachs")
public class SachController {

    private SachService sachService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<Sach_Dto> createComputerParts(@RequestBody Sach_Dto sach_dto) {
        Sach_Dto saved_computeparts = sachService.createSach(sach_dto);
        return new ResponseEntity<>(saved_computeparts, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<Sach_Dto> getByIdComputerparts(@PathVariable("id") int sachId) {
        Sach_Dto sach_dto = sachService.getByIDSach(sachId);
        return ResponseEntity.ok(sach_dto);
    }

    @GetMapping
    public ResponseEntity<List<Sach_Dto>> getAllComputerParts() {
        List<Sach_Dto> sachs = sachService.getAllSach();
        return ResponseEntity.ok(sachs);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<Sach_Dto> updateAComputerParts(@PathVariable("id") int sachId,
                                                         @RequestBody Sach_Dto sach_dto) {
        Sach_Dto update_Sach = sachService.updateSach(sachId, sach_dto);
        return ResponseEntity.ok(update_Sach);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCOmputerparts(@PathVariable("id") int sachId) {
        sachService.deleteSach(sachId);
        return ResponseEntity.ok("ComputerParts Delete succesfully!");
    }
}
