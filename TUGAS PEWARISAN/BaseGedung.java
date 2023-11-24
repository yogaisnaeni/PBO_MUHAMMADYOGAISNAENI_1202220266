public abstract class BaseGedung {
    public String nama;
    public String kegunaan;
    public String tangga;
    public String lantai;

    public void bentuk() {
        System.out.println("bentuk gedung secara umum");    
    }

    public abstract void jurusan_gedung();
    
}
