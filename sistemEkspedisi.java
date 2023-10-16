import java.util.Scanner;

public class sistemEkspedisi {
    public static void main (String [] args){
        Scanner input = new Scanner (System.in);
        float brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0, hrgJarak=0, hrgAsuransi=0, hrgPackingKayu=0, noHP_pelanggan;
        String alamatPengirim, alamatTujuan, email, namaBarang,jnsBarang, jnsPengiriman, asuransi, pckgKayu="error", estimasi="hari";
 
       
        
        //input awal pengiriman baranng fitur pemesanan pengiriman
        System.out.print("Masukkan nama barang\t\t\t\t: ");
        namaBarang = input.nextLine();
        System.out.println("-------------------------------------- INPUT HARGA ------------------------------------------------");

        System.out.print("Masukkan jenis barang (Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen)\n\t\t\t\t\t\t: ");
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
        if (jnsBarang.equals("Barang kecil")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=3000.0F;    
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=5000.0F; 
            }
            
        } else if (jnsBarang.equals("Barang besar")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=10000.0F;
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=15000.0F;     
            }
            
        } else if (jnsBarang.equals("Elektronik kecil")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=8000.0F;
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=10000.0F;
            }

        } else if (jnsBarang.equals("Elektronik besar")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=10000.0F;
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=12000.0F;
            }
            
        } else if (jnsBarang.equals("Pakaian")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=5000.0F;
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=8000.0F;
            }
        } else if (jnsBarang.equals("Dokumen")) {
            if (jnsPengiriman.equals("Reguler")) {
                hargaPerKilogram=2000.0F;
            } else if (jnsPengiriman.equals("Express")) {
                hargaPerKilogram=4000.0F;
            }
        }

        //harga per kilogram menurut 
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
        if (jnsPengiriman.equals("Reguler")) {
            estimasi="7-10 Hari";
        } if (jnsPengiriman.equals("Express")) {
            estimasi="3-5 Hari";
        }

        //menentukan asuransi
        if (asuransi.equals("Iya")) {
            hrgAsuransi=10000.0F;
        } else if (asuransi.equals("Tidak")) {
            hrgAsuransi=0.0F;
        }

        //menentukan harga packing kayu
        if (pckgKayu.equals("Iya")) {
            hrgPackingKayu=25000.0F;
        } else if (pckgKayu.equals("Tidak")) {
            hrgPackingKayu=0.0F;
        }

        //menentukan total harga
        ttlHarga=brtBarang*hargaPerKilogram+hrgJarak+hrgAsuransi+hrgPackingKayu;

       
        System.out.println("----------------------------------------------------------------------------------------------------");

        
        System.out.print("Masukkan email anda\t\t\t\t: ");
        email = input.nextLine();
        System.out.print("Masukkan nomor HP anda\t\t\t:");
        noHP_pelanggan = input.nextFloat();
        System.out.print("Masukkan alamat pengirim\t\t\t: ");
        alamatPengirim = input.nextLine();
        alamatPengirim = input.nextLine();
        System.out.print("Masukkan alamat tujuan\t\t\t\t: ");
        alamatTujuan = input.nextLine();
        
        
        //output untuk data pengiriman barang fitur pemesanan pengiriman
        System.out.println("Nama barang\t\t\t\t: " + namaBarang);
        System.out.println("Nomor HP\t\t\t\t: " + noHP_pelanggan);
        System.out.println("Email\t\t\t\t: " + email);
        System.out.println("Alamat pengirim\t\t\t\t: " + alamatPengirim);
        System.out.println("Alamat tujuan\t\t\t\t: " + alamatTujuan);
        System.out.println("Harga pengiriman\t\t\t\t: Rp " + ttlHarga);
        System.out.println("Estimasi waktu pengiriman\t\t\t: " + estimasi);

        input.close();

        
        
        }
    }

    
       
    


