package item;

import menu.Perpustakaan;
import java.util.Scanner;

public class Komik extends Item {
    private String pengarang, illustrator, genre;

    public void setKomik(String judul, String penerbit, int tahunTerbit, String isbn, String pengarang,
            String illustrator, String genre) {
        super.setItem(judul, penerbit, tahunTerbit, isbn);
        this.pengarang = pengarang;
        this.illustrator = illustrator;
        this.genre = genre;
    }

    @Override
    public String cetak() {
        return "ISBN \t\t: " + super.getUniqueKey() + "\n" + super.cetak() + "Pengarang \t: " + pengarang + "\n"
                + "Illustrator \t: " + illustrator + "\n" + "Genre \t\t: " + genre + "\n";
    }

    public static void menuKomik(Perpustakaan perpustakaan) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean exit = false;
        do {
            Scanner input = new Scanner(System.in);
            int pilihan, tahunTerbit;
            String isbn, judul, penerbit, pengarang, illustrator, genre;
            Komik komik = new Komik();

            System.out.println("==================MENU KOMIK==================");
            System.out.println("1. Tambah Komik");
            System.out.println("2. Lihat Komik");
            System.out.println("3. Update Komik");
            System.out.println("4. Hapus Komik");
            System.out.println("5. Cari Komik");
            System.out.println("6. Kembali");

            try {
                System.out.print("\nPilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Inputan tidak valid.");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    try {
                        System.out.println("==================TAMBAH KOMIK==================");
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
                        System.out.print("Illustrator \t: ");
                        illustrator = input.nextLine();
                        System.out.print("Genre \t\t: ");
                        genre = input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Inputan tidak valid.");
                        input.nextLine();
                        break;
                    }

                    if (!perpustakaan.checkUniqueKey(isbn, "Komik")) {
                        komik.setKomik(judul, penerbit, tahunTerbit, isbn, pengarang, illustrator, genre);
                        perpustakaan.tambahItem(komik);
                    } else {
                        System.out.println("Komik dengan ISBN " + isbn + " sudah ada.");
                    }

                    break;
                case 2:
                    System.out.println("==================LIHAT KOMIK==================");
                    perpustakaan.lihatKoleksi("Komik");

                    break;
                case 3:
                    System.out.println("==================UPDATE KOMIK==================");
                    System.out.print("ISBN \t\t: ");
                    isbn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(isbn, "Komik")) {
                        try {
                            System.out.print("\nJudul \t\t: ");
                            judul = input.nextLine();
                            System.out.print("Penerbit \t: ");
                            penerbit = input.nextLine();
                            System.out.print("Tahun Terbit \t: ");
                            tahunTerbit = input.nextInt();
                            input.nextLine();
                            System.out.print("Pengarang \t: ");
                            pengarang = input.nextLine();
                            System.out.print("Illustrator \t: ");
                            illustrator = input.nextLine();
                            System.out.print("Genre \t\t: ");
                            genre = input.nextLine();
                        } catch (Exception e) {
                            System.out.println("Inputan tidak valid.");
                            input.nextLine();
                            break;
                        }

                        komik.setKomik(judul, penerbit, tahunTerbit, isbn, pengarang, illustrator, genre);
                        perpustakaan.updateItem(isbn, komik);
                    } else {
                        System.out.println("Komik dengan ISBN " + isbn + " tidak ditemukan.");
                    }

                    break;
                case 4:
                    System.out.println("==================HAPUS KOMIK==================");
                    System.out.print("ISBN \t: ");
                    isbn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(isbn, "Komik")) {
                        perpustakaan.hapusItem(isbn);
                    } else {
                        System.out.println("Komik dengan ISBN " + isbn + " tidak ditemukan.");
                    }

                    break;
                case 5:
                    System.out.println("==================CARI KOMIK==================");
                    System.out.print("Judul \t: ");
                    judul = input.nextLine();

                    perpustakaan.cariItem(judul, "Komik");

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
