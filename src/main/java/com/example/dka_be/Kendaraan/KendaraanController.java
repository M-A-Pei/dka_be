package com.example.dka_be.Kendaraan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{noRegistrasi}")
    public Kendaraan getByNoRegistrasi(@PathVariable("noRegistrasi") String noRegistrasi ){
        return kendaraanService.getByNoRegistrasi(noRegistrasi);
    }

    @PostMapping()
    public Kendaraan createKendaraan(@ModelAttribute Kendaraan kendaraan) {
        return kendaraanService.createKendaraan(kendaraan);
    }

    @DeleteMapping()
    public void deleteKendaraan(@RequestParam("noRegistrasi") String noRegistrasi){
        kendaraanService.deleteKendaraan(noRegistrasi);
    }

    @PutMapping()
    public void updateKendaraan(@ModelAttribute Kendaraan kendaraan, @RequestParam("noRegistrasi") String noRegistrasi){
        kendaraanService.updateKendaraan(kendaraan, noRegistrasi);
    }
}