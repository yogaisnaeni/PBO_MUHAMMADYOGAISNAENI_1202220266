class Mahasiswa extends Asrama {
    private String Nama;
    private String Jurusan;
    private int Nim;

    public Mahasiswa(String Nama, String Jurusan, int Nim, int NoKamar, int Lantai) {
        super(NoKamar, Lantai);
        this.Nama = Nama;
        this.Jurusan = Jurusan;
        this.Nim = Nim;
    }

    public String getNama() {
        return Nama;
    }

    public int getNim() {
        return Nim;
    }

    public String getJurusan() {
        return Jurusan;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setNim(int Nim) {
        this.Nim = Nim;
    }

    public void setJurusan(String Jurusan) {
        this.Jurusan = Jurusan;
    }

    public String toString() {
        return "Nama mahasiswa : " + Nama +
                ", Nim mahasiswa : " + Nim +
                ", Jurusan mahasiswa : " + Jurusan +
                ", NoKamar mahasiswa : " + NoKamar +
                ", Lantai :" + Lantai;
    }

}