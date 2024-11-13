package com.example.dka_be.Kendaraan;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KendaraanRepo extends JpaRepository<Kendaraan, String> {
    @Query("SELECT * FROM `kendaraan` WHERE no_registrasi = ?1 OR nama_pemilik LIKE '%?2%'")
    List<Kendaraan> findBySearch(String NoRegistrasi, String NamaPemilik);
    Kendaraan findDistinctByNoRegistrasi(String NoRegistrasi);
}
