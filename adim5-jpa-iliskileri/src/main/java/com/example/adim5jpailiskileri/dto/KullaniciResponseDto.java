package com.example.adim5jpailiskileri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciResponseDto {
    private Long id;
    private String ad;
    private String soyad;
    private String eposta; // Eklendi!
    private List<SiparisResponseDto> siparisler;
}