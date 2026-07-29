package com.example.adim5jpailiskileri.service;

import com.example.adim5jpailiskileri.model.Kullanici;
import com.example.adim5jpailiskileri.model.Siparis;
import com.example.adim5jpailiskileri.repository.KullaniciRepository;
import com.example.adim5jpailiskileri.repository.SiparisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KullaniciService {

    private final KullaniciRepository kullaniciRepository;
    private final SiparisRepository siparisRepository;

    // Constructor Injection (Bağımlılıkları içeriye alıyoruz)
    public KullaniciService(KullaniciRepository kullaniciRepository, SiparisRepository siparisRepository) {
        this.kullaniciRepository = kullaniciRepository;
        this.siparisRepository = siparisRepository;
    }

    // 1. Yeni Kullanıcı Kaydetme
    public Kullanici kullaniciEkle(Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    // 2. Belirli bir Kullanıcıya Sipariş Ekleme
    public Siparis siparisEkle(Long kullaniciId, Siparis siparis) {
        // Önce kullanıcının veritabanında var olup olmadığını kontrol ediyoruz
        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        // Siparişe ait olduğu kullanıcıyı bağlıyoruz
        siparis.setKullanici(kullanici);

        // Siparişi kaydediyoruz
        return siparisRepository.save(siparis);
    }

    // 3. Tüm Kullanıcıları ve Siparişlerini Çekme (N+1 Çözümlü Metod)
    public List<Kullanici> tumKullanicilariGetir() {
        return kullaniciRepository.tumKullanicilariSiparisleriyleGetir();
    }
}
