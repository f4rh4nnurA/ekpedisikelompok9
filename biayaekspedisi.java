package projectsem1;

import java.util.Scanner;

public class biayaekspedisi {
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    //input data
    float brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0, hrgJarak=0;
    String jnsBarang, jnsPengiriman, estimasi="hari";

    System.out.println("------------ INPUT HARGA ------------");

    System.out.println("Masukkan jenis barang (Barang.kecil/Barang.besar/Elektronik.kecil/Elektronik.besar/Pakaian/Dokumen): ");
    jnsBarang=input.next();
    System.out.println("Masukkan berat barang: ");
    brtBarang=input.nextFloat();
    System.out.println("Masukkan jenis pengiriman(Reguler/Express): ");
    jnsPengiriman=input.next();
    System.out.println("Masukkan jarak pengiriman: ");
    jrkPengiriman=input.nextFloat();

    
    //menentukan harga

    //harga per kilogram menurut jenis barang & layanan
    if (jnsBarang.equals("Barang.kecil")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=3000.0F;    
        } else if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=5000.0F; 
        }
        
    } else if (jnsBarang.equals("Barang.besar")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=10000.0F;
        } else if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=15000.0F;     
        }
        
    } else if (jnsBarang.equals("Elektronik.kecil")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=8000.0F;
        } else if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=10000.0F;
        }

    } else if (jnsBarang.equals("Elektronik.besar")) {
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
    }

    //menentukan total harga
        ttlHarga=brtBarang*hargaPerKilogram+hrgJarak;

    //menampilkan estimasi waktu
    if (jnsPengiriman.equals("Reguler")) {
        estimasi="7-10 Hari";
    } if (jnsPengiriman.equals("Express")) {
        estimasi="3-5 Hari";
    }

    // output hasil
    System.out.println("\nHarga pengiriman Rp: " + ttlHarga);
    System.out.println("Estimasi waktu pengiriman: " + estimasi);

    input.close();
    }
    
}
