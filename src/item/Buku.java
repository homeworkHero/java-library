package item;

import java.util.Scanner;
import menu.Perpustakaan;

public class Buku extends Item {
    private String pengarang;

    public void setBuku(String judul, String penerbit, int tahunTerbit, String isbn, String pengarang) {
        super.setItem(judul, penerbit, tahunTerbit, isbn);
        this.pengarang = pengarang;
    }

    @Override
    public String cetak() {
        return "ISBN \t\t: " + super.getUniqueKey() + "\n" + super.cetak() + "Pengarang \t: " + pengarang
                + "\n";
    }

    public static void menuBuku(Perpustakaan perpustakaan) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean exit = false;
        do {
            Scanner input = new Scanner(System.in);
            int pilihan, tahunTerbit;
            String isbn, judul, penerbit, pengarang;
            Buku buku = new Buku();

            System.out.println("==================MENU BUKU==================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Update Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Cari Buku");
            System.out.println("6. Kembali");

            System.out.print("\nPilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("==================TAMBAH BUKU==================");
                    System.out.print("ISBN \t\t: ");
                    isbn = input.nextLine();
                    System.out.print("Judul \t\t: ");
                    judul = input.nextLine();
                    System.out.print("Penerbit \t: ");
                    penerbit = input.nextLine();
                    System.out.print("Tahun Terbit \t: ");
                    tahunTerbit = input.nextInt();
                    input.nextLine();
                    System.out.print("Pengarang \t: ");
                    pengarang = input.nextLine();

                    if (!perpustakaan.checkUniqueKey(isbn, "Buku")) {
                        buku.setBuku(judul, penerbit, tahunTerbit, isbn, pengarang);
                        perpustakaan.tambahItem(buku);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbn + " sudah ada. \n\n");
                    }

                    break;
                case 2:
                    System.out.println("==================KOLEKSI BUKU==================\n");
                    perpustakaan.lihatKoleksi("Buku");
                    break;

                case 3:
                    System.out.println("==================UPDATE BUKU==================\n");
                    System.out.print("ISBN \t\t: ");
                    isbn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(isbn, "Buku")) {
                        System.out.print("\nJudul \t\t: ");
                        judul = input.nextLine();
                        System.out.print("Penerbit \t: ");
                        penerbit = input.nextLine();
                        System.out.print("Tahun Terbit \t: ");
                        tahunTerbit = input.nextInt();
                        input.nextLine();
                        System.out.print("Pengarang \t: ");
                        pengarang = input.nextLine();

                        buku.setBuku(judul, penerbit, tahunTerbit, isbn, pengarang);
                        perpustakaan.updateItem(isbn, buku);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan. \n\n");
                    }
                    break;

                case 4:
                    System.out.println("==================HAPUS BUKU==================\n");
                    System.out.print("ISBN \t: ");
                    isbn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(isbn, "Buku")) {
                        perpustakaan.hapusItem(isbn);
                    } else {
                        System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan. \n\n");
                    }

                    break;
                case 5:
                    System.out.println("==================CARI BUKU==================\n");
                    System.out.print("Judul \t: ");
                    judul = input.nextLine();
                    perpustakaan.cariItem(judul, "Buku");

                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.print("Pilihan " + pilihan + " tidak tersedia.");
                    input.nextLine();

                    // membersihkan layar console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
            }
        } while (!exit);
    }
}
