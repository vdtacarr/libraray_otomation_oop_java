import java.util.ArrayList;
import java.util.Scanner;

import nesne.Kitap;
import nesne.Tur;
import nesne.Yazar;
import sql.Baglan;
import sql.DBKitap;
import sql.DBTur;
import sql.DBYazar;


public class MainKitap {
	public static void kitapMain(Scanner scan){
		boolean kitapDevammi = true;
		while(kitapDevammi){
			System.out.println("Kitaplarla ilgili yapmak istedi�iniz i�lemi se�iniz");
			System.out.println("1-Ekle\n2-Sil\n3-Listele\n4-Kitap ��k��");
			int secim = scan.nextInt();
			switch (secim) {
			case 1:
				ekle(scan);
				break;
			case 2:
				sil(scan);
				break;
			case 3:
				listele();
				break;
			case 4:
				kitapDevammi = false;
				break;
			default:
				System.out.println("Yanl�� se�im yapt�n�z.");
				break;
			}
		}
	}
	
	public static void listele(){
		Baglan baglan = Baglan.getInstance();
		DBKitap dbKitap = new DBKitap();
		ArrayList<Kitap> kitaplar = dbKitap.listele(baglan.getStmt());
		if(kitaplar != null) {
			for(int i = 0; i < kitaplar.size(); i++){
				Kitap kitap = kitaplar.get(i);
				DBYazar dbYazar = new DBYazar();
				Yazar yazar = dbYazar.getir(baglan.getStmt(), kitap.getYazarId());
				DBTur dbTur = new DBTur();
				Tur tur = dbTur.getir(baglan.getStmt(), kitap.getTurId());
				System.out.println(
						kitap.getId() + 
						" " +
						kitap.getKitapAdi() +
						" " + 
						kitap.getBarkod() +
						" " + 
						kitap.getSayfaSayisi() +
						" " + 
						kitap.getBaski() +
						" " + 
						kitap.getStok() +
						" " + 
						tur.getAd() +
						" " +
						yazar.getAd() + 
						" " +
						yazar.getSoyad() + 
						" " +
						kitap.getOlusturmaTarihi() +
						" " +
						kitap.getGuncellenmeTarihi());
			}
			if(kitaplar.size() == 0){
				System.out.println("Liste Bo�");
			}
		} else {
			System.err.println("Hata var");
		}
		
	}
	
	public static void sil(Scanner scan){
		listele();
		System.out.print("Silmek istedi�iniz kitab�n idsini giriniz");
		int id = scan.nextInt();
		Baglan baglan = Baglan.getInstance();
		DBKitap dbKitap = new DBKitap();
		dbKitap.sil(baglan.getStmt(), id);
	}
	
	public static void ekle(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBYazar dbYazar = new DBYazar();
		DBTur dbTur = new DBTur();
		if(dbYazar.listele(baglan.getStmt()).size() == 0){
			System.out.println("Yazar listen bo� �nce yazar ekle");
			return;
		}
		
		if(dbTur.listele(baglan.getStmt()).size() == 0){
			System.out.println("T�r listen bo� �nce t�r ekle");
			return;
		}
		DBKitap dbKitap = new DBKitap();
		
		System.out.print("Eklemek istedi�iniz kitab�n ad�: ");
		
		scan.nextLine(); 
		// next intden next line ge�erken olu�an hataya ��z�m
		
		String kitapAdi = scan.nextLine();
		System.out.print("Eklemek istedi�iniz kitab�n barkodu: ");
		String barkod = scan.nextLine();
		System.out.print("Eklemek istedi�iniz kitab�n sayfa say�s�: ");
		String sayfaSayisi = scan.nextLine();
		System.out.print("Eklemek istedi�iniz kitab�n bask� say�s�: ");
		String baski = scan.nextLine();
		System.out.print("Eklemek istedi�iniz kitap ka� tane: ");
		int stok = scan.nextInt();
		MainTur.listele();
		System.out.print("Eklemek istedi�iniz kitab�n tur idsini giriniz: ");
		int turId = scan.nextInt();
		MainYazar.listele();
		System.out.print("Eklemek istedi�iniz kitab�n yazar idsini giriniz: ");
		int yazarId = scan.nextInt();
		Kitap kitap = new Kitap(kitapAdi, barkod, sayfaSayisi, baski, stok, turId, yazarId);
		dbKitap.ekle(baglan.getStmt(), kitap);
	}
}
