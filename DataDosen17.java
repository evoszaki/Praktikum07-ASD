public class DataDosen17 {
    public Dosen17[] dataDosen17 = new Dosen17[10];
    public int idx = 0;

    public void tambah(Dosen17 dsn) {
        if (idx < dataDosen17.length) {
            dataDosen17[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    public void tampil() {
        if (idx == 0) {
            System.out.println("Belum ada data dosen.");
            return;
        }
        for (int i = 0; i < idx; i++) {
            dataDosen17[i].tampil();
        }
    }

    public void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (dataDosen17[j].usia > dataDosen17[j + 1].usia) {
                    Dosen17 temp = dataDosen17[j];
                    dataDosen17[j] = dataDosen17[j + 1];
                    dataDosen17[j + 1] = temp;
                }
            }
        }
        System.out.println("Data telah diurutkan secara ascending berdasarkan usia.");
    }

    public void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen17[j].usia > dataDosen17[maxIdx].usia) {
                    maxIdx = j;
                }
            }
            Dosen17 temp = dataDosen17[maxIdx];
            dataDosen17[maxIdx] = dataDosen17[i];
            dataDosen17[i] = temp;
        }
        System.out.println("Data telah diurutkan secara descending berdasarkan usia.");
    }

    public void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Dosen17 temp = dataDosen17[i];
            int j = i - 1;
            while (j >= 0 && dataDosen17[j].usia < temp.usia) {
                dataDosen17[j + 1] = dataDosen17[j];
                j--;
            }
            dataDosen17[j + 1] = temp;
        }
        System.out.println("Data telah diurutkan menggunakan insertion sort (descending usia).");
    }

    // Pencarian Data Sequential berdasarkan Nama
    public void pencarianDataSequential(String nama) {
        boolean found = false;
        int count = 0;
        for (int i = 0; i < idx; i++) {
            if (dataDosen17[i].nama.equalsIgnoreCase(nama)) {
                dataDosen17[i].tampil();
                found = true;
                count++;
            }
        }
        if (!found) {
            System.out.println("Data dosen dengan nama \"" + nama + "\" tidak ditemukan.");
        } else if (count > 1) {
            System.out.println("⚠ Peringatan: Ada lebih dari satu dosen dengan nama \"" + nama + "\".");
        }
    }

    // Pencarian Data Binary berdasarkan Usia 
    public void pencarianDataBinary(int usia, int left, int right) {
        sortingASC(); // Binary search hanya bisa dilakukan pada data yang terurut
        int mid;
        boolean found = false;
        int firstIndex = -1, lastIndex = -1;

        // Binary search utama untuk menemukan satu data
        while (right >= left) {
            mid = (left + right) / 2;
            if (dataDosen17[mid].usia == usia) {
                found = true;
                firstIndex = mid;
                lastIndex = mid;
                
                // Mencari semua data yang sama di kiri
                while (firstIndex > 0 && dataDosen17[firstIndex - 1].usia == usia) {
                    firstIndex--;
                }

                // Mencari semua data yang sama di kanan
                while (lastIndex < idx - 1 && dataDosen17[lastIndex + 1].usia == usia) {
                    lastIndex++;
                }

                // Menampilkan semua data dengan usia yang sama
                System.out.println("Data dosen dengan usia " + usia + " ditemukan:");
                for (int i = firstIndex; i <= lastIndex; i++) {
                    dataDosen17[i].tampil();
                }

                // Peringatan jika lebih dari satu data ditemukan
                if (lastIndex - firstIndex > 0) {
                    System.out.println("⚠ Peringatan: Ada lebih dari satu dosen dengan usia " + usia + ".");
                }
                return;
            } else if (dataDosen17[mid].usia > usia) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (!found) {
            System.out.println("Data dosen dengan usia " + usia + " tidak ditemukan.");
        }
    }
}
