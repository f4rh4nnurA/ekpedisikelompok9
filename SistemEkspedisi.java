import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemEkspedisi      {
    private static String[][] dataAwal      = new String[10][6];
    private static String[][] usernameUser  = new String[2][2], 
                              emailUser     = new String[2][2], 
                              passwordUser  = new String[2][2];
    private static String[]   Admin         = {"klotaks", "tiati234"}, // klotaks sebagai username admin, tiati234 sebagai password admin
                    usernameA, passwordA    = new String[1];          
    private static boolean[][] valid        = { {false, false},
                                                {false, false},
                                                {false, false},
                                                {false, false},
                                                {false, false, false}};
    private static long[][] no_HP           = new long [2][2];
    private static int attempts;
    private static Scanner input            = new Scanner(System.in);


public static void main(String[] arg) {
    //Bagian laman pertama aplikasi
    int opsi = 0;
    do {
        try{
            while (!valid[0][0]) {
                opsi = memilihAkun(input);   
                switch (opsi) {
                    case 1 :
                        while (!valid[1][0]) {    
                            System.out.print("\n\t\t\t\tUser" + "\n1. Registrasi" + "\n2. Login" + "\n3. Kembali ke halaman awal" + "\n4. keluar dari Aplikasi" + "\nPilih Menu: ");
                            int choose = input.nextInt();
                            if(choose == 1){
                                registrasiUser(input);
                                System.out.print("\n\t\t\tPilihan setelah registrasi" + "\n1. Login" + "\n2. Kembali ke halaman awal" + "\n3. Keluar dari aplikasi" +"\nApakah anda ingin login, kembali ke halaman awal, atau keluar ? (1/2/3)\n");
                                int pilih = input.nextInt();
                                if (pilih == 1) {
                                    loginUser(input);
                                    fiturUser(input);
                                } else if (pilih == 2){
                                    valid[1][0] = false;
                                    return;
                                } else if (pilih == 3){
                                    System.exit(0);
                                } else {
                                    System.out.println("Opsi yang anda pilih tidak valid");
                                    valid [1][0] = false;
                                }
                                
                            } else if (choose == 2) {
                                tampilkanOpsi_SetelahRegistrasi(input);
                                fiturUser(input);
                            } else if (choose == 3){
                                valid[1][0] = false;
                                opsi = memilihAkun(input);
                            } else if (choose == 4) {
                                System.exit(0);
                            } 
                            }
                    case 2 :
                        loginAdmin(input);
                        menuInventori();
                        break;
                    case 3 :
                      

    public static void main(String[] arg) {
        boolean exitTrigger = false;
        while (!exitTrigger) {
            
        Scanner input = new Scanner(System.in);
        

        int opsi = 0;
            do {
                try {
                    opsi = memilihAkun();
                    switch (opsi) {
                    case 1:
                        registrasiUser(input);
                        loginUser(input);
                        inputPesanan(dataAwal);
                        hitungBiaya(dataAwal);
                        break;
                    case 2:
                        loginAdmin(input);
                        menuInventori();
                        break;
                    case 3:
                        System.out.println("Anda memilih keluar");
                        break;
                    default:
                        System.out.println("Mohon maaf opsi yang anda pilih tidak tersedia, silakan coba lagi.");
                        break;
                }

            } 
        }catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka bulat. Silakan coba lagi.");
            input.nextLine();
        }  
    } while(opsi < 1 || opsi > 3);
}
private static int tampilkanOpsi_SetelahRegistrasi(Scanner input) {
    System.out.print("\n\t\t\tPilihan setelah registrasi" + "\n1. Login" + "\n2. Kembali ke halaman awal" + "\n3. Keluar dari aplikasi" +"\nApakah anda ingin login, kembali ke halaman awal, atau keluar ? (1/2/3)\n");
    int masukan = input.nextInt();
    if (masukan == 1) {
        if (valid[4][1] == true && valid[4][0] == true && valid[3][0] == true && valid[2][0] == true){
            loginUser(input);
        } else {
            System.out.println("Anda belum registrasi,silakan registrasi dulu");
            valid[1][0] = false;
        }
    }
    return masukan;

}
private static int memilihAkun(Scanner input) {
    System.out.print("\n\t\t\t\tSelamat Datang di Aplikasi Xpedisi" +"\nPilih Opsi: " + "\n1. User" + 
    "\n2. Admin" + "\n3. Keluar" + "\nMasukkan opsi (1 / 2 / 3 ) : ");
    return input.nextInt();
}

private static void registrasiUser (Scanner input ){
    while (!valid[2][0]) {
        System.out.print("\n\t\t\t\tRegistrasi User");
        // input username
        System.out.print("\n\nUsername\t\t: ");
        usernameUser[0][0] = input.next();
        if (!usernameUser[0][0].matches("[A-Za-z]+")) {
            System.out.println("Username Anda tidak valid, username hanya boleh mengandung huruf Latin.");
            valid[2][0] = false;
        } else {
            // input email
            while (!valid[3][0]) {
                System.out.print("Email\t\t\t: ");
                emailUser[0][0] = input.next();
                if (!emailUser[0][0].matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
                    System.out.println("Email tidak valid");
                    valid[3][0] = false;
                } else {
                    // input nomor HP
                    while (!valid[4][0]) {
                        System.out.print("No.Telpon\t\t: ");
                        no_HP[0][0] = input.nextLong();                            
                        if (cekValidasiNo_HP(no_HP[0][0])) {
                            System.out.println("Nomor telepon Anda tidak valid. Nomor telepon harus dimulai dengan angka 0 dan memiliki panjang antara 10 hingga 13 digit.");
                            valid[4][0] = false; 
                        } else {
                            //input password
                            while (!valid[4][1]) {
                                System.out.print("Password\t\t: ");
                                passwordUser[0][0] = input.next();
                                System.out.print("Ulang password\t\t: ");
                                passwordUser[0][1] = input.next();
                                if (!passwordUser[0][1].equals(passwordUser[0][0])) {
                                    System.out.println("Password tidak valid");
                                    valid[4][1] = false;
                                } else {
                                    System.out.println("\nRegistrasi berhasil");
                                    valid[4][1] = true;
                                    valid[4][0] = true;
                                    valid[3][0] = true;
                                    valid[2][0] = true;
                                    break;
=======
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka bulat. Silakan coba lagi.");
                input.nextLine();
            }
        } while (opsi < 1 || opsi > 3);

        System.out.println("Apakah anda ingin keluar dari aplikasi ? (y/n)");
        String konfirmasi = input.next();
        if (konfirmasi.equalsIgnoreCase("y")) {
            exitTrigger = true;
            System.out.println("Terimakasih");
        }
    }
        input.close();
    }
    private static int memilihAkun() {
        System.out.print("\n\t\t\t\tSelamat Datang di Aplikasi Xpedisi" + "\nPilih Opsi: " + "\n1. User" +
                "\n2. Admin" + "\n3. Keluar" + "\nMasukkan opsi (1 / 2 / 3 ) : ");
        return input.nextInt();
    }

    
    private static void registrasiUser (Scanner input ){
        while (!valid[1]) {
            System.out.print("\n\t\t\t\tRegistrasi User");
            // input username
            System.out.print("\n\nUsername\t\t: ");
            usernameUser[0][0] = input.next();
            if (!usernameUser[0][0].matches("[A-Za-z]+")) {
                System.out.println("Username Anda tidak valid, username hanya boleh mengandung huruf Latin.");
                valid[1] = false;
            } else {
                // input email
                while (!valid[1]) {
                    System.out.print("Email\t\t\t: ");
                    emailUser[0][0] = input.next();
                    if (!emailUser[0][0].matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
                        System.out.println("Email tidak valid");
                        valid[1] = false;
                    } else {
                        // input nomor HP
                        while (!valid[1]) {
                            System.out.print("No.Telpon\t\t: ");
                            no_HP[0][0] = input.nextLong();                            
                            if (cekValidasiNo_HP(no_HP[0][0])) {
                                System.out.println("Nomor telepon Anda tidak valid. Nomor telepon harus dimulai dengan angka 0 dan memiliki panjang antara 10 hingga 13 digit.");
                                valid[1] = false; 
                            } else {
                                //input password
                                while (!valid[1]) {
                                    System.out.print("Password\t\t: ");
                                    passwordUser[0][0] = input.next();
                                    System.out.print("Ulang password\t\t: ");
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
}
private static void loginUser (Scanner input ){
    while ((!valid[4][2]) && (attempts < 3)) {
        System.out.print("\n\t\t\tLogin"+ "\nPilih opsi login: " + 
        "\n1. Login dengan nomor hp dan password" + "\n2. Login dengan email dan password" + "\nMasukkan opsi (1 / 2)\t: ");
        int pilihan = input.nextInt();
        if (pilihan == 1) {
            System.out.print("Masukkan nomor hp\t: ");
            no_HP[0][1] = input.nextLong();
            System.out.print("Masukkan password\t: ");
            passwordUser[1][0] = input.next();
            if ((no_HP[0][1] == no_HP[0][0]) && (passwordUser[1][0].equals(passwordUser[0][0]))) {
                System.out.println("login berhasil, selamat datang " + usernameUser[0][0]);
                valid[4][2] = true;
                break;
            } else {
                System.out.println("nomor HP atau password anda tidak valid. Silakan coba lagi.");
                attempts++;
            }
        }
        if (pilihan == 2) {
            System.out.print("Masukkan email\t\t: ");
            emailUser[0][1] = input.next();
            System.out.print("Masukkan password\t: ");
            passwordUser[1][1] = input.next();
            if ((emailUser[0][1].equals(emailUser[0][0])) && (passwordUser[1][1].equals(passwordUser[0][0]))) {
                System.out.println("login berhasil");
                valid[4][2] = true;
                break;
            } else {
                System.out.println("Email atau password anda tidak valid. ");
                attempts++;

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
                if ((no_HP[0][1] == no_HP[0][0]) && (passwordUser[1][0].equals(passwordUser[0][0]))) {
                    System.out.println("login berhasil, selamat datang " + usernameUser[0][0]);
                    valid[2] = true;
                    break;
                } else {
                    System.out.println("nomor HP atau password anda tidak valid. Silakan coba lagi.");
                    attempts++;
                }
            }
            if (pilihan == 2) {
                System.out.print("Masukkan email\t\t: ");
                emailUser[0][1] = input.next();
                System.out.print("Masukkan password\t: ");
                passwordUser[1][1] = input.next();
                if ((emailUser[0][1].equals(emailUser[0][0])) && (passwordUser[1][1].equals(passwordUser[0][0]))) {
                    System.out.println("login berhasil");
                    valid[2] = true;
                    break;
                } else {
                    System.out.println("Email atau password anda tidak valid. ");
                    attempts++;
                }
            }
            if (attempts == 3) {
                System.out.println("Kesempatan anda untuk mengulang sudah habis");
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
        System.out.println("\n\t\t\tLogin Admin");
        System.out.print("\nMasukkan username\t: ");
        usernameA[0] = input.next();
        System.out.print("\nMasukkan password\t: ");
        passwordA[0] = input.next();
        if ((usernameA[0].equals(Admin[0]) && (passwordA[0].equals(Admin[1])) && (attempts < 3))) {
            System.out.println("Selamat Datang Admin");
            attempts++;
            valid[2] = true;
            return null;
        } else if((usernameA[0] != Admin[0]) && (passwordA[0] != Admin[1]) && (attempts < 3)) {
            valid[2] = false;
        } else if (attempts == 3) {
            System.out.println("Kesempatan anda untuk mengulang sudah habis");
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
    while ((!valid[4][3]) && (attempts < 3)) {
        System.out.println("\n\t\t\tLogin Admin");
        System.out.print("\nMasukkan username\t: ");
        usernameA[0] = input.next();
        System.out.print("\nMasukkan password\t: ");
        passwordA[0] = input.next();
        if ((usernameA[0].equals(Admin[0]) && (passwordA[0].equals(Admin[1])) && (attempts < 3))) {
            System.out.println("Selamat Datang Admin");
            attempts++;
            valid[4][3] = true;
            return null;
        } else if((usernameA[0] != Admin[0]) && (passwordA[0] != Admin[1]) && (attempts < 3)) {
            valid[4][3] = false;
        } else if (attempts == 3) {
            System.out.println("Kesempatan anda untuk mengulang sudah habis");
        }
        return null;
    }
    return null;  
}
private static void inputPesanan(String[][] dataAwal) {
    Scanner input = new Scanner(System.in);
    String estimasi = "hari";

    System.out.print("Jumlah paket yang ingin anda kirimkan: ");
    int jmlPaket = input.nextInt();

    int[] resi = new int[jmlPaket];
    double hargaAkhir = 0;

    System.out.println("-------------------------------------- INPUT PESANAN ------------------------------------------------");
    
    // boolean tambahPesanan = true;
    int i = checkEmptyArrayElement(dataAwal);
    
    int availableDataSpace = dataAwal.length - checkEmptyArrayElement(dataAwal);
    
    if (availableDataSpace < jmlPaket) {
        System.out.println("Barang terlalu banyak!");
        input.close();
        return;
    }


    while (i < jmlPaket) {
        System.out.println("\n--------------------------------- Paket ke-" + (i+1) + " ---------------------------------");
        
        Scanner input2 = new Scanner(System.in);
        
        System.out.print("Jenis barang: Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen\n");
        System.out.print("Masukkan jenis barang\t\t\t\t: ");
        dataAwal[i+1][0] = input2.nextLine();
        System.out.print("Berat barang\t\t\t\t\t: ");
        dataAwal[i+1][1] = input2.nextLine();
        System.out.print("Jenis pengiriman(Reguler/Express)\t\t: ");
        dataAwal[i+1][2] = input2.nextLine();
        System.out.print("Jarak pengiriman\t\t\t\t: ");
        dataAwal[i+1][3] = input2.nextLine();
        System.out.print("Asuransi(Iya/Tidak)\t\t\t\t: ");
        dataAwal[i+1][4] = input2.nextLine();
        System.out.print("Packing kayu(Iya/Tidak)\t\t\t\t: ");
        dataAwal[i+1][5]=input2.nextLine();
        
        hitungBiaya(jmlPaket);
        i++;
        availableDataSpace = dataAwal.length - i;
        
    // ...
    }
}   

private static void hitungBiaya(int jmlPaket) {
    double hargaAkhir=0;
    
    int i = 0;
    while (i < jmlPaket) {
        if (dataAwal[i][0] != null) {
        // & dataAwal[i][0] != null
        double brtBarang = Double.parseDouble(dataAwal[i][1]);
        double jrkPengiriman = Double.parseDouble(dataAwal[i][3]);
        double ttlHarga, hargaPerKilogram = 0, hrgJarak = 0, hrgAsuransi = 0, hrgPackingKayu=0 ;
        String estimasi = "";
        //menentukan harga per kilogram
        if (dataAwal[i][0].equalsIgnoreCase("Barang kecil")) {
            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                hargaPerKilogram = 3000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram = 5000.0;
            }
        } else if (dataAwal[i][0].equalsIgnoreCase("Barang besar")) {
            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=10000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram=15000.0;     
            }
            
        } else if (dataAwal[i][0].equalsIgnoreCase("Elektronik kecil")) {
            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=8000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram=10000.0;
            }

        } else if (dataAwal[i][0].equalsIgnoreCase("Elektronik besar")) {
            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=10000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram=12000.0;
            }
            
        } else if (dataAwal[i][0].equalsIgnoreCase("Pakaian")) {
            if (dataAwal[i][2].equals("Reguler")) {
                hargaPerKilogram=5000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram=8000.0;
            }
        } else if (dataAwal[i][0].equalsIgnoreCase("Dokumen")) {
            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=2000.0;
            } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                hargaPerKilogram=4000.0;
            }
        }

        //hitung harga
        //harga per kilogram menurut jarak pengiriman
        if (jrkPengiriman < 50) {
            hrgJarak = 7000.0;
        } else if (jrkPengiriman < 100) {
            hrgJarak=10000.0;
        } else if (jrkPengiriman < 300 ) {
            hrgJarak=15000.0;
        } else if (jrkPengiriman < 500 ) {
            hrgJarak=20000.0;
        } else if (jrkPengiriman < 700) {
            hrgJarak=25000.0;  
        } else if (jrkPengiriman < 1000) {
            hrgJarak=35000.0;
        }// ... (lanjutkan penentuan harga jarak lainnya)

        //menentukan asuransi
        if (dataAwal[i][4].equalsIgnoreCase("Iya")) {
            hrgAsuransi = 10000.0;
        } else if (dataAwal[i][4].equalsIgnoreCase("Tidak")) {
            hrgAsuransi = 0.0;
        }

        if (dataAwal[i][5].equalsIgnoreCase("Iya")) {
            hrgPackingKayu=25000.0;
        } else if (dataAwal[i][5].equalsIgnoreCase("Tidak")) {
            hrgPackingKayu=0.0;
        }

        if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
            estimasi="7-10 Hari";
        } if (dataAwal[i][2].equalsIgnoreCase("Express")) {
            estimasi="3-5 Hari";
        }

        //hitung total harga
        ttlHarga = (brtBarang * hargaPerKilogram) + hrgJarak + hrgAsuransi + hrgPackingKayu;
        hargaAkhir += ttlHarga;

        //output hasil
        System.out.print("\nHarga pengiriman paket ke-"+ i + "\t\t\t\t: Rp " + ttlHarga);
        System.out.print("\nEstimasi waktu pengirimanpaket ke-"+ i + "\t\t\t: " + estimasi + "\n");
        // ... (lanjutkan output informasi lainnya)
        }
        // Tambahkan counter setiap kali melakukan loop
        i++;
    }
        System.out.println("\nTotal Harga pengiriman untuk semua pesanan\t\t: Rp " + hargaAkhir);
        System.out.println("\n----------------------------------------------------------------------------------------------------");
}
    

public static void menuInventori() {
    boolean exitTrigger = false;
    while (!exitTrigger) {
        System.out.println("-------Menu Inventori------");
        System.out.println("1. Menunjukkan data paket");
        System.out.println("2. Menghapus data paket");
        System.out.println("3. Keluar");
        System.out.print("Masukkan opsi yang ingin anda pilih : ");
        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1:
                tampilkanData();
                break;
            case 2:
                hapusData();
                break;
            case 3:
                exitTrigger = true;
                break;
            default:
                System.out.println("Pilihan tersebut tidak ditemukan!");
        }
    }
}


static void tampilkanData() {
    for (int i = 1; i < dataAwal.length; i++) {
        if (dataAwal[i][0] == null && dataAwal[i][1] == null) {
            System.out.println((i) + ". " + "Empty");
        } else {
            System.out.println((i) + ". " + "Jenis barang: " + dataAwal[i][0] +", " + "Berat barang: " + dataAwal[i][1]+ ", " + "Tipe pengiriman: " + dataAwal[i][2] + ", " +  "Jarak Pengiriman: " + dataAwal[i][3]+ ", " +  "Asuransi: " + dataAwal[i][4]+ ", " +  "Packaging kayu:" + dataAwal[i][5]);
=======
        return null;   
    }



    private static void inputPesanan(String[][] dataAwal) {
        Scanner input = new Scanner(System.in);
        String estimasi = "hari";

        System.out.print("Jumlah paket yang ingin anda kirimkan: ");
        int jmlPaket = input.nextInt();

        int[] resi = new int[jmlPaket];
        double hargaAkhir = 0;

        System.out.println("-------------------------------------- INPUT PESANAN ------------------------------------------------");
        
        // boolean tambahPesanan = true;
        int i = checkEmptyArrayElement(dataAwal);
        
        int availableDataSpace = dataAwal.length - checkEmptyArrayElement(dataAwal);
        
        if (availableDataSpace < jmlPaket) {
            System.out.println("Barang terlalu banyak!");
            input.close();
            return;
        }
static void hapusData() {
    System.out.print("Data mana yang akan anda hapus ? : ");
    int deletedIndex = input.nextInt();
    input.nextLine();
    System.out.println("Apakah anda yakin untuk menghapus data pada index " + deletedIndex + " ? (y/n)");
    String deleteConfirmation = input.next();
    input.nextLine();
    if (deleteConfirmation.equalsIgnoreCase("y")) {
        if (deletedIndex >= 1 && deletedIndex <= dataAwal.length) {
            dataAwal[deletedIndex ][0] = null;
            dataAwal[deletedIndex ][1] = null;
            dataAwal[deletedIndex ][2] = null;
            dataAwal[deletedIndex ][3] = null;
            dataAwal[deletedIndex ][4] = null;
            dataAwal[deletedIndex ][5] = null;
            System.out.println("Data berhasil dihapus");
        } else {
            System.out.println("Index tidak valid");
=======

        while (i < jmlPaket) {
            System.out.println("\n--------------------------------- Paket ke-" + (i+1) + " ---------------------------------");
            
            Scanner input2 = new Scanner(System.in);
            
            System.out.print("Jenis barang: Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen\n");
            System.out.print("Masukkan jenis barang\t\t\t\t: ");
            dataAwal[i+1][0] = input2.nextLine();
            System.out.print("Berat barang\t\t\t\t\t: ");
            dataAwal[i+1][1] = input2.nextLine();
            System.out.print("Jenis pengiriman(Reguler/Express)\t\t: ");
            dataAwal[i+1][2] = input2.nextLine();
            System.out.print("Jarak pengiriman\t\t\t\t: ");
            dataAwal[i+1][3] = input2.nextLine();
            System.out.print("Asuransi(Iya/Tidak)\t\t\t\t: ");
            dataAwal[i+1][4] = input2.nextLine();
            System.out.print("Packing kayu(Iya/Tidak)\t\t\t\t: ");
            dataAwal[i+1][5]=input2.nextLine();
            
            hitungBiaya(jmlPaket);
            i++;
            availableDataSpace = dataAwal.length - i;
            
        // ...
        }
    }   


static int checkEmptyArrayElement(String[][] dataAwal)
{
    for (int i = 0; i <= dataAwal.length; i++) {
        if (dataAwal[i][0] == null) {
            return i == 0 ? 0 : (i + 1);
        }
    }

    return dataAwal.length;
}
private static void informasiAkun (Scanner input){
    System.out.println("\n\t\t\tInformasi Akun" + "\nUsername" + usernameUser[0][0] +
                        "\nEmail\t\t: " + emailUser[0][0] +
                        "\nNomor Telepon\t\t:" + no_HP[0][0] +
                        "\nPassword\t\t:" + passwordUser[0][0] );
}
private static String fiturUser (Scanner input){
    System.out.println("\n\t\t\tDaftar Fitur User"  + 
                    "\n1. Kirim Barang"             + 
                    "\n2. Informasi Akun"           +
                    "\nPilih Fitur yang ingin digunakan\t:");
    int gunakan = input.nextInt();
    if (gunakan == 1) {
        inputPesanan(dataAwal);
        hitungBiaya(gunakan);
    } else if (gunakan == 2) {
        informasiAkun(input);
    private static void hitungBiaya(int jmlPaket) {
        double hargaAkhir=0;
        
        int i = 0;
        while (i < jmlPaket) {
            if (dataAwal[i][0] != null) {
            // & dataAwal[i][0] != null
            double brtBarang = Double.parseDouble(dataAwal[i][1]);
            double jrkPengiriman = Double.parseDouble(dataAwal[i][3]);
            double ttlHarga, hargaPerKilogram = 0, hrgJarak = 0, hrgAsuransi = 0, hrgPackingKayu=0 ;
            String estimasi = "";
            //menentukan harga per kilogram
            if (dataAwal[i][0].equalsIgnoreCase("Barang kecil")) {
                if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram = 3000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram = 5000.0;
                }
            } else if (dataAwal[i][0].equalsIgnoreCase("Barang besar")) {
                if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram=10000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram=15000.0;     
                }
                
            } else if (dataAwal[i][0].equalsIgnoreCase("Elektronik kecil")) {
                if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram=8000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram=10000.0;
                }

            } else if (dataAwal[i][0].equalsIgnoreCase("Elektronik besar")) {
                if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram=10000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram=12000.0;
                }
                
            } else if (dataAwal[i][0].equalsIgnoreCase("Pakaian")) {
                if (dataAwal[i][2].equals("Reguler")) {
                    hargaPerKilogram=5000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram=8000.0;
                }
            } else if (dataAwal[i][0].equalsIgnoreCase("Dokumen")) {
                if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram=2000.0;
                } else if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                    hargaPerKilogram=4000.0;
                }
            }

            //hitung harga
            //harga per kilogram menurut jarak pengiriman
            if (jrkPengiriman < 50) {
                hrgJarak = 7000.0;
            } else if (jrkPengiriman < 100) {
                hrgJarak=10000.0;
            } else if (jrkPengiriman < 300 ) {
                hrgJarak=15000.0;
            } else if (jrkPengiriman < 500 ) {
                hrgJarak=20000.0;
            } else if (jrkPengiriman < 700) {
                hrgJarak=25000.0;  
            } else if (jrkPengiriman < 1000) {
                hrgJarak=35000.0;
            }// ... (lanjutkan penentuan harga jarak lainnya)

            //menentukan asuransi
            if (dataAwal[i][4].equalsIgnoreCase("Iya")) {
                hrgAsuransi = 10000.0;
            } else if (dataAwal[i][4].equalsIgnoreCase("Tidak")) {
                hrgAsuransi = 0.0;
            }

            if (dataAwal[i][5].equalsIgnoreCase("Iya")) {
                hrgPackingKayu=25000.0;
            } else if (dataAwal[i][5].equalsIgnoreCase("Tidak")) {
                hrgPackingKayu=0.0;
            }

            if (dataAwal[i][2].equalsIgnoreCase("Reguler")) {
                estimasi="7-10 Hari";
            } if (dataAwal[i][2].equalsIgnoreCase("Express")) {
                estimasi="3-5 Hari";
            }

            //hitung total harga
            ttlHarga = (brtBarang * hargaPerKilogram) + hrgJarak + hrgAsuransi + hrgPackingKayu;
            hargaAkhir += ttlHarga;

            //output hasil
            System.out.print("\nHarga pengiriman paket ke-"+ i + "\t\t\t\t: Rp " + ttlHarga);
            System.out.print("\nEstimasi waktu pengirimanpaket ke-"+ i + "\t\t\t: " + estimasi + "\n");
            // ... (lanjutkan output informasi lainnya)
            }
            // Tambahkan counter setiap kali melakukan loop
            i++;
        }
            System.out.println("\nTotal Harga pengiriman untuk semua pesanan\t\t: Rp " + hargaAkhir);
            System.out.println("\n----------------------------------------------------------------------------------------------------");
    }
        

    public static void menuInventori() {
        boolean exitTrigger = false;
        while (!exitTrigger) {
            System.out.println("-------Menu Inventori------");
            System.out.println("1. Menunjukkan data paket");
            System.out.println("2. Menghapus data paket");
            System.out.println("3. Keluar");
            System.out.print("Masukkan opsi yang ingin anda pilih : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    exitTrigger = true;
                    break;
                default:
                    System.out.println("Pilihan tersebut tidak ditemukan!");
            }
        }
    }


    static void tampilkanData() {
        for (int i = 1; i < dataAwal.length; i++) {
            if (dataAwal[i][0] == null && dataAwal[i][1] == null) {
                System.out.println((i) + ". " + "Empty");
            } else {
                System.out.println((i) + ". " + "Jenis barang: " + dataAwal[i][0] +", " + "Berat barang: " + dataAwal[i][1]+ ", " + "Tipe pengiriman: " + dataAwal[i][2] + ", " +  "Jarak Pengiriman: " + dataAwal[i][3]+ ", " +  "Asuransi: " + dataAwal[i][4]+ ", " +  "Packaging kayu:" + dataAwal[i][5]);
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
            if (deletedIndex >= 1 && deletedIndex <= dataAwal.length) {
                dataAwal[deletedIndex ][0] = null;
                dataAwal[deletedIndex ][1] = null;
                dataAwal[deletedIndex ][2] = null;
                dataAwal[deletedIndex ][3] = null;
                dataAwal[deletedIndex ][4] = null;
                dataAwal[deletedIndex ][5] = null;
                System.out.println("Data berhasil dihapus");
            } else {
                System.out.println("Index tidak valid");
            }
        } else {
            System.out.println("Penghapusan data dibatalkan");
        }
    }
    return null;
    
}

}   

    static int checkEmptyArrayElement(String[][] dataAwal)
    {
        for (int i = 0; i <= dataAwal.length; i++) {
            if (dataAwal[i][0] == null) {
                return i == 0 ? 0 : (i + 1);
            }
        }

        return dataAwal.length;
    }
}
