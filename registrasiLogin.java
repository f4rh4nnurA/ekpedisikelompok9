//Fitur Registrasi dan Login;
import java.util.HashMap;
import java.util.Scanner;

public class registrasiLogin {
    static HashMap<String, String> users = new HashMap<String, String>();
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Pilih Opsi: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Pilihan tidak ditemukan");
            }
        }
        scanner.close();
    }

    static void registerUser(Scanner input) {
        System.out.println("Masukkan email:");
        String email = input.nextLine();
        System.out.println("Masukkan passowrd anda:");
        String password = input.nextLine();
        if (users.containsKey(email)) {
            System.out.println("email sudah terdaftar.");
        } else {
            users.put(email, password);
            System.out.println("Registration successful.");
        }
    }

    static void loginUser(Scanner input) {
        System.out.println("Masukkan email:");
        String email = input.nextLine();
        System.out.println("Masukkan password anda:");
        String password = input.nextLine();
        if (!users.containsKey(email)) {
            System.out.println("Email atau password tidak benar.");
        } else {
            if (users.get(email).equals(password)) {
                System.out.println("Login berhasil.");
            } else {
                System.out.println("Email atau password tidak benar.");
            }
        }   
        }

    }



    
