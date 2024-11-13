package com.example.dka_be.Kendaraan;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KendaraanRepo extends JpaRepository<Kendaraan, String> {
    @Query("SELECT k FROM Kendaraan k WHERE k.noRegistrasi = ?1 OR k.namaPemilik LIKE %?2%")
    List<Kendaraan> findBySearch(String noRegistrasi, String namaPemilik);    
    Kendaraan findDistinctByNoRegistrasi(String NoRegistrasi);
}
