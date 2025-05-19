package com.example.computer_shoponline.controller;

import com.example.computer_shoponline.dto.TheLoai_Dto;
import com.example.computer_shoponline.service.TheLoaiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/theloais")
public class TheLoaiController {

    private TheLoaiService theLoaiService;

    // Build Add supplier Rest api
    @PostMapping
    public ResponseEntity<TheLoai_Dto> createCategory(@RequestBody TheLoai_Dto theLoai_dto) {
        TheLoai_Dto saved_category = theLoaiService.createTheLoai(theLoai_dto);
        return new ResponseEntity<>(saved_category, HttpStatus.CREATED);
    }

    // Build Get By ID suppler Rest api
    @GetMapping("{id}")
    public ResponseEntity<TheLoai_Dto> getByIdCategory(@PathVariable("id") int category_id) {
        TheLoai_Dto categoryDto = theLoaiService.getTheLoai(category_id);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<TheLoai_Dto>> getAllCategory() {
        List<TheLoai_Dto> categoryDtos = theLoaiService.getAllTheLoai();
        return ResponseEntity.ok(categoryDtos);
    }

    // Build Update suppler rest api
    @PutMapping("{id}")
    public ResponseEntity<TheLoai_Dto> updateCategory(@PathVariable("id") int category_id,
                                                      @RequestBody TheLoai_Dto theLoai_dto) {
        TheLoai_Dto up_category = theLoaiService.updateTheLoai(category_id, theLoai_dto);
        return ResponseEntity.ok(up_category);
    }

    // Build delete supplier rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int category_id) {
        theLoaiService.deleteTheLoai(category_id);
        return ResponseEntity.ok("Category Delete succesfully!");
    }
}
