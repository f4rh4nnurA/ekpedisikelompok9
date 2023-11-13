package proyek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NewInventori {
    public static void main(String[] args) {
        List<Paket> paketList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exitTrigger = false;

        while (!exitTrigger) {
            printMenuOptions();

            byte choice = scanner.nextByte();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addPaket(scanner, paketList);
                    break;
                case 2:
                    displayPaketList(paketList);
                    break;
                case 3:
                    deletePaket(scanner, paketList);
                    break;
                case 4:
                    exitTrigger = true;
                    break;
                default:
                    System.out.println("Tolong masukkan nomor sesuai opsi yang akan dipilih");
            }

            System.out.print("Apakah anda hendak melakukan aksi lain: (y/n) ");
            String confirmation = scanner.next();

            if (!confirmation.equalsIgnoreCase("y")) {
                exitTrigger = true;
            }
        }
    }

    private static void printMenuOptions() {
        System.out.println("1.) Menambahkan data paket");
        System.out.println("2.) Melihat list data paket");
        System.out.println("3.) Menghapus data paket");
        System.out.println("4.) Kembali ke menu utama");
        System.out.print(": ");
    }

    private static void addPaket(Scanner scanner, List<Paket> paketList) {
        System.out.println("Masukkan nama paket: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan alamat paket: ");
        String alamat = scanner.nextLine();
        System.out.println("Masukkan berat paket: ");
        float berat = scanner.nextFloat();

        paketList.add(new Paket(generateRandomString(), nama, alamat, berat));
    }

    private static void displayPaketList(List<Paket> paketList) {
        for (Paket p : paketList) {
            System.out.println("No. Resi: " + p.getNomorResi() + "\nNama: " + p.getNama() + "\nAlamat: " + p.getAlamat() + "\nBerat: " + p.getBerat());
        }
    }

    private static void deletePaket(Scanner scanner, List<Paket> paketList) {
        System.out.print("Masukkan nama dari detail paket yang hendak dihapus: ");
        String nama = scanner.nextLine();

        int paketIndex = findPaketIndex(paketList, nama);
        if (paketIndex == -1) {
            System.out.println("Data paket tidak ditemukan!");
        } else {
            System.out.print("Apakah anda yakin untuk menghapus data tersebut? (y/n): ");
            String confirmation = scanner.next();
            if (confirmation.equalsIgnoreCase("y")) {
                paketList.remove(paketIndex);
            }
        }
    }

    private static int findPaketIndex(List<Paket> paketList, String nama) {
        for (int i = 0; i < paketList.size(); i++) {
            if (paketList.get(i).getNama().equals(nama)) {
                return i;
            }
        }
        return -1;
    }

    private static String generateRandomString() {
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

    static class Paket {
        private String nomorResi;
        private String nama;
        private String alamat;
        private float berat;

        public Paket(String nomorResi, String nama, String alamat, float berat) {
            this.nomorResi = nomorResi;
            this.nama = nama;
            this.alamat = alamat;
            this.berat = berat;
        }

        public String getNomorResi() {
            return nomorResi;
        }

        public String getNama() {
            return nama;
        }

        public String getAlamat() {
            return alamat;
        }

        public float getBerat() {
            return berat;
        }
            
        
    }
}