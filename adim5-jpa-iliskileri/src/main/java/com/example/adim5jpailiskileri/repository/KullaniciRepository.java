package com.example.adim5jpailiskileri.repository;

import com.example.adim5jpailiskileri.model.Kullanici;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {

    // N+1 Problemini Çözen Sihirli Metot:
    // @EntityGraph sayesinde Hibernate kullanıcıları çekerken tek bir SQL JOIN sorgusu atar
    // ve siparişleri de aynı anda çeker (N+1 defa SQL çalıştırmak yerine 1 defa çalıştırır).
    @EntityGraph(attributePaths = {"siparisler"})
    @Query("SELECT k FROM Kullanici k")
    List<Kullanici> tumKullanicilariSiparisleriyleGetir();
}