package com.example.adim5jpailiskileri.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "kullanicilar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;

    @Column(nullable = false)
    private String eposta; // Bu alanı ekliyoruz

    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL)
    private List<Siparis> siparisler;
}