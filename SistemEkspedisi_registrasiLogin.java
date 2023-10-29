

//Fitur Registrasi dan Login

import java.util.Scanner;

public class SistemEkspedisi_registrasiLogin {
        public static void main (String[] args){
            try(Scanner input = new Scanner(System.in)){
            String email = " ", password1 = " ", password2 = " ", passwordAdmin = "12345",username = "admin";
            boolean valid = false, exitTrigger = false;
            int attempts = 0, maxAttempts = 3;
            
            // Registrasi
        while (!valid) { 
            System.out.println("\n\t\tRegistrasi\t\t");
            System.out.print("email\t\t:");
            email = input.next();
            System.out.print("\npassword1\t\t:");
            password1 = input.next();
            System.out.print("\nPassword2\t\t:");
            password2 = input.next();
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
        String pilihan = input.next();

        //jika pilih akun user "1"
        if (pilihan.equals("1") ) {
        while (attempts < maxAttempts) {
            System.out.print("\nUsername\t\t: ");
            String enteredUsername = input.nextLine();
            System.out.print("\nPassword\t\t: ");
            String enteredPassword = input.nextLine();

            if(enteredUsername.equals(username) && enteredPassword.equals(passwordAdmin)) {
                System.out.println("Login berhasil!");
                break;
            } else {
                System.out.println("Login gagal. Coba lagi.");
                attempts++;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Batas percobaan tercapai. Akun anda terblokir harap hubungi Admin.");
            return;
        }
         }   
        //jika pilih akun user "2"
        else if (pilihan.equals("2") ) {
        while (attempts < maxAttempts) {
            System.out.print("\n\t\tLogin User\t\t");
            System.out.print("\nEmail\t\t: ");
            String emaillogin = "";
            emaillogin = input.next();
            System.out.print("\nPassword\t\t: ");
            password1 = input.next();
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
// pilihan untuk ke bagian input harga atau inventori
String[] noPilihan = {"Pemesanan Pengiriman", "Inventori"};
int opsiPilihan = 0;
do{
    System.out.println("\n\t\tOpsi pemilihan\t\t");
    for (int i = 0; i < noPilihan.length; i++) {
    System.out.println((i + 1) + ". " + noPilihan[i]);
    }
System.out.print("Masukkan opsi pilihan : ");
opsiPilihan = input.nextInt();

//input data
if(opsiPilihan == 1){ 

float brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0, hrgJarak=0, hrgAsuransi=0, hrgPackingKayu=0;
String jnsBarang, jnsPengiriman, asuransi, pckgKayu="error", estimasi="hari", konfirmasi;

System.out.println("-------------------------------------- Pemesanan Pengiriman ------------------------------------------------");
do {
    System.out.print("\nJenis barang : Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen ");
    System.out.println("\nMasukkan jenis barang\t\t\t\t: ");
    jnsBarang=input.nextLine();
    System.out.print("Masukkan berat barang\t\t\t\t: ");
    brtBarang=input.nextFloat();
    System.out.print("Masukkan jenis pengiriman(Reguler/Express)\t: ");
    input.nextLine();
    jnsPengiriman=input.nextLine();
    System.out.print("Masukkan jarak pengiriman\t\t\t: ");
    jrkPengiriman=input.nextFloat();
    System.out.print("Asuransi(Iya/Tidak)\t\t\t\t: ");
    input.nextLine();
    asuransi=input.nextLine();
    System.out.print("Packing kayu(Iya/Tidak)\t\t\t\t: ");
    pckgKayu=input.nextLine();
         
        //menentukan harga
        //harga per kilogram menurut jenis barang & layanan

            if (jnsBarang.equalsIgnoreCase("Barang kecil")) {
                if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                    hargaPerKilogram=3000.0F;    
                } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=5000.0F; 
                    }
                    
                } else if (jnsBarang.equalsIgnoreCase("Barang besar")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        hargaPerKilogram=10000.0F;
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=15000.0F;     
                    }
                    
                } else if (jnsBarang.equalsIgnoreCase("Elektronik kecil")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        hargaPerKilogram=8000.0F;
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=10000.0F;
                    }

                } else if (jnsBarang.equalsIgnoreCase("Elektronik besar")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        hargaPerKilogram=10000.0F;
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=12000.0F;
                    }
                    
                } else if (jnsBarang.equalsIgnoreCase("Pakaian")) {
                    if (jnsPengiriman.equals("Reguler")) {
                        hargaPerKilogram=5000.0F;
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=8000.0F;
                    }
                } else if (jnsBarang.equalsIgnoreCase("Dokumen")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        hargaPerKilogram=2000.0F;
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        hargaPerKilogram=4000.0F;
                    }
                }

                //harga per kilogram menurut jarak pengiriman
                if (jrkPengiriman < 50) {
                    hrgJarak=7000.0F;
                } else if (jrkPengiriman < 100) {
                    hrgJarak=10000.0F;
                } else if (jrkPengiriman < 300 ) {
                    hrgJarak=15000.0F;
                } else if (jrkPengiriman < 500 ) {
                    hrgJarak=20000.0F;
                } else if (jrkPengiriman < 700) {
                    hrgJarak=25000.0F;  
                } else if (jrkPengiriman < 1000) {
                    hrgJarak=35000.0F;
                }

                //menampilkan estimasi waktu
                if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                    estimasi="7-10 Hari";
                } if (jnsPengiriman.equalsIgnoreCase("Express")) {
                    estimasi="3-5 Hari";
                }

                //menentukan asuransi
                if (asuransi.equalsIgnoreCase("Iya")) {
                    hrgAsuransi=10000.0F;
                } else if (asuransi.equalsIgnoreCase("Tidak")) {
                    hrgAsuransi=0.0F;
                }

                //menentukan harga packing kayu
                if (pckgKayu.equalsIgnoreCase("Iya")) {
                    hrgPackingKayu=25000.0F;
                } else if (pckgKayu.equalsIgnoreCase("Tidak")) {
                    hrgPackingKayu=0.0F;
                }     
            

        //menentukan total harga
            ttlHarga=(brtBarang*hargaPerKilogram)+hrgJarak+hrgAsuransi+hrgPackingKayu;

            System.out.println("\nHarga pengiriman\t\t\t\t: Rp " + ttlHarga);
            System.out.println("Estimasi waktu pengiriman\t\t\t: " + estimasi);
        //
                System.out.print("\nApakah anda ingin memambah pesanan?(iya/tidak)\t: ");
                konfirmasi=input.next();
                if (konfirmasi.equalsIgnoreCase("iya")) {
                    continue;
                } else if(konfirmasi.equalsIgnoreCase("tidak")) {
                    break;
                }
            } while (!konfirmasi.equalsIgnoreCase("tidak"));    
        
        // output hasil
        float ttlSemua=0;
                ttlSemua += ttlHarga;
        System.out.println("\nTotal Harga pengiriman\t\t\t\t: Rp " + ttlSemua);

        System.out.println("----------------------------------------------------------------------------------------------------");

        input.close();
        }
//inventori barang
else if (opsiPilihan == 2){
while(!exitTrigger) {
    byte pilihan = 0;
    String nama = "";
    String alamat = "";
    float berat = 0f;
    System.out.println("\tInventori Barang\t");
    System.out.println("1.) Menambahkan data paket");
    System.out.println("2.) Melihat list data paket");
    System.out.println("3.) Menghapus data paket");
    System.out.println("4.) Kembali ke menu utama");
    System.out.print(": ");
    pilihan = input.nextByte();
    input.nextLine();

    if (pilihan == 1) {
        System.out.println("Masukkan nama paket: ");
        nama = input.nextLine();
        System.out.println("Masukkan alamat paket: ");
        alamat = input.nextLine();
        System.out.println("Masukkan berat paket: ");
        berat = input.nextFloat();

    } else if (pilihan == 2) {
            System.out.println("\nNama: " + nama + "\nAlamat: " + alamat + "\nBerat: " + berat);
    } else if (pilihan == 3) {
        System.out.print("Masukkan nama dari detail paket yang hendak dihapus: ");
        nama = input.nextLine();

        String confirmation = "n";
        System.out.print("Apakah anda yakin untuk menghapus data tersebut? : ");
        confirmation = input.next();
        if (confirmation.equals("y")) {
        }
    } else if (pilihan == 4) {
        exitTrigger = true;
    } else {
        System.out.println("Tolong masukkan nomor sesuai opsi yang akan dipilih");
    }

    String confirmation = "n";
    System.out.print("Apakah anda hendak melakukan aksi lain: (y/n) ");
    confirmation = input.next();

    if (confirmation.equals("n")) {
        input.close();
        exitTrigger = true;
    }
    }
} else{
    System.out.println("Opsi yang anda pilih tidak tersedia");
    }       
} while (opsiPilihan != 2);  
}
}
}
    

