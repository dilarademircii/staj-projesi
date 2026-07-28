public class Main {
    public static void main(String[] args) {
        // OOP Nesne Oluşturma
        Yazilimci yazilimci = new Yazilimci("Dilara", 85000, "Java & Spring Boot");

        System.out.println("=== ÇALIŞAN BİLGİLERİ ===");
        System.out.println("İsim: " + yazilimci.getIsim());
        System.out.println("Maaş: " + yazilimci.getMaas() + " TL");
        System.out.println("Uzmanlık: " + yazilimci.getYazilimDili());

        System.out.println("\n=== METOT ÇAĞRILARI ===");
        yazilimci.calis();   // Polymorphism örneği
        yazilimci.kodYaz();  // Interface örneği

        System.out.println("\n=== ENCAPSULATION TESTİ ===");
        yazilimci.setMaas(-5000); // Geçersiz maaş kontrolü
        System.out.println("Güncel Maaş: " + yazilimci.getMaas() + " TL");
    }
}