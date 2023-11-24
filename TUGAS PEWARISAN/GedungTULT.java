public class GedungTULT extends BaseGedung{
    public int jumlah_lantai;

    @Override
    public void jurusan_gedung() {
        System.out.println("digunakan oleh FRI, FTE dan Informatika");
    }
    @Override
    public void bentuk() {
        System.out.println("lebih besar dan baru dari gedung lain");
        super.bentuk();
    }
}
