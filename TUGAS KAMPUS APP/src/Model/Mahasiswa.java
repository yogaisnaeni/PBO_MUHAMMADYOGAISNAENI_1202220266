package Model;

public class Mahasiswa {
   private String nim;
   public String getNim() {
       return nim;
   }

   private String nama;
   public String getNama() {
       return nama;
   }

   public void setNama(String nama) {
       this.nama = nama;
   }
   
   private String  idprodi;

   public String getIdProdi() {
       return idprodi;
   }

   public Mahasiswa(String nim, String nama, String prodi) {
       this.nim = nim;
       this.nama = nama;
       this.idprodi = prodi;
   }
}