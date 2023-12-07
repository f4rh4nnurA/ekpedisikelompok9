import java.util.Scanner;

public class biayaekspedisi {

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

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        // ... (Bagian kode input seperti pada kode sebelumnya)
        double brtBarang, jrkPengiriman, hargaAkhir = 0, ttlHarga = 0;
        String jnsBarang, jnsPengiriman, asuransi, pckgKayu = "error", estimasi = "hari", konfirmasi;

        System.out.print("Jumlah paket yang ingin anda kirimkan: ");
        int jmlPaket = input.nextInt();

        int[] paket = new int[jmlPaket]; 
        String[] jmlBarang = new String[jmlPaket];
        
        int i=0;
        System.out.println("-------------------------------------- INPUT PESANAN ------------------------------------------------");

        
        while (true) {
            // ... (Bagian kode input pesanan seperti pada kode sebelumnya)
            System.out.print("\nJenis barang: Barang Kecil/Barang besar/Elektronik kecil/Elektronik besar/Pakaian/Dokumen \n");
            System.out.print("Masukkan jenis barang\t\t\t\t: ");
            input.nextLine();
            jnsBarang =input.nextLine();
            jmlBarang[i]=jnsBarang;
            i++;
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
            // Memanggil fungsi hitungBiaya untuk menghitung biaya pengiriman
            ttlHarga = hitungBiaya(jnsBarang, brtBarang, jnsPengiriman, jrkPengiriman, asuransi, pckgKayu);
            hargaAkhir = hargaAkhir + ttlHarga; 
            if (jnsPengiriman.equalsIgnoreCase("Reguler")) {
                estimasi="7-10 Hari";
            } if (jnsPengiriman.equalsIgnoreCase("Express")) {
                 estimasi="3-5 Hari";
            }

            // Menampilkan informasi pesanan
            System.out.print("\nHarga pengiriman\t\t\t\t: Rp " + ttlHarga);
            System.out.print("\nEstimasi waktu pengiriman\t\t\t: " + estimasi + "\n");

            // Menampilkan nomor resi
            // ... (Bagian kode menampilkan nomor resi seperti pada kode sebelumnya)

            System.out.print("\nApakah anda ingin menambah pesanan? (iya/tidak)\t: ");
            konfirmasi = input.next();
            if (konfirmasi.equalsIgnoreCase("iya")) {
                continue;
            } else if (konfirmasi.equalsIgnoreCase("tidak")) {
                break;
            }
            
        }

        // Memanggil fungsi tampilkanPesanan untuk menampilkan hasil pesanan
        tampilkanPesanan(paket, jmlBarang, hargaAkhir);

        input.close();
        input2.close();
    }
}