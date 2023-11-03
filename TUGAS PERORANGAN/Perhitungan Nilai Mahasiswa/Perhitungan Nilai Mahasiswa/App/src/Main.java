import java.util.Scanner;

class Main {
    public static void main(String[] args){
        String nama;
        String nim;
        double tubes;
        double quiz;
        double tugas;
        double uts;
        double uas;
        Scanner input = new Scanner(System.in);
        App jumlah_nilai = new App();

        System.out.print("Nama: ");
        nama = input.next();

        System.out.print("NIM: ");
        nim = input.next();

        System.out.print("Nilai tugas besar: ");
        tubes = input.nextDouble();

        System.out.print("Nilai quiz: ");
        quiz = input.nextDouble();

        System.out.print("Nilai tugas: ");
        tugas = input.nextDouble();

        System.out.print("Nilai uts: ");
        uts = input.nextDouble();

        System.out.print("Nilai uas: ");
        uas = input.nextDouble();

        double nilai_rata = jumlah_nilai.total_nilai(tubes, quiz, tugas, uts, uas);

        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Nilai Rata-rata mahasiswa adalah " + nilai_rata);

        input.close();
    }
}

