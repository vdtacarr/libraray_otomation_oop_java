CREATE DATABASE KUTUPHANE;
USE KUTUPHANE;


CREATE TABLE IF NOT EXISTS yazarlar (
	id INT AUTO_INCREMENT PRIMARY KEY,
    adi VARCHAR(255) ,
    soyadi VARCHAR(255) , 
    olusturulma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP,
    guncelleme_tarihi DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS kitaplar (
	id INT AUTO_INCREMENT PRIMARY KEY,
    adi VARCHAR(255) ,
    barkod VARCHAR(255) , 
    sayfa_sayisi VARCHAR(255),
    baski VARCHAR(255),
    stok INT,
    tur_id INT,
    yazar_id INT,     
    olusturulma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP,
    guncelleme_tarihi DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS turler (
	id INT AUTO_INCREMENT PRIMARY KEY,
    adi VARCHAR(255) ,
    olusturulma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP,
    guncelleme_tarihi DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS okurlar (
	id INT AUTO_INCREMENT PRIMARY KEY,
    adi VARCHAR(255) ,
    soyadi VARCHAR(255),
    ceza_puan int,
    telefon varchar(255),
    olusturulma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP,
    guncelleme_tarihi DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS oduncler (
	id INT AUTO_INCREMENT PRIMARY KEY,
    alim_tarih VARCHAR(255) ,
    teslim_tarih VARCHAR(255),
    okur_id int,
    kitap_id int,    
    olusturulma_tarihi DATETIME DEFAULT CURRENT_TIMESTAMP,
    guncelleme_tarihi DATETIME ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS kullanicilar (
	id INT AUTO_INCREMENT PRIMARY KEY,
    adi VARCHAR(255) ,
    sifre VARCHAR(255)
) ENGINE=INNODB;

select * from yazarlar;
select * from kitaplar;
select * from turler;
select * from okurlar;
select * from oduncler;

#INSERT INTO YAZARLAR (adi,soyadi) VALUES ('Mehmet', 'Helveci');
#INSERT INTO YAZARLAR (adi,soyadi) VALUES ('Alpay', 'Ak');
#INSERT INTO YAZARLAR (adi,soyadi) VALUES ('Nejat', 'Kara');



