package com.example.adim5jpailiskileri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KullaniciRequestDto {
    private String ad;
    private String soyad;
    private String eposta; // Eklendi!
}