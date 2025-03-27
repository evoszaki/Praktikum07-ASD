import java.util.Scanner;
public class MahasiswaDemo17 {
    public static void main(String[] args) {
        Scanner input17 = new Scanner(System.in);
        int jumMhs = 5;

        MahasiswaBerprestasi17 list = new MahasiswaBerprestasi17(jumMhs);

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1) + ":");
            System.out.print("NIM: ");
            String nim = input17.nextLine();
            System.out.print("Nama: ");
            String nama = input17.nextLine();
            System.out.print("Kelas: ");
            String kelas = input17.nextLine();
            System.out.print("IPK: ");
            double ipk = input17.nextDouble();
            System.out.println("-----------------------");
            input17.nextLine(); 

            Mahasiswa17 mhs = new Mahasiswa17(nim, nama, kelas, ipk);
            list.tambah(mhs);
        }

        list.tampil();
        //melakukan pencarian data sequential
        System.out.println("-------------------------------------------------");
        System.out.println("Pencarian Data");
        System.out.println("-------------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        System.out.print("IPK: ");
        double cari = input17.nextDouble();
        
        System.out.println("Menggunakan Sequential Searching");
        double posisi = list.sequentialSearching(cari);
        int pss = (int) posisi;
        list.tampilPosisi(cari, pss);
        list.tampilDataSearch(cari, pss);
    }
}
