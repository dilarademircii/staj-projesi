package com.example.adim5jpailiskileri.controller;

import com.example.adim5jpailiskileri.dto.KullaniciRequestDto;
import com.example.adim5jpailiskileri.dto.KullaniciResponseDto;
import com.example.adim5jpailiskileri.dto.SiparisRequestDto;
import com.example.adim5jpailiskileri.dto.SiparisResponseDto;
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

    @PostMapping
    public KullaniciResponseDto kullaniciEkle(@RequestBody KullaniciRequestDto dto) {
        return kullaniciService.kullaniciEkle(dto);
    }

    @GetMapping
    public List<KullaniciResponseDto> tumKullanicilariGetir() {
        return kullaniciService.tumKullanicilariGetir();
    }

    @PostMapping("/{kullaniciId}/siparisler")
    public SiparisResponseDto siparisEkle(@PathVariable Long kullaniciId, @RequestBody SiparisRequestDto dto) {
        return kullaniciService.siparisEkle(kullaniciId, dto);
    }
}