package projectsem1;

import java.util.Scanner;

public class biayaekspedisi {
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    //input data
    float brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0, hrgJarak=0, hrgAsuransi=0, hrgPackingKayu=0;
    String jnsBarang, jnsPengiriman, asuransi, pckgKayu="error", estimasi="hari", konfirmasi;

    System.out.println("-------------------------------------- INPUT HARGA ------------------------------------------------");
    do {
        System.out.print("\nJenis barang: Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen ");
        System.out.print("\nMasukkan jenis barang\t\t\t\t: ");
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
    
}
