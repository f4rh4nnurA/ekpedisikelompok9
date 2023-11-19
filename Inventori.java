import java.util.Scanner;

public class Inventori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  dataAwal[][] = new String[10][2] ;
        int itemCount = 0;

        //Memasukkan tipe data masukkan
        int pilihan ;
        boolean exitTrigger = false;

        while (exitTrigger == false) {
            System.out.println("-------Menu------");
            System.out.println("1. Menambahkan data paket");
            System.out.println("2. Menunjukkan data paket");
            System.out.println("3. Menghapus data paket");
            System.out.println("4. Kembali ke manu utama");
            System.out.println("Masukkan opsi yang ingin anda pilih :");
            pilihan  = sc.nextInt();
            sc.nextLine();

            if (pilihan == 1) {
                System.out.println("Masukkan nama barang : ");
                dataAwal[itemCount][0] = sc.nextLine();
                System.out.println("Masukkan alamat barang : ");
                dataAwal[itemCount][1] = sc.nextLine();
                itemCount++; 
            } else if (pilihan == 2) {
                System.out.println("Nama barang , alamat ");
                for (int i = 0; i < 10;i++ ) {
                    if (dataAwal[i][0] == null && dataAwal[i][1] == null) {
                        System.out.println((i + 1) + ". " + "Empty");
                    } else {
                        System.out.println((i + 1) + ". " + dataAwal[i][0] + " , " + dataAwal[i][1]);
                    }
                }
            } else if (pilihan == 3) {
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
            } else if (pilihan == 4) {
                exitTrigger = true;
            } else {
                System.out.println("Pilihan tersebut tidak ditemukan!");
            }
        };


        sc.close();
    }
}
