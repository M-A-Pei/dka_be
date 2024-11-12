package com.example.dka_be.Kendaraan;

import com.example.dka_be.Kendaraan.enums.BahanBakar;
import com.example.dka_be.Kendaraan.enums.Warna;

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

    @Column(name = "tahun", min = 1900, max = 2022)
    private Int tahun;

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
            String suffix = "XYZ";
            Int random = new Random().nextInt(9000) + 1000;
            this.noRegistrasi = prefix + "-" + random + "-" + suffix;
        }
    }

    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public Warna getWarna() {
        return warna;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }   

    public BahanBakar getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(BahanBakar bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
}
