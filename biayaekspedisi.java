
import java.util.Scanner;

public class biayaekspedisi {
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);

    //input data
    double brtBarang, jrkPengiriman, ttlHarga, hargaPerKilogram=0, hrgJarak=0, hrgAsuransi=0, hrgPackingKayu=0, hargaAkhir=0;
    String jnsPengiriman, asuransi, pckgKayu="error", estimasi="hari", konfirmasi;
    
    
    System.out.print("Jumlah paket yang ingin anda kiriman: ");
    int jmlPaket=input.nextInt();
    
    int[] paket = new int[jmlPaket]; 
    String[] jnsBarang = new String[jmlPaket];
    int[] resi = new int[jmlPaket];
    
    System.out.println("-------------------------------------- INPUT PESANAN ------------------------------------------------");
    
    int i=0;
    while (true) {
        
        System.out.print("\nJenis barang: Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen \n");
        System.out.print("Masukkan jenis barang\t\t\t\t: ");
        jnsBarang[i]=input2.nextLine();
        System.out.print("Masukkan berat barang\t\t\t\t: ");
        brtBarang=input.nextDouble();
        System.out.print("Masukkan jenis pengiriman(Reguler/Express)\t: ");
        // input2.nextLine();
        jnsPengiriman=input2.nextLine();
        System.out.print("Masukkan jarak pengiriman\t\t\t: ");
        jrkPengiriman=input.nextDouble();
        System.out.print("Asuransi(Iya/Tidak)\t\t\t\t: ");
        // input2.nextLine();
        asuransi=input2.nextLine();
        System.out.print("Packing kayu(Iya/Tidak)\t\t\t\t: ");
        pckgKayu=input2.nextLine();

                
            //menentukan harga
            //harga per kilogram menurut jenis barang & layanan

                if (jnsBarang[i].equalsIgnoreCase("Barang kecil")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        hargaPerKilogram=3000.0;    
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=5000.0; 
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Barang besar")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            hargaPerKilogram=10000.0;
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=15000.0;     
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Elektronik kecil")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            hargaPerKilogram=8000.0;
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=10000.0;
                        }

                    } else if (jnsBarang[i].equalsIgnoreCase("Elektronik besar")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            hargaPerKilogram=10000.0;
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=12000.0;
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Pakaian")) {
                        if (jnsPengiriman.equals("Reguler")) {
                            hargaPerKilogram=5000.0;
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=8000.0;
                        }
                    } else if (jnsBarang[i].equalsIgnoreCase("Dokumen")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            hargaPerKilogram=2000.0;
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            hargaPerKilogram=4000.0;
                        }
                    }

                    //harga per kilogram menurut jarak pengiriman
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

                    //menampilkan estimasi waktu
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        estimasi="7-10 Hari";
                    } if (jnsPengiriman.equalsIgnoreCase("Express")) {
                        estimasi="3-5 Hari";
                    }

                    //menentukan asuransi
                    if (asuransi.equalsIgnoreCase("Iya")) {
                        hrgAsuransi=10000.0;
                    } else if (asuransi.equalsIgnoreCase("Tidak")) {
                        hrgAsuransi=0.0;
                    }

                    //menentukan harga packing kayu
                    if (pckgKayu.equalsIgnoreCase("Iya")) {
                        hrgPackingKayu=25000.0;
                    } else if (pckgKayu.equalsIgnoreCase("Tidak")) {
                        hrgPackingKayu=0.0;
                    }     
                    
                    
                    //menentukan total harga
                    ttlHarga=(brtBarang*hargaPerKilogram)+hrgJarak+hrgAsuransi+hrgPackingKayu;
                    hargaAkhir = hargaAkhir + ttlHarga;
                    
                    
                    System.out.print("\nHarga pengiriman\t\t\t\t: Rp " + ttlHarga);
                    System.out.print("\nEstimasi waktu pengiriman\t\t\t: " + estimasi + "\n");
                    //
                    //resi saya tentukan berdasarkan pesanan ke berapa pada hari itu
                    if (jnsBarang[i].equalsIgnoreCase("Barang kecil")) {
                    if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                        resi[i] = i+1;
                        System.out.println("Nomer resi anda \t\t\t\t: BKR"+resi[i]);    
                    } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: BKE"+resi[i]);
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Barang besar")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: BBR"+resi[i]);
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: BBE"+resi[i]);     
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Elektronik kecil")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: EKR"+resi[i]);
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: EKE"+resi[i]);
                        }

                    } else if (jnsBarang[i].equalsIgnoreCase("Elektronik besar")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: EBR"+resi[i]);
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: EBE"+resi[i]);
                        }
                        
                    } else if (jnsBarang[i].equalsIgnoreCase("Pakaian")) {
                        if (jnsPengiriman.equals("Reguler")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: PR"+resi[i]);
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: PE"+resi[i]);
                        }
                    } else if (jnsBarang[i].equalsIgnoreCase("Dokumen")) {
                        if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: DR"+resi[i]);
                        } else if (jnsPengiriman.equalsIgnoreCase("Express")) {
                            resi[i] = i+1;
                            System.out.println("Nomer resi anda \t\t\t\t: DE"+resi[i]);
                        }
                    }
                    
                    System.out.print("\nApakah anda ingin memambah pesanan?(iya/tidak)\t: ");
                    konfirmasi=input.next();
                    if (konfirmasi.equalsIgnoreCase("iya")) {
                        continue;
                    } else if(konfirmasi.equalsIgnoreCase("tidak")) {
                        break;
                    }
                    i++;
                    

                } 
            
            // output hasil

            System.out.println("\n----------------------------------------------------------------------------------------------------");   
            for (int j = 0; j < paket.length; j++) {
                System.out.print("\nJenis barang ke-" + (j+1) + " \t\t\t\t: " + jnsBarang[i]);
            }

            System.out.print("\nTotal Harga pengiriman\t\t\t\t: Rp " + hargaAkhir);
            System.out.println("\n----------------------------------------------------------------------------------------------------");

            input.close();
            input2.close();
    }
    
}
