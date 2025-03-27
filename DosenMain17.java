import java.util.Scanner;
public class DosenMain17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen17 daftarDosen = new DataDosen17();
        int pilihan;

        do {
            System.out.println("\n==== MENU DATA DOSEN ====");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampilkan Data Dosen");
            System.out.println("3. Sorting ASC (Usia termuda ke tertua - Bubble Sort)");
            System.out.println("4. Sorting DSC (Usia tertua ke termuda - Selection Sort)");
            System.out.println("5. Sorting DSC (Usia tertua ke termuda - Insertion Sort)");
            System.out.println("6. Pencarian Data (Sequential Search - Nama)");
            System.out.println("7. Pencarian Data (Binary Search - Usia)");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan jenis kelamin (true = Laki-laki, false = Perempuan): ");
                    boolean jk = sc.nextBoolean();
                    System.out.print("Masukkan usia: ");
                    int usia = sc.nextInt();
                    sc.nextLine();

                    Dosen17 dsn = new Dosen17(kode, nama, jk, usia);
                    daftarDosen.tambah(dsn);
                    break;

                case 2:
                    System.out.println("\nData Dosen:");
                    daftarDosen.tampil();
                    break;

                case 3:
                    daftarDosen.sortingASC();
                    break;

                case 4:
                    daftarDosen.sortingDSC();
                    break;

                case 5:
                    daftarDosen.insertionSort();
                    break;

                case 6:
                    System.out.print("Masukkan nama dosen yang dicari: ");
                    String cariNama = sc.nextLine();
                    daftarDosen.pencarianDataSequential(cariNama);
                    break;

                case 7:
                    System.out.print("Masukkan usia dosen yang dicari: ");
                    int cariUsia = sc.nextInt();
                    daftarDosen.pencarianDataBinary(cariUsia, 0, daftarDosen.idx - 1);
                    break;

                case 8:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 8);

        sc.close();
    }
}
