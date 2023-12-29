import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    public List<Mahasiswa> listMahasiswa;
    public List<Pengaduan> listPengaduan;
    public List<Asrama> listAsrama;

    public Scanner scanner;

    public Main() {
        this.listMahasiswa = new ArrayList<>();
        this.listPengaduan = new ArrayList<>();
        this.listAsrama = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        try {
            System.out.println("===== Menu Asrama =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Edit Mahasiswa");
            System.out.println("4. Cari Mahasiswa");
            System.out.println("5. Tampilkan Daftar Mahasiswa");
            System.out.println("6. Ajukan Pengaduan");
            System.out.println("7. Tampilkan Daftar Pengaduan");
            System.out.println("8. Berikan Tanggapan Keluhan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    hapusMahasiswa();
                    break;
                case 3:
                    editMahasiswa();
                    break;
                case 4:
                    cariMahasiswa();
                    break;
                case 5:
                    tampilkanDaftarMahasiswa();
                    break;
                case 6:
                    ajukanPengaduan();
                    break;
                case 7:
                    tampilkanDaftarPengaduan();
                    break;
                case 8:
                    berikanTanggapan();
                    break;
                case 0:
                    System.out.println("Keluar dari menu asrama. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    showMenu();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Masukkan angka sebagai pilihan. Silakan coba lagi.");
            scanner.nextLine();
            showMenu();
        }
    }

    public void tambahMahasiswa() {
        System.out.print("Masukan nama mahasiswa: ");
        String Nama = scanner.nextLine();
        System.out.print("Masukan jurusan mahasiswa: ");
        String Jurusan = scanner.nextLine();

        int Nim;
        while (true) {
            System.out.print("Masukan nim mahasiswa: ");
            Nim = scanner.nextInt();

            boolean nim1 = false;
            for (Mahasiswa mahasiswa : listMahasiswa) {
                if (mahasiswa.getNim() == Nim) {
                    nim1 = true;
                    break;
                }
            }

            if (nim1) {
                System.out.println("NIM sudah ada. Mohon masukkan NIM yang berbeda.");
            } else {
                break;
            }
        }

        System.out.print("Masukan nomor kamar mahasiswa: ");
        int NoKamar = scanner.nextInt();
        System.out.print("Masukan lantai kamar: ");
        int Lantai = scanner.nextInt();

        Mahasiswa mahasiswa = new Mahasiswa(Nama, Jurusan, Nim, NoKamar, Lantai);
        listMahasiswa.add(mahasiswa);

        Asrama asrama = new Asrama(NoKamar, Lantai);
        listAsrama.add(asrama);

        System.out.println("Data mahasiswa telah ditambahkan!!!");
        System.out.println("");
        showMenu();
    }

    public void hapusMahasiswa() {
        System.out.print("Pilih mahasiswa yang ingin dihapus (masukan Nim mahasiswa): ");
        int Nim = scanner.nextInt();
        Mahasiswa mahasiswaToRemove = null;
        try {
            for (Mahasiswa mahasiswa : listMahasiswa) {
                if (mahasiswa.getNim() == Nim) {
                    mahasiswaToRemove = mahasiswa;
                    break;
                }
            }
            if (mahasiswaToRemove != null) {
                listMahasiswa.remove(mahasiswaToRemove);
                System.out.println("mahasiswa telah dihapus");
            } else {
                System.out.println("mahasiswa tidak ditemukan");
            }
        } catch (InputMismatchException e) {
            System.out.println("Masukan tidak sesuai dengan tipe data yang diharapkan.");
        }
        System.out.println("");
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void editMahasiswa() {
        System.out.print("Masukkan Nim mahasiswa yang akan diedit: ");
        int nimToEdit = scanner.nextInt();
        scanner.nextLine();

        Mahasiswa mahasiswaToEdit = null;
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNim() == nimToEdit) {
                mahasiswaToEdit = mahasiswa;
                break;
            }
        }

        if (mahasiswaToEdit != null) {
            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();
            System.out.print("Masukkan jurusan baru: ");
            String jurusanBaru = scanner.nextLine();
            System.out.print("Masukkan nomor kamar baru: ");
            int noKamarBaru = scanner.nextInt();
            System.out.print("Masukan lantai kamar baru: ");
            int Lantai = scanner.nextInt();

            mahasiswaToEdit.setNama(namaBaru);
            mahasiswaToEdit.setJurusan(jurusanBaru);
            mahasiswaToEdit.setNoKamar(noKamarBaru);
            mahasiswaToEdit.setLantai(Lantai);

            System.out.println("Data mahasiswa berhasil diubah!");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void cariMahasiswa() {
        System.out.print("Masukkan Nim mahasiswa yang akan dicari: ");
        int Nim = scanner.nextInt();
        scanner.nextLine();

        Mahasiswa mahasiswa = null;
        for (Mahasiswa mhs : listMahasiswa) {
            if (mhs.getNim() == Nim) {
                mahasiswa = mhs;
                break;
            }
        }

        if (mahasiswa != null) {
            System.out.println("Mahasiswa ditemukan:");
            System.out.println("Nim mahasiswa: " + mahasiswa.getNim());
            System.out.println("Nama Mahasiswa: " + mahasiswa.getNama());
            System.out.println("Jurusan Mahasiswa: " + mahasiswa.getJurusan());
            System.out.println("Nomor Kamar Mahasiswa " + mahasiswa.getNoKamar());
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void tampilkanDaftarMahasiswa() {
        Collections.sort(listMahasiswa, (mahasiswa1, mahasiswa2) -> Integer.compare(mahasiswa1.getNim(), mahasiswa2.getNim()));
        System.out.println("Daftar Mahasiswa :");
        for (Mahasiswa mahasiswa : listMahasiswa) {
            System.out.println(mahasiswa);
        }
        System.out.println("");
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void ajukanPengaduan() {
        System.out.print("masukan nim yang ingin melakukan pengajuan: ");
        int Nim = scanner.nextInt();
        scanner.nextLine();
        Mahasiswa mahasiswa = null;
        for (Mahasiswa mahasiswa1 : listMahasiswa) {
            if (mahasiswa1.getNim() == Nim) {
                mahasiswa = mahasiswa1;
                break;
            }
        }
        if (mahasiswa != null) {
            System.out.println("mahasiswa ditemukan");
            System.out.println(mahasiswa);
            System.out.print("masukan kode keluhan: ");
            String kodePengaduan = scanner.nextLine();
            System.out.print("masukan keluhan mahasiswa asrama: ");
            String keluhan = scanner.nextLine();
            Pengaduan keluhan1 = new Pengaduan(keluhan, kodePengaduan);
            keluhan1.toString();
            listPengaduan.add(keluhan1);
        } else {
            System.out.println("mahasiswa tidak ditemukan");
        }

        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void tampilkanDaftarPengaduan() {
        System.out.println("daftar pengaduan");
        for (Pengaduan keluhanmahasiswa : listPengaduan) {
            System.out.println(keluhanmahasiswa);
        }
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }

    public void berikanTanggapan() {
        System.out.print("masukan kode pengaduan yang ingin ditanggapi: ");
        String kodePengaduan = scanner.nextLine();
        Pengaduan pengaduan = null;

        for (Pengaduan pengaduan1 : listPengaduan) {
            if (pengaduan1.getKodePengaduan().equals(kodePengaduan)) {
                pengaduan = pengaduan1;
                System.out.println("pengaduan ditemukan");
                System.out.println("kode pengaduan: " + pengaduan.getKodePengaduan());
                System.out.print("tekan enter untuk menanggapi pengaduan ... ");
                String pilihan = scanner.nextLine();
                if (pilihan.equals(pilihan)) {
                    pengaduan.tanggapiPengaduan();
                    break;

                } else {
                    System.out.println("status tidak berubah");
                }

            } else {
                System.out.println("kode tidak ditemukan");
            }
        }
        System.out.println("\nTekan enter untuk melanjutkan ...");
        scanner.nextLine();
        showMenu();
    }
}
