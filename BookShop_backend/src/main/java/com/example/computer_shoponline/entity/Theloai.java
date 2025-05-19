package com.example.computer_shoponline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "the_loai")
public class Theloai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTheLoai;

    private String tenTheLoai;
    private String moTa;

    @OneToMany(mappedBy = "maTheLoai")
    private List<Sach> saches;

    public Theloai(int maTheLoai, String tenTheLoai, String moTa) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
    }
}
