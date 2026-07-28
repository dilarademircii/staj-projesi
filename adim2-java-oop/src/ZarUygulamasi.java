import java.util.Random;

public class ZarUygulamasi {
    public static void main(String[] args) {
        Random random = new Random();

        // Zarda 6 yüz olduğu için 6 elemanlı bir dizi (diziler 0'dan başlar)
        int[] zarlar = new int[6];

        // 1 Milyon kere zar atıyoruz
        for (int i = 0; i < 1000000; i++) {
            int zar = random.nextInt(6); // 0 ile 5 arasında rastgele sayı üretir
            zarlar[zar]++;               // Gelen zarın sayısını 1 artırır
        }

        System.out.println("=== ZAR ATMA SONUÇLARI ===");

        int enCokGelenZar = 1;
        int enCokMiktar = zarlar[0];

        // Sonuçları yazdırıp en çoğunu buluyoruz
        for (int i = 0; i < 6; i++) {
            int zarYuzu = i + 1; // Ekrana 1, 2, 3, 4, 5, 6 olarak yazsın diye
            System.out.println("Zar " + zarYuzu + " : " + zarlar[i] + " defa geldi.");

            if (zarlar[i] > enCokMiktar) {
                enCokMiktar = zarlar[i];
                enCokGelenZar = zarYuzu;
            }
        }

        System.out.println("\nEn çok gelen zar: " + enCokGelenZar + " (" + enCokMiktar + " defa)");
    }
}
