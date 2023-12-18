import java.util.InputMismatchException;
import java.util.Scanner;

public class coba  {
    private static String[][] dataAwal      = new String[10][2];
    private static String[][] usernameUser  = new String[2][2], 
                              emailUser     = new String[2][2], 
                              passwordUser  = new String[2][2];
    private static String[]   Admin         = {"klotaks", "tiati234"}, // klotaks sebagai username admin, tiati234 sebagai password admin
                    usernameA, passwordA    = new String[1];          
    private static boolean[][] valid        = { {false, false},
                                                {false, false},
                                                {false, false},
                                                {false, false},
                                                {false, false}};
    private static long[][] no_HP           = new long [2][2];
    private static int attempts, itemCount  = 0;
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
                                    // login setelah registrasi
                                    loginUser(input);     
                                    System.out.print("\nMenu Fitur " + "\n1. Kirim Barang" + "\n2. Akun" + "\nPilih opsi : ");
                                    int pilihan = input.nextInt();
                                    if (pilihan == 1) {
                                        
                                    } else if (pilihan == 2){
                                        System.out.println("\n\t\t\tAkun");
                                        tampilkanInfoAkun(input);
                                    }
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
                                loginUser(input);
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
            if ((no_HP[0][1] == no_HP[0][0]) && (passwordUser[1][0].equals(passwordUser[0][1]))) {
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
            if ((emailUser[0][1].equals(emailUser[0][0])) && (passwordUser[1][1].equals(passwordUser[0][1]))) {
                System.out.println("login berhasil");
                valid[4][2] = true;
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
    while ((valid[4][3] == true) && (attempts < 3)) {
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
public static void menuInventori() {
    boolean exitTrigger = false;
    while (!exitTrigger) {
        System.out.println("-------Menu Inventori------");
        System.out.println("1. Menambahkan data paket");
        System.out.println("2. Menunjukkan data paket");
        System.out.println("3. Menghapus data paket");
        System.out.println("4. Keluar");
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

static double hitungBiaya(String jnsBarang, double brtBarang, String jnsPengiriman, double jrkPengiriman, String asuransi, String pckgKayu) {
    double hargaPerKilogram = 0, hrgJarak = 0, hrgAsuransi = 0, hrgPackingKayu = 0, ttlHarga = 0;

    // Menentukan harga per kilogram berdasarkan jenis barang & layanan pengiriman
    if (jnsBarang.equalsIgnoreCase("Barang kecil")) {
        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
            hargaPerKilogram=3000.0;    
        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=5000.0; 
            }

    } else if (jnsBarang.equalsIgnoreCase("Barang besar")) {
            if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=10000.0;
            } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=15000.0;     
            }

    } else if (jnsBarang.equalsIgnoreCase("Elektronik kecil")) {
            if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=8000.0;
            } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=10000.0;
            }

    } else if (jnsBarang.equalsIgnoreCase("Elektronik besar")) {
            if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=10000.0;
            } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=12000.0;
            }

    } else if (jnsBarang.equalsIgnoreCase("Pakaian")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=5000.0;
            } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=8000.0;
            }
    } else if (jnsBarang.equalsIgnoreCase("Dokumen")) {
            if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                hargaPerKilogram=2000.0;
            } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                hargaPerKilogram=4000.0;
            }
    }

    // Menentukan harga pengiriman berdasarkan jarak
    if (jrkPengiriman < 50) {
        hrgJarak=7000.0;
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
    }
    // ... Lanjutkan penentuan hargaJarak untuk jarak lainnya sesuai kebutuhan



    // Menentukan harga asuransi
    if (asuransi.equalsIgnoreCase("Iya")) {
        hrgAsuransi=10000.0;
    } else if (asuransi.equalsIgnoreCase("Tidak")) {
        hrgAsuransi=0.0;
    }

    // Menentukan harga packing kayu
    if (pckgKayu.equalsIgnoreCase("Iya")) {
        hrgPackingKayu = 25000.0;
    } else if (pckgKayu.equalsIgnoreCase("Tidak")) {
        hrgPackingKayu = 0.0;
    }

    // Menghitung total harga
    ttlHarga = (brtBarang * hargaPerKilogram) + hrgJarak + hrgAsuransi + hrgPackingKayu;

    return ttlHarga;
}

static void tampilkanPesanan(int[] paket, String[] jmlBarang, double hargaAkhir) {
    System.out.println("\n----------------------------------------------------------------------------------------------------");
    for (int j = 0; j < paket.length; j++) {
        System.out.print("\nJenis barang ke-" + (j + 1) + " \t\t\t\t: " + jmlBarang[j]);
    }

    System.out.print("\nTotal Harga pengiriman\t\t\t\t: Rp " + hargaAkhir);
    System.out.println("\n----------------------------------------------------------------------------------------------------");

}

static void tampilkanInfoAkun(Scanner input){
    System.out.println("\n\t\t\tInformasi Akun" + 
                        "\nUsername\t\t: "   + usernameUser[0][0] + 
                        "\nEmail\t\t\t: "    + emailUser[0][0]    + 
                        "\nNo.Telpon\t\t: "  + no_HP[0][0]        + 
                        "\nPassword\t\t:"    + passwordUser[0][0]);
}
}





