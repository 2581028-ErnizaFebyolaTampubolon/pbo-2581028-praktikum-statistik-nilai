import java.util.ArrayList;
import java.util.Collections; //untuk list, dipakai untuk sort (mengurutkan).
import java.util.Locale; //format bahasa/negara, dipakai agar desimal menjadi koma.
import java.util.Scanner; //membaca hasil ketikan dari keyboard.

public class StatistikNilai {

    static final int SELESAI = -1; //ketik -1 kalau sudah selesai

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>(); //list kosong untuk menyimpan nilai. Isinya harus Integer (objek), bukan int.

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        //Tahap 1: baca nilai dengan do-while + sentinel
        int nilai = 0; //menampung ketikan terakhir (diberi nilai awal agar aman dipakai di while)
        do { //do-while: isi loop jalan minimal sekali, kondisi dicek di akhir
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");

            // Tolak ketikan yang bukan bilangan bulat (huruf, desimal, dll)
            if (!input.hasNextInt()) {
                System.out.println("  Ditolak, masukkan angka bulat");
                input.next(); //buang ketikan yang salah supaya tidak berulang terus
                continue;
            }
            nilai = input.nextInt();

            // Nilai di luar 0-100 ditolak dengan continue (tanpa add)
            if (nilai < 0 || nilai > 100) {
                if (nilai != SELESAI) {
                    System.out.println("  Ditolak, harus 0-100");
                }
                continue; // di do-while, lompat ke pengecekan sentinel
            }
            daftar.add(nilai); //nilai sah, simpan ke daftar
        } while (nilai != SELESAI); //ulangi selama yang diketik bukan -1

        System.out.println();

        // Kasus tidak ada nilai sah sama sekali
        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukkan.");
            input.close();
            return; //hentikan main, kode di bawah tidak dijalankan
        }

        int jumlah = 0; //penjumlahan mulai dari 0
        // Tertinggi/terendah dimulai dari nilai PERTAMA di daftar (bukan 0 / 100):
        // kalau tertinggi dimulai dari 0 atau terendah dari 100, hasilnya bisa salah
        // untuk daftar tertentu (mis. semua nilai 0 atau semua nilai 100),
        // sedangkan nilai pertama pasti anggota daftar sehingga aman sebagai awal.
        int tertinggi = daftar.get(0); //get(0) = ambil elemen pertama (index dimulai dari 0)
        int terendah = daftar.get(0); //awal terendah juga nilai pertama

        for (int n : daftar) { //for-each: n = tiap nilai di daftar, satu per satu
            jumlah += n;
            if (n > tertinggi) tertinggi = n;
            if (n < terendah) terendah = n;
        }
        double rataRata = (double) jumlah / daftar.size(); //(double) agar dibagi desimal, bukan bulat

        // 3: putaran kedua, hitung yang di atas rata-rata
        int diAtasRata = 0;
        for (int n : daftar) {
            if (n > rataRata) diAtasRata++;
        }

        input.close();
    }
}