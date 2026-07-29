package com.example.adim5jpailiskileri.mapper;

import com.example.adim5jpailiskileri.dto.SiparisRequestDto;
import com.example.adim5jpailiskileri.dto.SiparisResponseDto;
import com.example.adim5jpailiskileri.model.Siparis;

public class SiparisMapper {

    public static Siparis toEntity(SiparisRequestDto dto) {
        if (dto == null) return null;

        Siparis siparis = new Siparis();
        siparis.setUrunAdi(dto.getUrunAdi());
        siparis.setTutar(dto.getTutar());
        return siparis;
    }

    public static SiparisResponseDto toResponseDto(Siparis entity) {
        if (entity == null) return null;

        return SiparisResponseDto.builder()
                .id(entity.getId())
                .urunAdi(entity.getUrunAdi())
                .tutar(entity.getTutar())
                .build();
    }
}