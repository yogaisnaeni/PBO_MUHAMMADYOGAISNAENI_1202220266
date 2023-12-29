public class Asrama {
    protected int NoKamar;
    protected int Lantai;

    public Asrama(int NoKamar, int Lantai) {
        this.NoKamar = NoKamar;
        this.Lantai = Lantai;
    }

    public int getNoKamar() {
        return NoKamar;
    }

    public int getLantai() {
        return Lantai;
    }

    public void setLantai(int lantai) {
        Lantai = lantai;
    }

    public void setNoKamar(int noKamar) {
        NoKamar = noKamar;
    }
}