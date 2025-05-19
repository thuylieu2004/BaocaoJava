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
@Table(name = "tac_gia")

public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maTacGia;

    private String tenTacGia;
    private String tieuSu;

    @OneToMany(mappedBy = "maTacGia")
    private List<Sach> saches;

    public TacGia(int maTacGa, String tenTacGia, String tieuSu) {
       this.maTacGia = maTacGa;
       this.tenTacGia = tenTacGia;
       this.tieuSu = tieuSu;
    }
}
