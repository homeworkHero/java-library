package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import item.Item;
import person.Person;

public class Perpustakaan {
    private List<Item> daftarItem = new ArrayList<>();
    private List<Person> daftarPerson = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void tambahItem(Item item) {
        daftarItem.add(item);
        System.out.print("\nItem berhasil ditambahkan.");
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void lihatKoleksi(String koleksi) {
        for (Item item : daftarItem) {
            if (item.getClass().getSimpleName().equals(koleksi)) {
                System.out.println(item.cetak());
            } else if (koleksi.equals("semua")) {
                System.out.println(item.cetak());
            }
        }
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean checkUniqueKey(String uniqueKey, String koleksi) {
        for (Item item : daftarItem) {
            if (item.getUniqueKey().equals(uniqueKey) && item.getClass().getSimpleName().equals(koleksi)) {
                return true;
            }
        }
        return false;
    }

    public void updateItem(String uniqueKey, Item newItem) {
        for (Item item : daftarItem) {
            if (item.getUniqueKey().equals(uniqueKey)) {
                daftarItem.set(daftarItem.indexOf(item), newItem);
                System.out.print("\nItem berhasil diupdate.");
            }
        }
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void hapusItem(String uniqueKey) {
        // for(Item item : daftarItem) {
        // if(item.getUniqueKey().equals(uniqueKey)) {
        // daftarItem.remove(item);
        // break;
        // }
        // }

        daftarItem.removeIf(item -> item.getUniqueKey().equals(uniqueKey));
        System.out.print("\nItem berhasil dihapus.");
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void cariItem(String judul, String koleksi) {
        List<Item> hasilPencarian = new ArrayList<>();
        for (Item item : daftarItem) {
            if (item.getJudul().toLowerCase().contains(judul.toLowerCase())
                    && item.getClass().getSimpleName().equals(koleksi)) {
                hasilPencarian.add(item);
            } else if (koleksi.equals("semua")) {
                if (item.getJudul().toLowerCase().contains(judul.toLowerCase())) {
                    hasilPencarian.add(item);
                }
            }
        }

        if (!hasilPencarian.isEmpty()) {
            System.out.println("Hasil Pencarian untuk judul '" + judul + "':");
            for (Item item : hasilPencarian) {
                System.out.println(item.cetak());
                System.out.println();
            }
        } else {
            System.out.println("Item dengan judul '" + judul + "' tidak ditemukan.");
        }

        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void tambahPerson(Person person) {
        daftarPerson.add(person);
        System.out.print("\nPerson berhasil ditambahkan.");
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void lihatPerson(String type) {
        for (Person person : daftarPerson) {
            if (person.getClass().getSimpleName().equals(type)) {
                System.out.println(person.cetak());
            } else if (type.equals("semua")) {
                System.out.println(person.cetak());
            }
        }
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean checkUniqueKeyPerson(String uniqueKey, String type) {
        for (Person person : daftarPerson) {
            if (person.getUniqueKey().equals(uniqueKey) && person.getClass().getSimpleName().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public void hapusPerson(String uniqueKey) {
        daftarPerson.removeIf(person -> person.getUniqueKey().equals(uniqueKey));
        System.out.print("\nPerson berhasil dihapus.");
        scanner.nextLine();

        // membersihkan layar console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
