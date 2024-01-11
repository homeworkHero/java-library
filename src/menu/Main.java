package menu;

import item.Buku;
import item.Komik;
import item.Majalah;
import person.Pegawai;
import person.Peminjam;

import java.util.Scanner;

public class Main {
    // public static void itemInit(Perpustakaan perpustakaan) {
    // // Data untuk Buku
    // Buku buku1 = new Buku();
    // buku1.setBuku("Pemrograman Java", "Elexmedia Komputindo", 2019,
    // "978-602-02-9886-1", "Abdul Kadir");

    // Buku buku2 = new Buku();
    // buku2.setBuku("Clean Code", "Prentice Hall", 2008, "978-0-13-235088-4",
    // "Robert C. Martin");

    // // Data untuk Komik
    // Komik komik1 = new Komik();
    // komik1.setKomik("One Piece", "Shueisha", 1997, "978-4-08-873621-1", "Eiichiro
    // Oda", "Eiichiro Oda",
    // "Petualangan");

    // Komik komik2 = new Komik();
    // komik2.setKomik("Naruto", "Shueisha", 1999, "978-4-08-874247-2", "Masashi
    // Kishimoto", "Masashi Kishimoto",
    // "Ninja");

    // // Data untuk Majalah
    // Majalah majalah1 = new Majalah();
    // majalah1.setMajalah("Bobo", "PT. Gramedia Majalah", 2019, "977-0216-14-7001",
    // "Edisi 01/2019", "Anak-anak");

    // Majalah majalah2 = new Majalah();
    // majalah2.setMajalah("National Geographic", "National Geographic Society",
    // 1888, "NGM-1888-01", "Vol. 1 No. 1",
    // "Ilmu Pengetahuan");

    // perpustakaan.tambahItem(buku1);
    // perpustakaan.tambahItem(buku2);
    // perpustakaan.tambahItem(komik1);
    // perpustakaan.tambahItem(komik2);
    // perpustakaan.tambahItem(majalah1);
    // perpustakaan.tambahItem(majalah2);
    // }

    public static void main(String[] args) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Perpustakaan perpustakaan = new Perpustakaan();
        Scanner input = new Scanner(System.in);
        int pilihan;

        // itemInit(perpustakaan);

        boolean exit = false;
        do {
            // membersihkan layar console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("==================MENU ITEM==================");
            System.out.println("1. Menu Buku");
            System.out.println("2. Menu Komik");
            System.out.println("3. Menu Majalah");
            System.out.println("4. Lihat Koleksi");
            System.out.println("5. Cari Koleksi");
            System.out.println("=================MENU PERSON=================");
            System.out.println("6. Menu Pegawai");
            System.out.println("7. Menu Peminjam");
            System.out.println("8. Keluar");

            try {
                System.out.print("\nPilih menu: ");
                pilihan = input.nextInt();
            } catch (Exception e) {
                System.out.println("Inputan tidak valid.");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    Buku.menuBuku(perpustakaan);
                    break;
                case 2:
                    Komik.menuKomik(perpustakaan);
                    break;
                case 3:
                    Majalah.menuMajalah(perpustakaan);
                    break;
                case 4:
                    System.out.println("==================DAFTAR KOLEKSI==================\n");
                    perpustakaan.lihatKoleksi("semua");
                    break;
                case 5:
                    System.out.println("==================CARI KOLEKSI==================\n");
                    System.out.print("Masukkan judul\t: ");
                    input.nextLine();
                    String judul = input.nextLine();

                    perpustakaan.cariItem(judul, "semua");

                    break;
                case 6:
                    Pegawai.menuPegawai(perpustakaan);

                    break;
                case 7:
                    Peminjam.menuPeminjam(perpustakaan);

                    break;
                case 8:
                    System.out.println("\nTerima kasih telah menggunakan aplikasi ini.\n");

                    exit = true;
                    break;
                default:
                    break;
            }
        } while (!exit);
    }
}
