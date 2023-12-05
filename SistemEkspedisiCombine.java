import java.util.Scanner;

public class SistemEkspedisiCombine {
    private static String[][] dataAwal = new String[10][2];
    private static String[] Admin = {"klotaks", "jfeigeokg"};
    private static boolean validU = false, validA = false;
    private static int attempts = 0, itemCount = 0;
    private static String username = null;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\tSelamat Datang di Aplikasi Xpedisi");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Masukkan pilihan (1/2) : ");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            registrasi();
            if (validU) {
                userMenu();
            }
        } else if (pilihan == 2) {
            loginAdmin();
            if (validA) {
                menuInventori();
            }
        }
        input.close();
    }

    public static void registrasi() {
        while ((!validU) && (attempts < 3)) {
            System.out.println("\n\t\tRegistrasi");
            System.out.print("Masukkan username anda: ");
            username = input.next();
            System.out.print("Masukkan Email\t\t: ");
            dataAwal[0][0] = input.next();
            System.out.print("Masukkan Password1\t: ");
            String password1 = input.next();
            System.out.print("Masukkan Password2\t: ");
            String password2 = input.next();

            if (password1.equals(password2)) {
                System.out.println("Registrasi berhasil");
                dataAwal[0][1] = password1;
                validU = true;
            } else {
                System.out.println("Registrasi gagal");
                attempts++;
            }
        }
        if (!validU) {
            System.out.println("Anda sudah mencapai batas perulangan, silahkan hubungi admin");
        }
    }

    public static void userMenu() {
        System.out.println("Selamat Datang " + username);
        System.out.println("1. Ganti Password");
        System.out.println("2. Ganti Email");
        System.out.println("3. Kembali");
        System.out.println("4. Kirim barang");
        System.out.print("Masukkan pilihan (1/2/3) : ");
        int pilihanUser = input.nextInt();

        switch (pilihanUser) {
            case 1:
                gantiPassword();
                break;
            case 2:
                hapusEmail();
                break;
            case 3:
                main(new String[]{});
                break;
            default:
                System.out.println("Pilihan tersebut tidak ditemukan!");
        }
    }

    public static void gantiPassword() {
        System.out.println("\n\t\tGanti Password");
        System.out.print("Masukkan Password Baru\t\t: ");
        String passwordBaru = input.next();
        dataAwal[0][1] = passwordBaru;
        System.out.println("Password berhasil diganti");
    }

    public static void hapusEmail() {
        System.out.println("\n\t\tHapus Email");
        System.out.print("Apakah Anda yakin ingin menghapus email? (y/n)\t\t: ");
        String konfirmasi = input.next();
        if (konfirmasi.equalsIgnoreCase("y")) {
            dataAwal[0][0] = null;
            System.out.println("Email berhasil dihapus");
        } else {
            System.out.println("Penghapusan email dibatalkan");
        }
    }

    public static void loginAdmin() {
        while ((!validA) && (attempts < 3)) {
            System.out.println("\n\t\tLogin Admin");
            System.out.print("Masukkan Username: ");
            String adminUsername = input.next();
            System.out.print("Masukkan Password: ");
            String adminPassword = input.next();

            if (adminUsername.equals(Admin[0]) && adminPassword.equals(Admin[1])) {
                System.out.println("Login Admin berhasil");
                validA = true;
            } else {
                System.out.println("Login Admin gagal");
                attempts++;
            }
        }
        if (!validA) {
            System.out.println("Kesempatan anda sudah habis");
        }
    }

    public static void menuInventori() {
        boolean exitTrigger = false;
        while (!exitTrigger) {
            System.out.println("-------Menu Inventori------");
            System.out.println("1. Menambahkan data paket");
            System.out.println("2. Menunjukkan data paket");
            System.out.println("3. Menghapus data paket");
            System.out.println("4. Kembali ke menu utama");
            System.out.print("Masukkan opsi yang ingin anda pilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

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
    }

    static void tambahkanData() {
        if (itemCount < 10) {
            System.out.println("Masukkan nama barang : ");
            dataAwal[itemCount][0] = input.nextLine();
            System.out.println("Masukkan alamat barang : ");
            dataAwal[itemCount][1] = input.nextLine();
            itemCount++;
        } else {
            System.out.println("Kapasitas data penuh");
        }
    }

    static void tampilkanData() {
        System.out.println("Nama barang , alamat ");
        for (int i = 0; i < itemCount; i++) {
            if (dataAwal[i][0] == null && dataAwal[i][1] == null) {
                System.out.println((i + 1) + ". " + "Empty");
            } else {
                System.out.println((i + 1) + ". " + dataAwal[i][0] + " , " + dataAwal[i][1]);
            }
        }
    }

    static void hapusData() {
        System.out.print("Data mana yang akan anda hapus ? : ");
        int deletedIndex = input.nextInt();
        input.nextLine();
        System.out.println("Apakah anda yakin untuk menghapus data pada index " + deletedIndex + " ? (y/n)");
        String deleteConfirmation = input.next();
        input.nextLine();
        if (deleteConfirmation.equalsIgnoreCase("y")) {
            if (deletedIndex >= 1 && deletedIndex <= itemCount) {
                dataAwal[deletedIndex - 1][0] = null;
                dataAwal[deletedIndex - 1][1] = null;
                System.out.println("Data berhasil dihapus");
            } else {
                System.out.println("Index tidak valid");
            }
        } else {
            System.out.println("Penghapusan data dibatalkan");
        }
    }
}
