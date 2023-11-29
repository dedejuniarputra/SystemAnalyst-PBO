/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahap2pbo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dede
 */
public class AnggotaPerpustakaan {
    public String nama;
    public String nomorAnggota;
    public String alamat;
    public List<TransaksiPeminjaman> sejarahPeminjaman;

    public AnggotaPerpustakaan(String nama, String nomorAnggota, String alamat) {
        this.nama = nama;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.sejarahPeminjaman = new ArrayList<>();
        
        Buku bukuSample = new Buku("Bersikap Sederhana", "dede.jp", "11122000");
        TransaksiPeminjaman transaksiSample = new TransaksiPeminjaman("PJ01", new Date(), null, "14:30", 5, this, bukuSample);
    }

    public void pinjamBuku(Buku buku, String judulBuku, Date tanggalPinjam, int durasiPinjam) {
        for (TransaksiPeminjaman transaksi : sejarahPeminjaman) {
            if (transaksi.getBuku().getJudulBuku().equals(judulBuku) && transaksi.getTanggalJatuhTempo() == null) {
                System.out.println("Buku " + judulBuku + " telah dipinjam.");
                return;
            }
        }

        if (buku.cekKetersediaan()) {
            TransaksiPeminjaman transaksi = new TransaksiPeminjaman("P" + (sejarahPeminjaman.size() + 1), new Date(), null,"14:30", durasiPinjam, this, buku
            );
            sejarahPeminjaman.add(transaksi);
            buku.setKetersediaan(false);
            System.out.println("Berhasil meminjam buku " + judulBuku + ".");
            System.out.println("Buku harus dikembalikan dalam " + durasiPinjam + " hari.");
        } else {
            System.out.println("Buku dengan judul " + judulBuku + " tidak tersedia.");
        }
    }

    public void kembalikanBuku(Buku buku, String judulBuku, Date tanggalKembali) {
    for (TransaksiPeminjaman transaksi : sejarahPeminjaman) {
        if (transaksi.getBuku().getJudulBuku().equalsIgnoreCase(judulBuku) && transaksi.getTanggalJatuhTempo() == null) {
            transaksi.setTanggalJatuhTempo(tanggalKembali);
            buku.setKetersediaan(true);
            System.out.println("Anggota " + nama + " telah mengembalikan buku " + judulBuku);
            System.out.println("-----------------------------------------------");
            return;
        }
    }
    System.out.println("Peminjaman buku " + judulBuku + " tidak ditemukan.");
    System.out.println("------------------------------------------------------");
}

    String getNama() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
