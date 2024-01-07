package person;

import java.util.Scanner;

import menu.Perpustakaan;

public class Peminjam extends Person {
    private String alamat, tanggal_meminjam, batas_pengembalian, yang_dipinjam;

    public void setPeminjam(String nama, String email, int telepon, String no_peminjam, String alamat,
            String tanggal_meminjam, String batas_pengembalian, String yang_dipinjam) {
        super.setPerson(nama, email, telepon, no_peminjam);
        this.alamat = alamat;
        this.tanggal_meminjam = tanggal_meminjam;
        this.batas_pengembalian = batas_pengembalian;
        this.yang_dipinjam = yang_dipinjam;
    }

    @Override
    public String cetak() {
        return "No Peminjam \t\t: " + super.getUniqueKey() + "\n" + super.cetak() + "Alamat \t\t\t: " + alamat + "\n"
                + "Tanggal Meminjam \t: " + tanggal_meminjam + "\n" + "Batas Pengembalian \t: " + batas_pengembalian
                + "\n" + "Yang Dipinjam \t\t: " + yang_dipinjam + "\n";
    }

    public static void menuPeminjam(Perpustakaan perpustakaan) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean exit = false;
        do {
            Scanner input = new Scanner(System.in);
            int pilihan, telepon;
            String nama, email, no_peminjam, alamat, tanggal_meminjam, batas_pengembalian, yang_dipinjam;
            Peminjam peminjam = new Peminjam();

            System.out.println("==================MENU PEMINJAM==================");
            System.out.println("1. Tambah Peminjam");
            System.out.println("2. Daftar Peminjam");
            System.out.println("3. Hapus Peminjam");
            System.out.println("4. Kembali");

            System.out.print("\nPilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("==================TAMBAH PEMINJAM==================\n");
                    System.out.print("Nama \t\t\t: ");
                    nama = input.nextLine();
                    System.out.print("Email \t\t\t: ");
                    email = input.nextLine();
                    System.out.print("Telepon \t\t: ");
                    telepon = input.nextInt();
                    input.nextLine();
                    System.out.print("No Peminjam \t\t: ");
                    no_peminjam = input.nextLine();
                    System.out.print("Alamat \t\t\t: ");
                    alamat = input.nextLine();
                    System.out.print("Tanggal Meminjam \t: ");
                    tanggal_meminjam = input.nextLine();
                    System.out.print("Batas Pengembalian \t: ");
                    batas_pengembalian = input.nextLine();
                    System.out.print("Yang Dipinjam \t\t: ");
                    yang_dipinjam = input.nextLine();

                    peminjam.setPeminjam(nama, email, telepon, no_peminjam, alamat, tanggal_meminjam,
                            batas_pengembalian, yang_dipinjam);
                    perpustakaan.tambahPerson(peminjam);

                    break;
                case 2:
                    System.out.println("==================DAFTAR PEMINJAM==================\n");
                    perpustakaan.lihatPerson("Peminjam");

                    break;
                case 3:
                    System.out.println("==================HAPUS PEMINJAM==================\n");
                    System.out.print("Masukkan no peminjam\t: ");
                    no_peminjam = input.nextLine();

                    if (perpustakaan.checkUniqueKeyPerson(no_peminjam, "Peminjam")) {
                        perpustakaan.hapusPerson(no_peminjam);
                    } else {
                        System.out.println("Peminjam dengan no peminjam '" + no_peminjam + "' tidak ditemukan.");
                    }

                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        } while (!exit);
    }
}
