public import java.util.Scanner;

public class SistemEkspedisiInventori {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        String  dataAwal[][] = new String[2][2] , Admin[] = {"klotaks","jfeigeokg"};
        boolean valid = false;
        int attempts = 0, pilihan;
        
        //Bagian laman pertama aplikasi
        System.out.println("\t\tSelamat Datang di Aplikasi Xpedisi");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Masukkan pilihan (1/2) : ");
        pilihan = input.nextInt();
        
        //User
        if(pilihan == 1){
            while ((!valid) && (attempts < 3)){ 
                System.out.println("\n\t\tRegistrasi");  
                System.out.print("Masukkan Email\t\t: ");
                dataAwal[0][0] = input.next();
                System.out.print("\nMasukkan Password1\t: ");
                String password1 = input.next();
                System.out.print("\nMasukkan Password2\t: ");
                String password2 = input.next();
                // cek status registrasi
                if(password1.equals(password2)){
                    System.out.println("Registrasi berhasil");
                    dataAwal[0][1] = password1;
                    valid = true;
                }else{
                    System.out.println("Registrasi gagal");
                    attempts++;
                }
            }
            if (!valid) {
                System.out.println("Anda sudah mencapai batas perulangan, silahkan hubungi admin");
            }
            
            //Login
            if(valid){
                attempts = 0; // reset attempts untuk login
                valid = false; // reset valid untuk login
                while ((!valid) && (attempts < 3)){
                    System.out.println("\n\t\tLogin");
                    System.out.print("Masukkan Email\t\t: ");
                    String loginEmail = input.next();
                    System.out.print("\nMasukkan Password\t: ");
                    String loginPassword = input.next();
                    
                    if(loginEmail.equals(dataAwal[0][0]) && loginPassword.equals(dataAwal[0][1])){
                        System.out.println("Selamat Datang Admin");
                        valid = true;
                    }else{
                        System.out.println("Login gagal");
                        attempts++;
                    }
                }
                if (!valid) {
                    System.out.println("Anda sudah mencapai batas perulangan");
                }
            }
        } 

        // Admin   
        else if (pilihan == 2){
            while ((!valid) && (attempts < 3)){
                System.out.println("\n\t\tLogin");
                System.out.print("Masukkan Username: ");
                dataAwal[1][0] = input.next();
                System.out.print("\nMasukkan password1: ");
                dataAwal[1][1] = input.next();
                if((dataAwal[1][1].equals(Admin[1])) && (dataAwal[1][0].equals(Admin[0]))){
                    System.out.println("Login berhasil");
                    valid = true;
                }else if((dataAwal[1][1] != Admin[1]) && (attempts < 3) && (dataAwal[1][0] != Admin[0])){
                    System.out.print("Login gagal");
                    attempts++;
                } else{
                    valid = false;
                }
            }
            if (!valid) {
                System.out.print(", piye to! admin kok ora iso login");
            }
        } 

        if (valid = true){

        String  dataInventori[][] = new String[10][2] ;
        int itemCount = 0;

        //Memasukkan tipe data masukkan
        int pil ;
        boolean exitTrigger = false;

        while (exitTrigger == false) {
            System.out.println("-------Menu------");
            System.out.println("1. Menambahkan data paket");
            System.out.println("2. Menunjukkan data paket");
            System.out.println("3. Menghapus data paket");
            System.out.println("4. Kembali ke manu utama");
            System.out.println("Masukkan opsi yang ingin anda pilih :");
            pil  = input.nextInt();
            input.nextLine();

            if (pil == 1) {
                System.out.println("Masukkan nama barang : ");
                dataInventori[itemCount][0] = input.nextLine();
                System.out.println("Masukkan alamat barang : ");
                dataInventori[itemCount][1] = input.nextLine();
                itemCount++; 
            } else if (pil == 2) {
                System.out.println("Nama barang , alamat ");
                for (int i = 0; i < 10;i++ ) {
                    if (dataInventori[i][0] == null && dataInventori[i][1] == null) {
                        System.out.println((i + 1) + ". " + "Empty");
                    } else {
                        System.out.println((i + 1) + ". " + dataInventori[i][0] + " , " + dataInventori[i][1]);
                    }
                }
            } else if (pil == 3) {
                System.out.print("Data mana yang akan anda hapus ? : ");
                int deletedIndex = input.nextInt();
                input.nextLine();
                System.out.println("Apakah anda yakin untuk menghapus data pada index " + deletedIndex);
                int deleteConfirmation = input.nextInt();
                input.nextLine();
                if (deleteConfirmation == 1) {
                    dataInventori[deletedIndex - 1][0] = null;
                    dataInventori[deletedIndex - 1][1] = null;
                }
            } else if (pil == 4) {
                exitTrigger = true;
            } else {
                System.out.println("Pilihan tersebut tidak ditemukan!");
            }
        };


    }

    input.close();
}
    } {
    
}
