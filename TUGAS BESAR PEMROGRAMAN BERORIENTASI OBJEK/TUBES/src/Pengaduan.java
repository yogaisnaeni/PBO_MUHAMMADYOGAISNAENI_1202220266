public class Pengaduan {
    private String deskripsi;
    private boolean telahDitanggapi;
    private String kodePengaduan;

    public Pengaduan(String deskripsi, String kodePengaduan) {
        this.deskripsi = deskripsi;
        this.telahDitanggapi = false;
        this.kodePengaduan = kodePengaduan;
    }

    public String tanggapiPengaduan() {
        String status;
        if (!telahDitanggapi) {
            this.telahDitanggapi = true;
            System.out.println("Pengaduan telah ditanggapi!");
            status = "sudah ditanggapi";
        } else {
            status = "belum ditanggapi";
        }
        return status;
    }

    public String getKodePengaduan() {
        return kodePengaduan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String toString() {
        String status = telahDitanggapi ? "sudah ditanggapi" : "belum ditanggapi";
        return "Kode pengaduan : " + kodePengaduan +
                ", keluhan pengaduan : " + deskripsi +
                ", status keluhan : " + status;
    }
}
