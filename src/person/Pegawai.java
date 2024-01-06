package person;

import java.util.Scanner;

import menu.Perpustakaan;

public class Pegawai extends Person {
    private int rekening;
    private String tannggal_mulai_kerja;

    public void setPegawai(String nama, String email, int telepon, String nip, int rekening,
            String tannggal_mulai_kerja) {
        super.setPerson(nama, email, telepon, nip);
        this.rekening = rekening;
        this.tannggal_mulai_kerja = tannggal_mulai_kerja;
    }

    // public int getRekening() {
    // return rekening;
    // }

    // public void setRekening(int rekening) {
    // this.rekening = rekening;
    // }

    // public String getTannggal_mulai_kerja() {
    // return tannggal_mulai_kerja;
    // }

    // public void setTannggal_mulai_kerja(String tannggal_mulai_kerja) {
    // this.tannggal_mulai_kerja = tannggal_mulai_kerja;
    // }

    @Override
    public String cetak() {
        return "NIP \t\t\t: " + super.getUniqueKey() + "\n" + super.cetak() + "Rekening \t\t: " + rekening + "\n"
                + "Tanggal Mulai Kerja \t: " + tannggal_mulai_kerja + "\n";
    }

    public static void menuPegawai(Perpustakaan perpustakaan) {
        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        boolean exit = false;
        do {
            Scanner input = new Scanner(System.in);
            int pilihan, telepon, rekening;
            String nama, email, nip, tannggal_mulai_kerja;
            Pegawai pegawai = new Pegawai();

            System.out.println("==================MENU PEGAWAI==================");
            System.out.println("1. Tambah Pegawai");
            System.out.println("2. Daftar Pegawai");
            System.out.println("3. Hapus Pegawai");
            System.out.println("4. Kembali");

            System.out.print("\nPilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("==================TAMBAH PEGAWAI==================\n");
                    System.out.print("Nama \t\t\t: ");
                    nama = input.nextLine();
                    System.out.print("Email \t\t\t: ");
                    email = input.nextLine();
                    System.out.print("Telepon \t\t: ");
                    telepon = input.nextInt();
                    input.nextLine();
                    System.out.print("NIP \t\t\t: ");
                    nip = input.nextLine();
                    System.out.print("Rekening \t\t: ");
                    rekening = input.nextInt();
                    input.nextLine();
                    System.out.print("Tanggal Mulai Kerja \t: ");
                    tannggal_mulai_kerja = input.nextLine();

                    pegawai.setPegawai(nama, email, telepon, nip, rekening, tannggal_mulai_kerja);
                    perpustakaan.tambahPerson(pegawai);

                    break;
                case 2:
                    System.out.println("==================DAFTAR PEGAWAI==================\n");
                    perpustakaan.lihatPerson("Pegawai");
                    break;
                case 3:
                    System.out.println("==================HAPUS PEGAWAI==================\n");
                    System.out.print("Masukkan NIP pegawai yang ingin dihapus: ");
                    nip = input.nextLine();

                    if (perpustakaan.checkUniqueKeyPerson(nip, "Pegawai")) {
                        perpustakaan.hapusPerson(nip);
                    } else {
                        System.out.println("Pegawai dengan NIP '" + nip + "' tidak ditemukan.");
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
