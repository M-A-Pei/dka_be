package com.example.dka_be.Kendaraan;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KendaraanRepo extends JpaRepository<Kendaraan, String> {
    List<Kendaraan> findByNoRegistrasiOrNamaPemilik(String NoRegistrasi, String NamaPemilik);
    Kendaraan findDistinctByNoRegistrasi(String NoRegistrasi);
}
