package com.example.adim5jpailiskileri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiparisResponseDto {
    private Long id;
    private String urunAdi;
    private Double tutar;
}
