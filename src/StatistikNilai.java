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

        //Tahap 1: baca nilai dengan do-while + sentinel
        int nilai; //menampung ketikan terakhir
        do { //do-while: isi loop jalan minimal sekali, kondisi dicek di akhir
            // Nomor prompt diambil dari size() + 1, bukan variabel pencacah
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : "); //list kosong -> size() = 0 -> tampil "Nilai ke-1"
            nilai = input.nextInt(); //baca satu bilangan bulat dari keyboard

            // Nilai di luar 0-100 ditolak dengan continue (tanpa add)
            if (nilai < 0 || nilai > 100) { //nilai tidak sah (kurang dari 0 ATAU lebih dari 100)
                if (nilai != SELESAI) { //-1 juga di luar 0-100, tapi itu tanda selesai, bukan kesalahan
                    System.out.println("  Ditolak, harus 0-100");
                }
                continue; // di do-while, lompat ke pengecekan sentinel
            }
            daftar.add(nilai); //sampai sini berarti nilai sah, simpan ke daftar
        } while (nilai != SELESAI); //ulangi selama yang diketik bukan -1

        System.out.println();

        // Kasus tidak ada nilai sah sama sekali
        if (daftar.isEmpty()) { //true kalau daftar tidak berisi apa-apa (langsung ketik -1)
            System.out.println("Tidak ada nilai yang dimasukkan.");
            input.close();
            return; //hentikan main, kode di bawah tidak dijalankan
        }

        input.close();
    }
}