public class Student {
    private String ad;
    private String soyad;
    private String numara;
    private double not;

    // Constructor (Kurucu Metot)
    public Student(String ad, String soyad, String numara, double not) {
        this.ad = ad;
        this.soyad = soyad;
        this.numara = numara;
        this.not = not;
    }

    // Bilgilere erişmek için Getter metotları
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getNumara() { return numara; }
    public double getNot() { return not; }

    // Ekrana kolay yazdırmak için toString metodu
    @Override
    public String toString() {
        return numara + " - " + ad + " " + soyad + " | Not: " + not;
    }
}
