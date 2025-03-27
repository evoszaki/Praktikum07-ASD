import java.util.Scanner;
public class MahasiswaDemo17 {
    public static void main(String[] args) {
        Scanner input17 = new Scanner(System.in);
       
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = input17.nextInt(); 
        input17.nextLine();
        
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
        
        System.out.println("-------------------------------------------------");
        System.out.println("Menggunakan Binary Search");
        System.out.println("-------------------------------------------------");
        double posisi = list.findBinarySearch(cari, 0, jumMhs - 1);
        int pss2 = (int) posisi;
        list.tampilPosisi(cari, pss2);
        list.tampilDataSearch(cari, pss2);
    }
}
