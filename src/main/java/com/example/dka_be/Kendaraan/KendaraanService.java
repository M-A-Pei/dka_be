package com.example.dka_be.Kendaraan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KendaraanService {
    private final KendaraanRepo kendaraanRepo;

    @Autowired
    public KendaraanService(KendaraanRepo kendaraanRepo) {
        this.kendaraanRepo = kendaraanRepo;
    }

    public List<Kendaraan> getAllKendaraan() {
        return kendaraanRepo.findAll();
    }
    public Kendaraan createKendaraan(Kendaraan kendaraan) {
        return kendaraanRepo.save(kendaraan);
    }
    public List<Kendaraan> getBySearch(String noRegistrasi, String namaPemilik) {
        return kendaraanRepo.findByNoRegistrasiOrNamaPemilik(noRegistrasi, namaPemilik);
    }

}