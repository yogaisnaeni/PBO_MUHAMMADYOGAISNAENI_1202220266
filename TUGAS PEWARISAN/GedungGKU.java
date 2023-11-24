public class GedungGKU extends BaseGedung{
    public String Kapasitas;

    @Override
    public void jurusan_gedung() {
        System.out.println("digunakan oleh seluruh jurusan di telkom");
    }

    @Override
    public void bentuk() {
        System.out.println("seperti tokong nanas");
        super.bentuk();
    }
}