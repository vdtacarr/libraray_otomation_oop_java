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
			System.out.println("Kitaplarla ilgili yapmak istediðiniz iþlemi seçiniz");
			System.out.println("1-Ekle\n2-Sil\n3-Listele\n4-Kitap çýkýþ");
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
				System.out.println("Yanlýþ seçim yaptýnýz.");
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
				System.out.println("Liste Boþ");
			}
		} else {
			System.err.println("Hata var");
		}
		
	}
	
	public static void sil(Scanner scan){
		listele();
		System.out.print("Silmek istediðiniz kitabýn idsini giriniz");
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
			System.out.println("Yazar listen boþ önce yazar ekle");
			return;
		}
		
		if(dbTur.listele(baglan.getStmt()).size() == 0){
			System.out.println("Tür listen boþ önce tür ekle");
			return;
		}
		DBKitap dbKitap = new DBKitap();
		
		System.out.print("Eklemek istediðiniz kitabýn adý: ");
		
		scan.nextLine(); 
		// next intden next line geçerken oluþan hataya çözüm
		
		String kitapAdi = scan.nextLine();
		System.out.print("Eklemek istediðiniz kitabýn barkodu: ");
		String barkod = scan.nextLine();
		System.out.print("Eklemek istediðiniz kitabýn sayfa sayýsý: ");
		String sayfaSayisi = scan.nextLine();
		System.out.print("Eklemek istediðiniz kitabýn baský sayýsý: ");
		String baski = scan.nextLine();
		System.out.print("Eklemek istediðiniz kitap kaç tane: ");
		int stok = scan.nextInt();
		MainTur.listele();
		System.out.print("Eklemek istediðiniz kitabýn tur idsini giriniz: ");
		int turId = scan.nextInt();
		MainYazar.listele();
		System.out.print("Eklemek istediðiniz kitabýn yazar idsini giriniz: ");
		int yazarId = scan.nextInt();
		Kitap kitap = new Kitap(kitapAdi, barkod, sayfaSayisi, baski, stok, turId, yazarId);
		dbKitap.ekle(baglan.getStmt(), kitap);
	}
}
