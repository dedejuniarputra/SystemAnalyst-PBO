/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahap2pbo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dede
 */
public class Notifikasi {
    private String id;
    private Date tanggal;
    private String pesan;
    private AnggotaPerpustakaan anggotaPerpustakaan;

    public Notifikasi(String id, Date tanggal, String pesan, AnggotaPerpustakaan anggotaPerpustakaan) {
        this.id = id;
        this.tanggal = tanggal;
        this.pesan = pesan;
        this.anggotaPerpustakaan = anggotaPerpustakaan;
    }

    Notifikasi(String n01, Date date, AnggotaPerpustakaan anggota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void kirimNotifikasiPeminjaman() {
        System.out.println("Notifikasi Peminjaman");
        System.out.println("---------------------------------------------");
        System.out.println("ID : " + id);        
        System.out.println("Tanggal : " + formatDate(tanggal));
        System.out.println("Pesan : " + pesan);
        System.out.println("Untuk : " + anggotaPerpustakaan.getNama());
        System.out.println("---------------------------------------------");
    }

    public void kirimNotifikasiPengembalian() {
        System.out.println("Notifikasi Pengembalian");
        System.out.println("---------------------------------------------");
        System.out.println("ID : " + id);
        System.out.println("Tanggal : " + formatDate(tanggal));
        System.out.println("Pesan : " + pesan);
        System.out.println("Untuk : " + anggotaPerpustakaan.getNama());
        System.out.println("---------------------------------------------");
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Tanggal Invalid";
        }
    }
}
