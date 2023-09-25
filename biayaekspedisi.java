package projectsem1;

import java.util.Scanner;

public class biayaekspedisi {
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    //input data
    float brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0;
    String jnsLayanan, jnsPengiriman, estimasi="hari";

    System.out.println("Masukkan berat barang: ");
    brtBarang=input.nextFloat();
    System.out.println("Masukkan jenis layanan(Darat/Laut/Udara): ");
    jnsLayanan=input.next();
    System.out.println("Masukkan jenis pengiriman(Reguler/Express/Kargo): ");
    jnsPengiriman=input.next();
    System.out.println("Masukkan jarak pengiriman: ");
    jrkPengiriman=input.nextFloat();

    
    //menentukan harga

    if (jnsLayanan.equals("Darat")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=2000.0F;    
        } else if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=4000.0F; 
       
        }
        
    } else if (jnsLayanan.equals("Laut")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=3000.0F;
        } else if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=5000.0F;  
            
        }
        
    } else if (jnsLayanan.equals("Udara")) {
        if (jnsPengiriman.equals("Reguler")) {
            hargaPerKilogram=10000.0F;
        } if (jnsPengiriman.equals("Express")) {
            hargaPerKilogram=15000.0F;

        }

    }

    //menentukan total harga
        ttlHarga=brtBarang*hargaPerKilogram;

    //menampilkan estimasi waktu

    if (jnsLayanan.equals("Darat")) {
        estimasi="3-5 Hari";
    } if (jnsLayanan.equals("Laut")) {
        estimasi="7-14 Hari";
    } if (jnsLayanan.equals("Udara")) {
        estimasi="1-2 Hari";
    }

    // output hasil
    System.out.println("Harga pengiriman Rp: " + ttlHarga);
    System.out.println("Estimasi waktu pengiriman: " + estimasi);

    input.close();
    }
    
}
