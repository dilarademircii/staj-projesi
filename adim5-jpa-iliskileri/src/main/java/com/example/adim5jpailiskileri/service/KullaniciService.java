package com.example.adim5jpailiskileri.service;

import com.example.adim5jpailiskileri.dto.KullaniciRequestDto;
import com.example.adim5jpailiskileri.dto.KullaniciResponseDto;
import com.example.adim5jpailiskileri.dto.SiparisRequestDto;
import com.example.adim5jpailiskileri.dto.SiparisResponseDto;
import com.example.adim5jpailiskileri.mapper.KullaniciMapper;
import com.example.adim5jpailiskileri.mapper.SiparisMapper;
import com.example.adim5jpailiskileri.model.Kullanici;
import com.example.adim5jpailiskileri.model.Siparis;
import com.example.adim5jpailiskileri.repository.KullaniciRepository;
import com.example.adim5jpailiskileri.repository.SiparisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final SiparisRepository siparisRepository;

    public KullaniciService(KullaniciRepository kullaniciRepository, SiparisRepository siparisRepository) {
        this.kullaniciRepository = kullaniciRepository;
        this.siparisRepository = siparisRepository;
    }

    // Kullanıcı Ekleme
    public KullaniciResponseDto kullaniciEkle(KullaniciRequestDto dto) {
        Kullanici kullanici = KullaniciMapper.toEntity(dto);
        Kullanici kayitliKullanici = kullaniciRepository.save(kullanici);
        return KullaniciMapper.toResponseDto(kayitliKullanici);
    }

    // Tüm Kullanıcıları Getirme
    public List<KullaniciResponseDto> tumKullanicilariGetir() {
        return kullaniciRepository.findAll().stream()
                .map(KullaniciMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    // Kullanıcıya Sipariş Ekleme
    public SiparisResponseDto siparisEkle(Long kullaniciId, SiparisRequestDto dto) {
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı: " + kullaniciId));

        Siparis siparis = SiparisMapper.toEntity(dto);
        siparis.setKullanici(kullanici);

        Siparis kayitliSiparis = siparisRepository.save(siparis);
        return SiparisMapper.toResponseDto(kayitliSiparis);
    }
}
