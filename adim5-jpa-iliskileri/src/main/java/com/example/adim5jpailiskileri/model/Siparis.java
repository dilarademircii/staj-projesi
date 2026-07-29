package com.example.adim5jpailiskileri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "siparisler")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urunAdi;
    private Double tutar;

    // FetchType.LAZY -> İhtiyaç duyulmadıkça kullanıcı detayını veritabanından çekmez (Performans için)
    // @JoinColumn -> Veritabanında siparisler tablosuna "kullanici_id" adında bir ikincil anahtar (Foreign Key) sütunu ekler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullanici_id")
    @JsonIgnore // Postman'de veriyi çekerken sonsuz döngüye (Kullanıcı -> Sipariş -> Kullanıcı...) girmesini engeller
    private Kullanici kullanici;

    // Parametresiz yapıcı metot (JPA için şarttır)
    public Siparis() {}

    // Parametreli yapıcı metot
    public Siparis(String urunAdi, Double tutar, Kullanici kullanici) {
        this.urunAdi = urunAdi;
        this.tutar = tutar;
        this.kullanici = kullanici;
    }

    // Getter ve Setter Metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
}