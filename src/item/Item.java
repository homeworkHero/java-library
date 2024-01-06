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

    // public void setJudul(String judul) {
    // this.judul = judul;
    // }

    // public String getPenerbit() {
    // return penerbit;
    // }

    // public void setPenerbit(String penerbit) {
    // this.penerbit = penerbit;
    // }

    // public int getTahunTerbit() {
    // return tahunTerbit;
    // }

    // public void setTahunTerbit(int tahunTerbit) {
    // this.tahunTerbit = tahunTerbit;
    // }

    public String getUniqueKey() {
        return uniqueKey;
    }

    // public void setUniqueKey(String uniqueKey) {
    // this.uniqueKey = uniqueKey;
    // }

    public String cetak() {
        return "Judul \t\t: " + judul + "\n" +
                "Penerbit \t: " + penerbit + "\n" +
                "Tahun Terbit \t: " + tahunTerbit + "\n";
    }
}