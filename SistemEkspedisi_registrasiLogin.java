import java.util.Scanner;

public class SistemEkspedisi_registrasiLogin  {
    private static String[][] dataAwal = new String[2][2];
    private static String[] Admin = {"klotaks", "jfeigeokg"}; // klotaks sebagai username admin, jfeigeokg sebagai password admin
    private static boolean validU = false, validA = false;
    private static int attempts = 0, pilihan;
    private static String username = null;

    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        //Bagian laman pertama aplikasi
        System.out.println("\t\tSelamat Datang di Aplikasi Xpedisi");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("   Masukkan pilihan (1 / 2) : ");
        pilihan = input.nextInt();

        //User
        if (pilihan == 1) {
            registrasi(input);
            if (validU) {
                login(input);
                System.out.println("1. Ganti Password");
                System.out.println("2. Ganti Email");
                System.out.println("3. Kembali");
                System.out.println("4. Kirim barang");
                System.out.print("Masukkan pilihan (1/2/3) : ");
                int pilihanUser = input.nextInt();
                if (pilihanUser == 1) {
                    gantiPassword(input);
                } else if (pilihanUser == 2) {
                    hapusEmail(input);
                } else if (pilihanUser == 3) {
                    main(arg); // Kembali ke menu utama
                }
            }
        }

        // Admin
        else if (pilihan == 2) {
            loginAdmin(input);
        }
        input.close();
    }

    public static void registrasi(Scanner input) {
        while ((!validU) && (attempts < 3)) {
            System.out.println("\n\t\tRegistrasi");
            System.out.print("Masukkan username anda\t: ");
            username = input.next();
            System.out.print("Masukkan Email\t\t: ");
            dataAwal[0][0] = input.next(); // dataAwal [0][0] digunakan sebagai email registrasi
            System.out.print("Masukkan Password1\t: ");
            String password1 = input.next();
            System.out.print("Masukkan Password2\t: ");
            String password2 = input.next();
            // cek status registrasi
            if (password1.equals(password2)) {
                System.out.println("Registrasi berhasil");
                dataAwal[0][1] = password1;
                 // dataAwal[0][1] digunakan sebagai password1 registrasi 
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

    public static void login(Scanner input) {
        attempts = 0; // reset attempts untuk login
        validU = false; // reset valid untuk login
        while ((!validU) && (attempts < 3)) {
            System.out.println("\n\t\tLogin");
            System.out.print("Masukkan Email\t\t: ");
            String loginEmail = input.next();
            System.out.print("\nMasukkan Password\t: ");
            String loginPassword = input.next();

            if (loginEmail.equals(dataAwal[0][0]) && loginPassword.equals(dataAwal[0][1])) {
                System.out.println("Selamat Datang " + username);
                validU = true;
            } else {
                System.out.println("Login gagal");
                attempts++;
            }
        }
        if (!validU) {
            System.out.println("Anda sudah mencapai batas perulangan");
        }
    }

    public static void gantiPassword(Scanner input) {
        System.out.println("\n\t\tGanti Password");
        System.out.print("Masukkan Password Baru\t\t: ");
        String passwordBaru = input.next();
        dataAwal[0][1] = passwordBaru;
        System.out.println("Password berhasil diganti");
    }

    public static void hapusEmail(Scanner input) {
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

    public static void loginAdmin(Scanner input) {
        while ((!validA) && (attempts < 3)) {
            System.out.println("\n\t\tLogin");
            System.out.print("Masukkan Username: ");
            dataAwal[1][0] = input.next(); // dataAwal[1][0] digunakan untuk input username login Admin 
            System.out.print("\nMasukkan password1: ");
            dataAwal[1][1] = input.next(); // dataAwal[1][1] digunakan untuk input password login admin
            if ((dataAwal[1][1].equals(Admin[1])) && (dataAwal[1][0].equals(Admin[0]))) {
                System.out.println("Login berhasil");
                validA = true;
            } else if ((dataAwal[1][1] != Admin[1]) && (attempts < 3) && (dataAwal[1][0] != Admin[0])) {
                System.out.print("Login gagal");
                attempts++;
            } else {
                validA = false;
            }
        }
        if (!validA) {
            System.out.print(", Kesempatan anda sudah habis");
        }
    }
}
