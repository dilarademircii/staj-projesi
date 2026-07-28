-- ============================================================
-- ADIM 3: İLİŞKİSEL VERİTABANI VE POSTGRESQL PRATİK NOTLARI
-- ============================================================

-- 1. TABLO OLUŞTURMA (DDL - Data Definition Language)

-- Kullanıcılar Tablosu (One)
CREATE TABLE kullanicilar (
                              id SERIAL PRIMARY KEY, -- Primary Key
                              ad VARCHAR(50) NOT NULL,
                              soyad VARCHAR(50) NOT NULL,
                              eposta VARCHAR(100) UNIQUE NOT NULL
);

-- Ürünler Tablosu
CREATE TABLE urunler (
                         id SERIAL PRIMARY KEY,
                         urun_adi VARCHAR(100) NOT NULL,
                         fiyat DECIMAL(10, 2) NOT NULL,
                         stok INT DEFAULT 0
);

-- Siparişler Tablosu (One-to-Many: 1 Müşteri -> Çok Sipariş)
CREATE TABLE siparisler (
                            id SERIAL PRIMARY KEY,
                            kullanici_id INT REFERENCES kullanicilar(id), -- Foreign Key
                            siparis_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            toplam_tutar DECIMAL(10, 2)
);

-- Sipariş Detay Tablosu (Many-to-Many için Ara/Junction Tablo)
CREATE TABLE siparis_detay (
                               id SERIAL PRIMARY KEY,
                               siparis_id INT REFERENCES siparisler(id),
                               urun_id INT REFERENCES urunler(id),
                               adet INT NOT NULL
);


-- 2. VERİ EKLEME (INSERT - DML)

INSERT INTO kullanicilar (ad, soyad, eposta) VALUES
                                                 ('Dilara', 'Demirci', 'dilara@example.com'),
                                                 ('Ahmet', 'Yılmaz', 'ahmet@example.com');

INSERT INTO urunler (urun_adi, fiyat, stok) VALUES
                                                ('Kablosuz Fare', 450.00, 20),
                                                ('Mekanik Klavye', 1200.00, 15),
                                                ('Oyuncu Kulaklığı', 850.00, 8);

INSERT INTO siparisler (kullanici_id, toplam_tutar) VALUES
                                                        (1, 1650.00), -- Dilara'nın siparişi
                                                        (2, 450.00);   -- Ahmet'in siparişi


-- 3. VERİ SORGULAMA VE JOIN İŞLEMLERİ (SELECT)

-- INNER JOIN: Siparişi olan kullanıcıları ve sipariş detaylarını getirir
SELECT k.ad, k.soyad, s.id AS siparis_no, s.toplam_tutar
FROM kullanicilar k
         INNER JOIN siparisler s ON k.id = s.kullanici_id;

-- LEFT JOIN: Tüm kullanıcıları getirir, siparişi yoksa NULL gösterir
SELECT k.ad, k.soyad, s.id AS siparis_no
FROM kullanicilar k
         LEFT JOIN siparisler s ON k.id = s.kullanici_id;


-- 4. AGGREGATE, GROUP BY VE HAVING KULLANIMI

-- Hangi kullanıcının kaç siparişi var ve toplam kaç TL harcamış?
SELECT k.ad, COUNT(s.id) AS toplam_siparis_sayisi, SUM(s.toplam_tutar) AS toplam_harcama
FROM kullanicilar k
         INNER JOIN siparisler s ON k.id = s.kullanici_id
GROUP BY k.id, k.ad
HAVING SUM(s.toplam_tutar) > 500; -- 500 TL üzeri harcayan grupları filtreler


-- 5. SUBQUERY (ALT SORGU) KULLANIMI

-- Ortalamadan daha pahalı olan ürünleri bulma
SELECT urun_adi, fiyat
FROM urunler
WHERE fiyat > (SELECT AVG(fiyat) FROM urunler);


-- 6. VERİ GÜNCELLEME VE SİLME (UPDATE - DELETE)

UPDATE urunler SET stok = stok - 1 WHERE id = 1;
DELETE FROM urunler WHERE stok = 0;