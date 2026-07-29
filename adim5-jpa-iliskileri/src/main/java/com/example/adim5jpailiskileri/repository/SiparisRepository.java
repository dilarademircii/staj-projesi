package com.example.adim5jpailiskileri.repository;

import com.example.adim5jpailiskileri.model.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiparisRepository extends JpaRepository<Siparis, Long> {
}
