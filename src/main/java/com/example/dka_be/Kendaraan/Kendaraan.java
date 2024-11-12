package com.example.dka_be.Kendaraan;

import java.util.Random;

import com.example.dka_be.Kendaraan.enums.BahanBakar;
import com.example.dka_be.Kendaraan.enums.Warna;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "kendaraan")
public class Kendaraan {

    @Id
    private String noRegistrasi;

    @Column(name = "nama_pemilik", nullable = false)
    private String namaPemilik;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "merk")
    private String merk;

    @Column(name = "tahun")
    @Min(1900)
    @Max(2023)
    private int tahun;

    @Column(name = "kapasitas")
    private int kapasitas;

    @Enumerated(EnumType.STRING)
    @Column(name = "warna")
    private Warna warna;

    @Enumerated(EnumType.STRING)
    @Column(name = "bahan_bakar")
    private BahanBakar bahanBakar;

    @PrePersist
    public void prePersist() {
        if (this.noRegistrasi == null){
            String prefix = "B";
            String suffix = randomString(3);
            int random = new Random().nextInt(9000) + 1000;
            this.noRegistrasi = prefix + "-" + random + "-" + suffix;
        }
    }

    public String randomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public String getNoRegistrasi() {
        return this.noRegistrasi;
    }

    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getTahun() {
        return this.tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public Warna getWarna() {
        return this.warna;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }   

    public BahanBakar getBahanBakar() {
        return this.bahanBakar;
    }

    public void setBahanBakar(BahanBakar bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
}
