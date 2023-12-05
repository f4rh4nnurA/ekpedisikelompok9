import java.util.Scanner;

public class Inventori {
    static Scanner sc = new Scanner(System.in);
    static String[][] dataAwal = new String[10][2];
    static int itemCount = 0;

    public static void main(String[] args) {
        boolean exitTrigger = false;

        while (!exitTrigger) {
            System.out.println("-------Menu------");
            System.out.println("1. Menambahkan data paket");
            System.out.println("2. Menunjukkan data paket");
            System.out.println("3. Menghapus data paket");
            System.out.println("4. Kembali ke menu utama");
            System.out.println("Masukkan opsi yang ingin anda pilih :");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahkanData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    hapusData();
                    break;
                case 4:
                    exitTrigger = true;
                    break;
                default:
                    System.out.println("Pilihan tersebut tidak ditemukan!");
            }
        }

        sc.close();
    }

    static void tambahkanData() {
        System.out.println("Masukkan nama barang : ");
        dataAwal[itemCount][0] = sc.nextLine();
        System.out.println("Masukkan alamat barang : ");
        dataAwal[itemCount][1] = sc.nextLine();
        itemCount++;
    }

    static void tampilkanData() {
        System.out.println("Nama barang , alamat ");
        for (int i = 0; i < 10; i++) {
            if (dataAwal[i][0] == null && dataAwal[i][1] == null) {
                System.out.println((i + 1) + ". " + "Empty");
            } else {
                System.out.println((i + 1) + ". " + dataAwal[i][0] + " , " + dataAwal[i][1]);
            }
        }
    }

    static void hapusData() {
        System.out.print("Data mana yang akan anda hapus ? : ");
        int deletedIndex = sc.nextInt();
        sc.nextLine();
        System.out.println("Apakah anda yakin untuk menghapus data pada index " + deletedIndex);
        int deleteConfirmation = sc.nextInt();
        sc.nextLine();
        if (deleteConfirmation == 1) {
            dataAwal[deletedIndex - 1][0] = null;
            dataAwal[deletedIndex - 1][1] = null;
        }
    }
}
