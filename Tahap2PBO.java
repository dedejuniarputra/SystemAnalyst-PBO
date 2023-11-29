package tahap2pbo;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dedee
 */
public class Tahap2PBO {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        Buku Web = new Buku("Web Pemula", "Rimba", "69001200");
        Buku Html = new Buku("HTML DASAR", "Audhia", "1110011");
        Buku Figma = new Buku("Figma", "Dedee", "030604");
        Buku Java = new Buku("Java Programming", "Mark", "19990802"); 

        AnggotaPerpustakaan anggota1 = new AnggotaPerpustakaan("audhia", "b01", "Teluk ");
        Admin admin1 = new Admin("A1", "Miko", "Sukarame", "08123456789");

        int pilih;
        do {
            System.out.println("===== Selamat datang di Perpustakaan Sederhana =====");
            System.out.println("Menu :");
            System.out.println("1. Admin");
            System.out.println("2. Anggota Perpustakaan");
            System.out.println("3. Keluar");

            System.out.print("Pilihan Anda : ");
            pilih = scanner.nextInt();

            switch (pilih) {
                
                case 1 :
                    admin1.login();
                    adminMenu(Web, scanner);
                    break;
                    
                case 2 :
                    memberMenu(anggota1, Web, Html, Figma, Java, scanner);
                    break;
                    
                case 3 :
                    System.out.println("--- Terima kasih telah menggunakan layanan perpustakaan. ---");
                    break;
                        
                default :
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilih != 3);
    }
 }
    
    private static void adminMenu(Buku buku, Scanner scanner) {
        int pilihanAdmin;
        do {
            System.out.println("\nMenu Admin");
            System.out.println("1. Menambah Koleksi Buku");
            System.out.println("2. Keluar");

            System.out.print("Pilihan Anda : ");
            pilihanAdmin = scanner.nextInt();

            switch (pilihanAdmin) {
                case 1 :
                    Buku bukuBaru = tambahBuku(scanner);
                    bukuBaru.tambahKeKoleksi();
                    break;
                
                case 2 : 
                    Admin admin = new Admin();
                    admin.logout();
                    break;
                    
                default : 
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihanAdmin != 2);
    }

    private static Buku tambahBuku(Scanner scanner) {
        System.out.print("Masukkan judul buku : ");
        scanner.nextLine();
        String judulBuku = scanner.nextLine();

        System.out.print("Masukkan penulis buku : ");
        String namaPengarang = scanner.nextLine();

        System.out.print("Masukkan nomor ISBN buku : ");
        String isbn = scanner.nextLine();

        return new Buku(judulBuku, namaPengarang, isbn);
    }

    private static void memberMenu(AnggotaPerpustakaan anggota, Buku buku1, Buku buku2, Buku buku3, Buku buku4, Scanner scanner) {
        int pilihanAnggota;
        do {
            System.out.println("\nMenu Anggota Perpustakaan");
            System.out.println("1. Meminjam Buku");
            System.out.println("2. Mengembalikan Buku");
            System.out.println("3. Keluar");

            System.out.print("Masukkan Pilihan : ");
            pilihanAnggota = scanner.nextInt();

            switch (pilihanAnggota) {
                case 1 : 
                    System.out.println("Buku yang Tersedia :");
                    System.out.println("1. " + buku1.getJudulBuku());
                    System.out.println("2. " + buku2.getJudulBuku());
                    System.out.println("3. " + buku3.getJudulBuku());
                    System.out.println("4. " + buku4.getJudulBuku());
                    
                    System.out.print("Pilih nomor buku yang ingin Anda pinjam : ");
                    int opsiBuku = scanner.nextInt();

                    switch (opsiBuku) {
                        case 1 :
                            anggota.pinjamBuku(buku1, buku1.getJudulBuku(), new Date(), 14);
                            break;
                            
                        case 2 :
                            anggota.pinjamBuku(buku2, buku2.getJudulBuku(), new Date(), 14);
                            break;
                            
                        case 3 :
                            anggota.pinjamBuku(buku3, buku3.getJudulBuku(), new Date(), 14);
                            break;
                            
                        case 4 :
                            anggota.pinjamBuku(buku4, buku4.getJudulBuku(), new Date(), 14);
                            break;
                            
                        default :
                            System.out.println("Pilihan tidak valid. Silakan coba lagi ");
                            break;
                    }
                    break;
                
                case 2 : 
                    System.out.print("Masukkan judul buku yang ingin Anda kembalikan : ");
                    scanner.nextLine(); 
                    String judulKembali = scanner.nextLine();
                    anggota.kembalikanBuku(buku1, judulKembali, new Date());
                    break;
                
                case 3 :
                    System.out.println("Kembali ke Menu Utama ");
                    break;
                    
                default :
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihanAnggota != 3);
    }
