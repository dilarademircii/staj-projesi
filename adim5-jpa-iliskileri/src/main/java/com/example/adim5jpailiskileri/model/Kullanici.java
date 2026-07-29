package com.example.adim5jpailiskileri.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kullanicilar")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;

    // FetchType.LAZY -> Siparişler sadece istendiğinde yüklensin (performans için)
    // CascadeType.ALL -> Kullanıcı silinirse ona ait siparişler de otomatik silinsin
    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Siparis> siparisler = new ArrayList<>();

    // Parametresiz yapıcı metot (JPA için şarttır)
    public Kullanici() {}

    // Parametreli yapıcı metot
    public Kullanici(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    // Getter ve Setter Metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    public void setSiparisler(List<Siparis> siparisler) {
        this.siparisler = siparisler;
    }
}