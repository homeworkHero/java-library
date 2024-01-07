package item;

public class Item {
    private String judul, penerbit, uniqueKey;
    private int tahunTerbit;

    public void setItem(String judul, String penerbit, int tahunTerbit, String uniqueKey) {
        this.judul = judul;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.uniqueKey = uniqueKey;
    }

    public String getJudul() {
        return judul;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public String cetak() {
        return "Judul \t\t: " + judul + "\n" +
                "Penerbit \t: " + penerbit + "\n" +
                "Tahun Terbit \t: " + tahunTerbit + "\n";
    }
}