import java.util.Scanner;

public class Inventori {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        boolean exitTrigger = false;

        while(!exitTrigger) {
            byte pilihan = 0;
            String nama = "";
            String alamat = "";
            float berat = 0f;

            System.out.println("1.) Menambahkan data paket");
            System.out.println("2.) Melihat list data paket");
            System.out.println("3.) Menghapus data paket");
            System.out.println("4.) Kembali ke menu utama");
            System.out.print(": ");
            pilihan = S.nextByte();
            S.nextLine();

            if (pilihan == 1) {
                System.out.println("Masukkan nama paket: ");
                nama = S.nextLine();
                System.out.println("Masukkan alamat paket: ");
                alamat = S.nextLine();
                System.out.println("Masukkan berat paket: ");
                berat = S.nextFloat();

            } else if (pilihan == 2) {
                    System.out.println("\nNama: " + nama + "\nAlamat: " + alamat + "\nBerat: " + berat);
            } else if (pilihan == 3) {
                System.out.print("Masukkan nama dari detail paket yang hendak dihapus: ");
                nama = S.nextLine();

                String confirmation = "n";
                System.out.print("Apakah anda yakin untuk menghapus data tersebut? : ");
                confirmation = S.next();
                if (confirmation.equals("y")) {
                }
            } else if (pilihan == 4) {
                exitTrigger = true;
            } else {
                System.out.println("Tolong masukkan nomor sesuai opsi yang akan dipilih");
            }

            String confirmation = "n";
            System.out.print("Apakah anda hendak melakukan aksi lain: (y/n) ");
            confirmation = S.next();

            if (confirmation.equals("n")) {
                S.close();
                exitTrigger = true;
            }
        }
    }

}
