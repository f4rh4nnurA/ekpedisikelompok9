//Fitur Registrasi dan Login

import java.util.Scanner;

public class registrasiLogin {
    public static void main (String[] args){
        try(Scanner scan = new Scanner (System.in)) {
            String email = " ", password1 = " ", password2 = " ";
            boolean valid = false;
            int attempts = 0, maxattempts = 3;
            
            // Registrasi
        while (!valid) { 
            System.out.println("\n\t\tRegistrasi\t\t");
            System.out.print("email\t\t:");
            email = scan.next();
            System.out.print("\npassword1\t\t:");
            password1 = scan.next();
            System.out.print("\nPassword2\t\t:");
            password2 = scan.next();
            if(password1.equals(password2)){
                System.out.println("\nRegistrasi anda berhasil, silakan login");
                valid = true;
            }else{
                System.out.println("\nPassword anda tidak sama, silakan coba lagi");
            }


            
        }
            //Menu login pertama
        valid = false;
        while (!valid){
        System.out.println("\n\n\t\tLogin\n\t\t");
        System.out.println("Pilihan akun login");
        System.out.println("1. admin");
        System.out.println("2. user");
        System.out.print("\nPilih akun login dengan angka (1-2) : ");
        String pilihan = scan.next();

        //jika pilih akun user "1"
        if (pilihan.equals("1") ) {
            
         }   
        //jika pilih akun user "2"
        else if (pilihan.equals("2") ) {
        while (attempts < maxattempts) {
            System.out.print("\n\t\tLogin User\t\t");
            System.out.print("\nEmail\t\t: ");
            String emaillogin = "";
            emaillogin = scan.next();
            System.out.print("\nPassword\t\t: ");
            password1 = scan.next();
            if(password1.equals(password2) && emaillogin.equals(email)){
                System.out.println("Anda berhasil login");
                break;
            }else {
                attempts++;
                System.out.print("Login gagal");
            if(attempts == 3){
            System.out.print(", silakan hubungi admin");
        }
    }
}
    break;
    } 
        else {
            System.out.print("\n\tpilihan yang anda input tidak ada");
            valid = false;
            
    } 
}
        
} 
}
}
