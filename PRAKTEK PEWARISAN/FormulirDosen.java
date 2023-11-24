public class FormulirDosen extends BaseFormulir{
    public String kode_dosen;
    public String semester;

    @Override
    public void tata_tertib_acara() {
        System.out.println("tata tertib acara dosen");
    }
    @Override
    public void cara_bayar() {
        System.out.println("dosen dipotong dari gaji");
        super.cara_bayar();
    }
    
}
