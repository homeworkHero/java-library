package person;

public class Person {
    private String nama, email, unique_key;
    private int telepon;

    public void setPerson(String nama, String email, int telepon, String unique_key) {
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.unique_key = unique_key;
    }

    public String getUniqueKey() {
        return unique_key;
    }

    public String cetak() {
        return "Nama \t\t\t: " + nama + "\n" +
                "Email \t\t\t: " + email + "\n" +
                "Telepon \t\t: " + telepon + "\n";
    }
}
