// Encapsulation & Constructor & Abstraction örneği
public abstract class Calisan {
    private String isim;
    private double maas;

    // Constructor (Kurucu)
    public Calisan(String isim, double maas) {
        this.isim = isim;
        this.maas = maas;
    }

    // Abstract Metot (Alt sınıflar bunu kendine göre doldurmak ZORUNDA)
    public abstract void calis();

    // Encapsulation için Getter ve Setter metotları
    public String getIsim() {
        return isim;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        if (maas > 0) {
            this.maas = maas;
        } else {
            System.out.println("Geçersiz maaş tutarı!");
        }
    }
}
