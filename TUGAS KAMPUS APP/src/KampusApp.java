import java.util.Scanner;
import Model.Prodi;
import Model.Mahasiswa;
import repository.Database;

public class KampusApp {
    public static void main(String[] arg) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu();
    }

    private Scanner scanner;
    private Database db;

    public KampusApp() {
        scanner = new Scanner(System.in);
        db = new Database();
    }

    public void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu:");
        System.out.println("1 -> Tambah Data Mahasiswa");
        System.out.println("2 -> Ubah Data Mahasiswa");
        System.out.println("3 -> Hapus Data Mahasiswa");
        System.out.println("4 -> Cari Data Mahasiswa");
        System.out.println("5 -> Tambah Prodi");
        System.out.println("6 -> Hapus Prodi");
        System.out.println("0 -> Keluar Aplikasi");
        System.out.print("Silahkan masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt();
        scanner.nextLine();

        switch (menuYangDipilih) {
            case 1:
                menuTambah();
                break;

            case 2:
                menuUbah();
                break;

            case 3:
                menuHapus();
                break;

            case 4:
                menuCari();
                break;

            case 5:
                menuTambahProdi();
                break;

            case 6:
                menuHapusProdi();
                break;

            default: {
                System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
                System.exit(0);
            }
                break;
        }
        scanner.close();
    }

    public void menuTambah() {
        System.out.println("----- Menu Tambah Mahasiswa -----");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Id Prodi: ");
        String idProdi = scanner.nextLine();

        Prodi prodi = db.prodiTbl.getProdiById(idProdi);

        if (prodi == null) {
            System.out.println("* Prodi dengan ID " + idProdi + " tidak ditemukan *");
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, idProdi);

            db.mahasiswaTbl.create(mahasiswa);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil ditambahkan");
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbah() {
        System.out.println("----- Menu Ubah Data Mahasiswa -----");
        System.out.print("Masukan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
        System.out.print("Masukan NIM: ");
        String nimBaru = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.println("Masukan Id Prodi: ");
        String idProdi = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, idProdi);
        db.mahasiswaTbl.update(nimLama, mahasiswa);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuCari() {
        System.out.println("----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa mahasiswa = db.mahasiswaTbl.getMahasiswaByNim(nim);

        if (mahasiswa == null) {
            System.out.println("* NIM tidak ditemukan *");
        } else {
            Prodi prodi = db.prodiTbl.getProdiById(mahasiswa.getIdProdi());

            if (prodi == null) {
                System.out.println("* Prodi tidak ditemukan *");
            } else {
                System.out.println("* NIM: " + mahasiswa.getNim() + " *");
                System.out.println("* Nama: " + mahasiswa.getNama() + " *");
                System.out.println("* Prodi: " + prodi.getNamaProdi() + " *");
            }
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapus() {
        System.out.println("----- Menu Hapus Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        db.mahasiswaTbl.delete(nim);
        System.out.println("NIM" + nim + "Berhasil dihapus");
        scanner.nextLine();
        showMenu();
    }

    public void menuTambahProdi() {
        System.out.println("----- Menu Tambah Data Prodi -----");
        System.out.print("Masukkan Id Prodi: ");
        String idProdi = scanner.nextLine();
        System.out.print("Masukkan Nama Prodi: ");
        String namaProdi = scanner.nextLine();

        Prodi prodi = new Prodi(idProdi, namaProdi);

        db.prodiTbl.create(prodi);
        System.out.println("Prodi dengan ID " + idProdi + " berhasil ditambahkan");

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapusProdi() {
        System.out.println("----- Menu Hapus Data Prodi -----");
        System.out.print("Masukan Id Prodi: ");
        String idProdi = scanner.nextLine();

        Prodi prodiToDelete = db.prodiTbl.getProdiById(idProdi);

        if (prodiToDelete == null) {
            System.out.println("* Prodi dengan ID " + idProdi + " tidak ditemukan *");
        } else {
            db.prodiTbl.delete(idProdi);
            System.out.println("Prodi dengan ID " + idProdi + " berhasil dihapus");
        }

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

}
