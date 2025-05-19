package com.example.computer_shoponline.service.impl;

import com.example.computer_shoponline.Mapper.NhaXuatBanMaper;
import com.example.computer_shoponline.dto.NhaXuatBan_Dto;
import com.example.computer_shoponline.entity.NhaXuatBan;
import com.example.computer_shoponline.exception.ResourceNotFoundException;
import com.example.computer_shoponline.reponsitory.NhaXuatBanReponsitory;
import com.example.computer_shoponline.service.NhaXuatBanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NhaXuatBanServiceimpl implements NhaXuatBanService {

    private NhaXuatBanReponsitory nhaXuatBanReponsitory;



    @Override
    public NhaXuatBan_Dto createNhaXuatBan(NhaXuatBan_Dto nhaXuatBan_dto) {
        NhaXuatBan nhaXuatBan = NhaXuatBanMaper.maptoNhaXuatBan(nhaXuatBan_dto);
        NhaXuatBan savedNhaXuatBan = nhaXuatBanReponsitory.save(nhaXuatBan);
        return  NhaXuatBanMaper.maptoNhaXuatBanDto(savedNhaXuatBan);
    }

    @Override
    public NhaXuatBan_Dto getIDNhaXuatBan(int supplierId) {
        NhaXuatBan nhaXuatBan = nhaXuatBanReponsitory.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found" + supplierId));
        return NhaXuatBanMaper.maptoNhaXuatBanDto(nhaXuatBan);
    }

    @Override
    public List<NhaXuatBan_Dto> getAllNhaXuatBan() {
        List<NhaXuatBan> nhaXuatBans = nhaXuatBanReponsitory.findAll();
        return nhaXuatBans.stream().map((nhaXuatBan) -> NhaXuatBanMaper.maptoNhaXuatBanDto(nhaXuatBan))
                .collect(Collectors.toList());
    }

    @Override
    public NhaXuatBan_Dto updateNhaXuatBan(int supplierId, NhaXuatBan_Dto nhaXuatBan_dto) {
        NhaXuatBan nhaXuatBan = nhaXuatBanReponsitory.findById(supplierId).orElseThrow(() -> new ResourceNotFoundException("Supplier not found" + supplierId));
        nhaXuatBan.setTenNhaXuatBan(nhaXuatBan_dto.getTenNhaXuatBan());
        nhaXuatBan.setEmail(nhaXuatBan_dto.getEmail());
        nhaXuatBan.setDiaChi(nhaXuatBan_dto.getDiaChi());

        NhaXuatBan savedNhaXuatBan = nhaXuatBanReponsitory.save(nhaXuatBan);

        return NhaXuatBanMaper.maptoNhaXuatBanDto(savedNhaXuatBan);
    }

    @Override
    public void deleteNhaXuatBan(int supplierId) {
        NhaXuatBan nhaXuatBan = nhaXuatBanReponsitory.findById(supplierId).orElseThrow(()
                -> new ResourceNotFoundException("Supplier not found" + supplierId));
        nhaXuatBanReponsitory.deleteById(supplierId);
    }
}
