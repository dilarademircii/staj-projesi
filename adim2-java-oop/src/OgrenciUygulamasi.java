import java.util.*;

public class OgrenciUygulamasi {
    public static void main(String[] args) {

        // Öğrencilerimizi oluşturalım
        Student ogrenci1 = new Student("Ali", "Yılmaz", "101", 85.0);
        Student ogrenci2 = new Student("Ayşe", "Kaya", "102", 92.5);
        Student ogrenci3 = new Student("Mehmet", "Demir", "103", 70.0);

        // --- 1. LIST İLE EKLEME VE LİSTELEME ---
        List<Student> ogrenciListesi = new ArrayList<>();
        ogrenciListesi.add(ogrenci1);
        ogrenciListesi.add(ogrenci2);
        ogrenciListesi.add(ogrenci3);

        System.out.println("=== 1. TÜM ÖĞRENCİLER (List) ===");
        for (Student s : ogrenciListesi) {
            System.out.println(s);
        }

        // --- 2. SİLME İŞLEMİ ---
        ogrenciListesi.remove(ogrenci3); // Mehmet'i listeden sildik
        System.out.println("\n(Mehmet silindi. Kalan öğrenci sayısı: " + ogrenciListesi.size() + ")");

        // --- 3. SET KULLANIMI (Benzersiz Öğrenci Kimlikleri) ---
        Set<String> ogrenciNumaralari = new HashSet<>();
        ogrenciNumaralari.add("101");
        ogrenciNumaralari.add("102");
        ogrenciNumaralari.add("101"); // Tekrar eden numara eklenmez

        // --- 4. MAP KULLANIMI (Numara ile Öğrenci Arama) ---
        Map<String, Student> ogrenciHaritasi = new HashMap<>();
        ogrenciHaritasi.put(ogrenci1.getNumara(), ogrenci1);
        ogrenciHaritasi.put(ogrenci2.getNumara(), ogrenci2);

        System.out.println("\n=== 2. MAP İLE NUMARADAN ÖĞRENCİ BULMA ===");
        System.out.println("102 Numaralı Öğrenci: " + ogrenciHaritasi.get("102"));

        // --- 5. NOTLARA GÖRE SIRALAMA (List Üzerinde) ---
        // Notu yüksekten düşüğe doğru sıralıyoruz
        ogrenciListesi.sort((s1, s2) -> Double.compare(s2.getNot(), s1.getNot()));

        System.out.println("\n=== 3. NOTLARA GÖRE SIRALI (Yüksekten Düşüğe) ===");
        for (Student s : ogrenciListesi) {
            System.out.println(s);
        }

        // --- 6. ORTALAMA HESAPLAMA ---
        double toplamNot = 0;
        for (Student s : ogrenciListesi) {
            toplamNot += s.getNot();
        }
        double ortalama = toplamNot / ogrenciListesi.size();

        System.out.println("\n--------------------------------");
        System.out.println("Sınıf Not Ortalaması: " + ortalama);
    }
}
