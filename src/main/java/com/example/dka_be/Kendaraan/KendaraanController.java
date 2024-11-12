package com.example.dka_be.Kendaraan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kendaraan")
public class KendaraanController {
    private final KendaraanService kendaraanService;

    @Autowired
    public KendaraanController(KendaraanService kendaraanService) {
        this.kendaraanService = kendaraanService;
    }

    @GetMapping()
    public List<Kendaraan> getAllKendaraan() {
        return kendaraanService.getAllKendaraan();
    }

    @GetMapping("/search")
    public List<Kendaraan> getBySearch(@RequestParam("noRegistrasi") String noRegistrasi, @RequestParam("namaPemilik") String namaPemilik) {
        return kendaraanService.getBySearch(noRegistrasi, namaPemilik);
    }

    @PostMapping()
    public Kendaraan createKendaraan(@ModelAttribute Kendaraan kendaraan) {
        System.out.println(kendaraan.getNamaPemilik());
        return kendaraanService.createKendaraan(kendaraan);
    }
}