package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.TacGiaMapper;
import com.example.computer_shoponline.dto.TacGia_Dto;
import com.example.computer_shoponline.entity.NhaXuatBan;
import com.example.computer_shoponline.entity.TacGia;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.TacGiaReponsitory;
import com.example.computer_shoponline.service.TacGiaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TacGiaServiceimpl implements TacGiaService {

    private TacGiaReponsitory tacGiaReponsitory;




    @Override
    public TacGia_Dto getTacGia(int tacGiaId) {
        TacGia tacGia = tacGiaReponsitory.findById(tacGiaId)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found" + tacGiaId));
        return TacGiaMapper.maptoTacGia_Dto(tacGia);
    }

    @Override
    public List<TacGia_Dto> getAllTacGia() {
        List<TacGia> tacgias = tacGiaReponsitory.findAll();
        return tacgias.stream().map((tacgia) -> TacGiaMapper.maptoTacGia_Dto(tacgia))
                .collect(Collectors.toList());
    }

    @Override
    public TacGia_Dto createTacGia(TacGia_Dto tacGiaDto) {
        TacGia tacgias = TacGiaMapper.maptoTacGia(tacGiaDto);
        TacGia save_tacgia = tacGiaReponsitory.save(tacgias);
        return  TacGiaMapper.maptoTacGia_Dto(save_tacgia);
    }

    @Override
    public TacGia_Dto updateTacGia(int tacgiaId, TacGia_Dto tacGiaDto) {
        TacGia tacGia = tacGiaReponsitory.findById(tacgiaId).orElseThrow(()
                -> new ResourceNotFoundException("Brand not found" + tacgiaId));
        tacGia.setTenTacGia(tacGiaDto.getTenTacGia());
        tacGia.setTieuSu(tacGiaDto.getTieuSu());

        TacGia savetacgia = tacGiaReponsitory.save(tacGia);

        return TacGiaMapper.maptoTacGia_Dto(savetacgia);
    }

    @Override
    public void deleteTacGia(int tacgiaId) {
        TacGia tacGia = tacGiaReponsitory.findById(tacgiaId).orElseThrow(()
                -> new ResourceNotFoundException("Supplier not found" + tacgiaId));
        tacGiaReponsitory.deleteById(tacgiaId);
    }
}
