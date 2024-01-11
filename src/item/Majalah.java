package item;

import menu.Perpustakaan;
import java.util.Scanner;

public class Majalah extends Item {
    private String edisi, tema;

    public void setMajalah(String judul, String penerbit, int tahunTerbit, String issn, String edisi,
            String tema) {
        super.setItem(judul, penerbit, tahunTerbit, issn);
        this.edisi = edisi;
        this.tema = tema;
    }

    @Override
    public String cetak() {
        return "ISSN \t\t: " + super.getUniqueKey() + "\n" + super.cetak() + "Edisi \t\t: " + edisi + "\n"
                + "Tema \t\t: " + tema + "\n";
    }

    public static void menuMajalah(Perpustakaan perpustakaan) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean exit = false;
        do {
            Scanner input = new Scanner(System.in);
            int pilihan, tahunTerbit;
            String issn, judul, penerbit, edisi, tema;
            Majalah majalah = new Majalah();

            System.out.println("==================MENU MAJALAH==================");
            System.out.println("1. Tambah Majalah");
            System.out.println("2. Lihat Majalah");
            System.out.println("3. Update Majalah");
            System.out.println("4. Hapus Majalah");
            System.out.println("5. Cari Majalah");
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
                        System.out.println("==================TAMBAH MAJALAH==================");
                        System.out.print("ISSN \t\t: ");
                        issn = input.nextLine();
                        System.out.print("Judul \t\t: ");
                        judul = input.nextLine();
                        System.out.print("Penerbit \t: ");
                        penerbit = input.nextLine();
                        System.out.print("Tahun Terbit \t: ");
                        tahunTerbit = input.nextInt();
                        input.nextLine();
                        System.out.print("Edisi \t\t: ");
                        edisi = input.nextLine();
                        System.out.print("Tema \t\t: ");
                        tema = input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Inputan tidak valid.");
                        input.nextLine();
                        break;
                    }

                    if (!perpustakaan.checkUniqueKey(issn, "Majalah")) {
                        majalah.setMajalah(judul, penerbit, tahunTerbit, issn, edisi, tema);
                        perpustakaan.tambahItem(majalah);
                    } else {
                        System.out.println("Majalah dengan ISSN " + issn + " sudah ada.");
                    }

                    break;
                case 2:
                    System.out.println("==================LIHAT MAJALAH==================");
                    perpustakaan.lihatKoleksi("Majalah");

                    break;
                case 3:
                    System.out.println("==================UPDATE MAJALAH==================");
                    System.out.print("ISSN \t\t: ");
                    issn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(issn, "Majalah")) {
                        try {
                            System.out.print("\nJudul \t\t: ");
                            judul = input.nextLine();
                            System.out.print("Penerbit \t: ");
                            penerbit = input.nextLine();
                            System.out.print("Tahun Terbit \t: ");
                            tahunTerbit = input.nextInt();
                            input.nextLine();
                            System.out.print("Edisi \t\t: ");
                            edisi = input.nextLine();
                            System.out.print("Tema \t\t: ");
                            tema = input.nextLine();
                        } catch (Exception e) {
                            System.out.println("Inputan tidak valid.");
                            input.nextLine();
                            break;
                        }

                        majalah.setMajalah(judul, penerbit, tahunTerbit, issn, edisi, tema);
                        perpustakaan.updateItem(issn, majalah);
                    } else {
                        System.out.println("Majalah dengan ISSN " + issn + " tidak ditemukan.");
                    }

                    break;
                case 4:
                    System.out.println("==================HAPUS MAJALAH==================");
                    System.out.print("ISSN \t: ");
                    issn = input.nextLine();

                    if (perpustakaan.checkUniqueKey(issn, "Majalah")) {
                        perpustakaan.hapusItem(issn);
                    } else {
                        System.out.println("Majalah dengan ISSN " + issn + " tidak ditemukan.");
                    }

                    break;
                case 5:
                    System.out.println("==================CARI MAJALAH==================");
                    System.out.print("Judul \t: ");
                    judul = input.nextLine();

                    perpustakaan.cariItem(judul, "Majalah");

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
