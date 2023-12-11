import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemEkspedisi_registrasiLogin  {
    private static String[][] usernameUser  = new String[2][2], 
                              emailUser     = new String[2][2], 
                              passwordUser  = new String[2][2];
    private static String[] Admin           = {"klotaks", "jfeigeokg1"}; // klotaks sebagai username admin, jfeigeokg sebagai password admin
    private static String[] usernameA       = new String[1];
    private static String[] passwordA       = new String[1];
    private static boolean[] valid          = {false,false,false};
    private static long[][] no_HP           = new long [2][2];
    private static int attempts             = 0;

public static void main(String[] arg) {
    Scanner input = new Scanner(System.in);
    //Bagian laman pertama aplikasi
    int opsi = 0;
    do {
        try{
            opsi = memilihAkun(input);   
            switch (opsi) {
                case 1 :
                    registrasiUser(input);
                    loginUser(input);
                    break;
                case 2 :
                    loginAdmin(input);
                    break;
                case 3 :
                    System.out.println("Anda memilih keluar");
                    break;
                default:
                    System.out.println("Mohon maaf opsi yang anda pilih tidak tersedia, silakan coba lagi.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka bulat. Silakan coba lagi.");
            input.nextLine();
    }  
    } while(opsi < 1 || opsi > 3);
}
private static int memilihAkun(Scanner input) {
    System.out.print("\n\t\t\t\tSelamat Datang di Aplikasi Xpedisi" +"\nPilih Opsi: " + "\n1. User" + 
    "\n2. Admin" + "\n3. Keluar" + "\nMasukkan opsi (1 / 2 / 3) : ");
    return input.nextInt();
}

private static void registrasiUser (Scanner input ){
    while (!valid[1]) {
        System.out.print("\n\t\t\t\tRegistrasi User");
        // input username
        System.out.print("\n\nUsername (username hanya boleh mengandung huruf Latin)\t\t\t\t\t\t\t: ");
        usernameUser[0][0] = input.next();
        if (!usernameUser[0][0].matches("[A-Za-z]+")) {
            System.out.println("Username Anda tidak valid, username hanya boleh mengandung huruf Latin.");
            valid[1] = false;
        } else {
            // input email
            while (!valid[1]) {
                System.out.print("Email (Email harus mengandung simbol @, huruf Latin, dan tanda titik)\t\t\t\t\t: ");
                emailUser[0][0] = input.next();
                if (!emailUser[0][0].matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
                    System.out.println("Email tidak valid");
                    valid[1] = false;
                } else {
                    // input nomor HP
                    while (!valid[1]) {
                        System.out.print("No.Telpon (Nomor telepon harus dimulai dengan angka 0 dan memiliki panjang antara 10 hingga 13 digit)\t: ");
                        no_HP[0][0] = input.nextLong();                            
                        if (cekValidasiNo_HP(no_HP[0][0])) {
                            System.out.println("Nomor telepon Anda tidak valid. Nomor telepon harus dimulai dengan angka 0 dan memiliki panjang antara 10 hingga 13 digit.");
                            valid[1] = false; 
                        } else {
                            //input password
                            while (!valid[1]) {
                                System.out.print("Password\t\t\t\t\t\t\t\t\t\t\t\t: ");
                                passwordUser[0][0] = input.next();
                                System.out.print("Ulang password\t\t\t\t\t\t\t\t\t\t\t\t: ");
                                passwordUser[0][1] = input.next();
                                if (!passwordUser[0][1].equals(passwordUser[0][0])) {
                                    System.out.println("Password tidak valid");
                                    valid[1] = false;
                                } else {
                                    System.out.println("\nRegistrasi berhasil");
                                    valid[1] = true;
                                }
                            }
                        }   
                    }
                }
            }
        }
    }
}
private static void loginUser (Scanner input ){
    while (!valid[2] && (attempts < 3)) {
        System.out.print("\n\t\t\tLogin"+ "\nPilih opsi login: " + 
        "\n1. Login dengan nomor hp dan password" + "\n2. Login dengan email dan password" + "\nMasukkan opsi (1 / 2)\t: ");
        int pilihan = input.nextInt();
        if (pilihan == 1) {
            System.out.print("Masukkan nomor hp\t: ");
            no_HP[0][1] = input.nextLong();
            System.out.print("Masukkan password\t: ");
            passwordUser[1][0] = input.next();
            if ((no_HP[0][1] != no_HP[0][0]) && (passwordUser[1][0] != passwordUser[0][0]) && (attempts < 3)) {
                System.out.println("nomor HP anda tidak valid. Silakan coba lagi.");
                attempts++;
                valid[2] = false;
            } else if ((no_HP[0][1] == no_HP[0][0]) && (passwordUser[1][0] == passwordUser[0][0]) && (attempts < 3)) {
                System.out.println("login berhasil");
                valid[2] = true;
                break;
            } else if (attempts == 3) {
                System.out.println("Kesempatan anda untuk mengulang sudah habis");
                break;
            }
        }
        if (pilihan == 2) {
            System.out.print("Masukkan email\t: ");
            emailUser[0][1] = input.next();
            System.out.print("Masukkan password\t: ");
            passwordUser[1][1] = input.next();
            if ((emailUser[0][1] != emailUser[0][0]) && (passwordUser[1][1] != passwordUser[1][0]) && (attempts < 3)) {
                System.out.println("nomor HP anda tidak valid. Silakan coba lagi.");
                attempts++;
                valid[2] = false;
            } else if ((no_HP[0][1] == no_HP[0][0]) && (passwordUser[1][0] == passwordUser[0][0]) && (attempts < 3)) {
                System.out.println("login berhasil");
                valid[2] = true;
                break;
            } else if (attempts == 3) {
                System.out.println("Kesempatan anda untuk mengulang sudah habis");
                break;
            }
        }
    }
}
private static boolean cekValidasiNo_HP(long nomorHP) {
    int jumlahDigit = 0;
    long temp = nomorHP;
    while (temp != 0) {
        temp /= 10;
        jumlahDigit++;
    }
    return jumlahDigit >= 10 && jumlahDigit <= 13 && String.valueOf(nomorHP).charAt(0) == '0';
}
private static String loginAdmin(Scanner input){
    System.out.print("Masukkan username\t: ");
    usernameA[0] = input.next();
    System.out.print("\nMasukkan password\t: ");
    passwordA[0] = input.next();
    if ((usernameA[0] != Admin[0]) && (passwordA[0] != Admin[1]) && (attempts < 3)) {
        System.out.println("nomor HP anda tidak valid. Silakan coba lagi.");
        attempts++;
        valid[2] = false;
        return null;
    } else if((usernameA[0] != Admin[0]) && (passwordA[0] != Admin[1]) && (attempts < 3)) {
        valid[2] = true;
    } else if (attempts == 3) {
        System.out.println("Kesempatan anda untuk mengulang sudah habis");
    }
    return null;   
}
}





