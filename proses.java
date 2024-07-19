/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HERHabibHaris;

/**
 *
 * @author ACER
 */
public class proses {
    public static void main(String[] args) {
        pdam pdam = new pdam("23332233", "Habib Haris", "GOLD", "2024-07-19", 50, 30);
        
        calculateTotalBayar(pdam);
        
        System.out.println("Kode Pembayaran: " + pdam.getKodePembayaran());
        System.out.println("Nama Pelanggan: " + pdam.getNamaPelanggan());
        System.out.println("Jenis Pelanggan: " + pdam.getJenisPelanggan());
        System.out.println("Tanggal: " + pdam.getTanggal());
        System.out.println("Meter Bulan Ini: " + pdam.getMeterBulanIni());
        System.out.println("Meter Bulan Lalu: " + pdam.getMeterBulanLalu());
        System.out.println("Total Bayar: " + pdam.getTotalBayar());
    }

    public static void calculateTotalBayar(pdam pdam) {
        int meterPakai = pdam.getMeterBulanIni() - pdam.getMeterBulanLalu();
        double totalBayar = 0;

        switch (pdam.getJenisPelanggan().toUpperCase()) {
            case "GOLD" -> totalBayar = calculateBill(meterPakai, 5000, 10000, 20000);
            case "SILVER" -> totalBayar = calculateBill(meterPakai, 4000, 8000, 10000);
            case "UMUM" -> totalBayar = calculateBill(meterPakai, 2000, 3000, 5000);
            default -> {
                System.out.println("Jenis Pelanggan tidak valid.");
                return;
            }
        }

        pdam.setTotalBayar(totalBayar);
    }

    private static double calculateBill(int meterPakai, int rate1, int rate2, int rate3) {
        double total = 0;
        if (meterPakai <= 10) {
            total = meterPakai * rate1;
        } else if (meterPakai <= 20) {
            total = 10 * rate1 + (meterPakai - 10) * rate2;
        } else {
            total = 10 * rate1 + 10 * rate2 + (meterPakai - 20) * rate3;
        }
        return total;
    }
}
