package com.example.adim5jpailiskileri.controller;

import com.example.adim5jpailiskileri.model.Kullanici;
import com.example.adim5jpailiskileri.model.Siparis;
import com.example.adim5jpailiskileri.service.KullaniciService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController {

    private final KullaniciService kullaniciService;

    public KullaniciController(KullaniciService kullaniciService) {
        this.kullaniciService = kullaniciService;
    }

    // 1. Kullanıcı Ekleme: POST http://localhost:8083/api/kullanicilar
    @PostMapping
    public Kullanici kullaniciEkle(@RequestBody Kullanici kullanici) {
        return kullaniciService.kullaniciEkle(kullanici);
    }

    // 2. Kullanıcıya Sipariş Ekleme: POST http://localhost:8083/api/kullanicilar/1/siparisler
    @PostMapping("/{kullaniciId}/siparisler")
    public Siparis siparisEkle(@PathVariable Long kullaniciId, @RequestBody Siparis siparis) {
        return kullaniciService.siparisEkle(kullaniciId, siparis);
    }

    // 3. Kullanıcıları ve Siparişleri Listeleme: GET http://localhost:8083/api/kullanicilar
    @GetMapping
    public List<Kullanici> tumKullanicilar() {
        return kullaniciService.tumKullanicilariGetir();
    }
}