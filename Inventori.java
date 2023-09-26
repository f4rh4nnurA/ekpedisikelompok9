package proyek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Inventori {
    public static void main(String[] args) {
        List<Paket> paket = new ArrayList<>();
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

                paket.add(new Paket(generateRandomString(), nama, alamat, berat));
            } else if (pilihan == 2) {
                for (Paket p : paket) {
                    System.out.println("No. Resi: " + p.getNomorResi() + "\nNama: " + p.getNama() + "\nAlamat: " + p.getAlamat() + "\nBerat: " + p.getBerat());
                }
            } else if (pilihan == 3) {
                System.out.print("Masukkan nama dari detail paket yang hendak dihapus: ");
                nama = S.nextLine();

                int paketIndex = findPaketIndex(paket, nama);
                if (paketIndex == -1) {
                    System.out.println("Data paket tidak ditemukan!");
                }

                String confirmation = "n";
                System.out.print("Apakah anda yakin untuk menghapus data tersebut? : ");
                confirmation = S.next();
                if (confirmation.equals("y")) {
                    paket.remove(paketIndex);
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

    static int findPaketIndex(List<Paket> paket, String nama) {
        int index = -1;

        for (int i = 0; i < paket.size(); i++) {
            if (paket.get(i).getNama().equals(nama)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}