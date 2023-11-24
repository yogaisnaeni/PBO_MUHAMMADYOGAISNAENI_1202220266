public class Main {
    public static void main(String[] args) {
        FormulirMahasiswa formulir01 = new FormulirMahasiswa();
        formulir01.cara_bayar();
        formulir01.tata_tertib_acara();
        System.out.println("");
        FormulirDosen formulir02 = new FormulirDosen();
        formulir02.cara_bayar();
        formulir02.tata_tertib_acara();
        System.out.println("");
        FormulirAdmin formulir03 = new FormulirAdmin();
        formulir03.cara_bayar();
        formulir03.tata_tertib_acara();

        ///polymorphism = 
        BaseFormulir formulir = new FormulirDosen();
        BaseFormulir[] listFormulir = new BaseFormulir[5];
        listFormulir[0] = new FormulirAdmin();
        listFormulir[1] = new FormulirDosen();
        listFormulir[2] = new FormulirMahasiswa();

        ((FormulirMahasiswa)listFormulir[2]).nim = (1202220266);
    }
    
}
