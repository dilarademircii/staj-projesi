// Inheritance: Calisan sınıfından miras alıyor
// Interface: KodYazabilir sözleşmesini uyguluyor
public class Yazilimci extends Calisan implements KodYazabilir {
    private String yazilimDili;

    // Constructor
    public Yazilimci(String isim, double maas, String yazilimDili) {
        super(isim, maas); // Üst sınıfın (Calisan) constructor'ını çağırır
        this.yazilimDili = yazilimDili;
    }

    // Polymorphism: Calisan sınıfındaki abstract metodu kendimize göre dolduruyoruz
    @Override
    public void calis() {
        System.out.println(getIsim() + ", " + yazilimDili + " ile proje geliştiriyor.");
    }

    // Interface'den gelen metot
    @Override
    public void kodYaz() {
        System.out.println(getIsim() + " aktif olarak temiz kod yazıyor.");
    }

    public String getYazilimDili() {
        return yazilimDili;
    }
}