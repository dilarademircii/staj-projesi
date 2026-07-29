package com.example.adim5jpailiskileri.mapper;

import com.example.adim5jpailiskileri.dto.KullaniciRequestDto;
import com.example.adim5jpailiskileri.dto.KullaniciResponseDto;
import com.example.adim5jpailiskileri.dto.SiparisResponseDto;
import com.example.adim5jpailiskileri.model.Kullanici;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KullaniciMapper {

    public static Kullanici toEntity(KullaniciRequestDto dto) {
        if (dto == null) return null;

        Kullanici kullanici = new Kullanici();
        kullanici.setAd(dto.getAd());
        kullanici.setSoyad(dto.getSoyad());
        kullanici.setEposta(dto.getEposta()); // Eklendi!
        return kullanici;
    }

    public static KullaniciResponseDto toResponseDto(Kullanici entity) {
        if (entity == null) return null;

        List<SiparisResponseDto> siparisDtoList = new ArrayList<>();
        if (entity.getSiparisler() != null) {
            siparisDtoList = entity.getSiparisler().stream()
                    .map(SiparisMapper::toResponseDto)
                    .collect(Collectors.toList());
        }

        return KullaniciResponseDto.builder()
                .id(entity.getId())
                .ad(entity.getAd())
                .soyad(entity.getSoyad())
                .eposta(entity.getEposta()) // Eklendi!
                .siparisler(siparisDtoList)
                .build();
    }
}