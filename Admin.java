/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahap2pbo;

/**
 *
 * @author dede
 */
public class Admin {
    public String id;
    public String nama;
    public String alamat;
    public String nomorTelepon;
    
    public Admin(){
    }

    public Admin(String id, String nama, String alamat, String nomorTelepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.nomorTelepon = nomorTelepon;
    }
    
    public void login() {
        System.out.println("==========================================");
        System.out.println("Admin " + nama + " telah berhasil login.");
        System.out.println("==========================================");
        System.out.println();
    }

    public void logout() {
        System.out.println("============================================");
        System.out.println("Admin telah berhasil logout.");
        System.out.println("============================================");
    }
}
