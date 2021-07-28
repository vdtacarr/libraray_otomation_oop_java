import java.util.ArrayList;
import java.util.Scanner;

import nesne.Yazar;

import sql.Baglan;
import sql.DBYazar;


public class MainYazar {
	public static void yazarMain(Scanner scan){
		boolean yazarDevammi = true;
		while(yazarDevammi){
			System.out.println("Yazarla ilgili yapmak istediðiniz iþlemi seçiniz");
			System.out.println("1-Ekle\n2-Sil\n3-Listele\n4-Yazar çýkýþ");
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
				yazarDevammi = false;
				break;
			default:
				System.out.println("Yanlýþ seçim yaptýnýz.");
				break;
			}
		}
	}
	
	public static void listele(){
		Baglan baglan = Baglan.getInstance();
		DBYazar dbYazar = new DBYazar();
		ArrayList<Yazar> yazarlar = dbYazar.listele(baglan.getStmt());
		if(yazarlar != null) {
			for(int i = 0; i < yazarlar.size(); i++){
				Yazar yazar = yazarlar.get(i);
				System.out.println(
						yazar.getId() + 
						" " +
						yazar.getAd() +
						" " + 
						yazar.getSoyad() + 
						" " + 
						yazar.getOlusturmaTarihi() +
						" " +
						yazar.getGuncellenmeTarihi());
			}
			if(yazarlar.size() == 0){
				System.out.println("Liste Boþ");
			}
		} else {
			System.err.println("Hata var");
		}
		
	}
	
	public static void sil(Scanner scan){
		listele();
		System.out.print("Silmek istediðiniz yazarýn idsini giriniz");
		int id = scan.nextInt();
		Baglan baglan = Baglan.getInstance();
		DBYazar dbYazar = new DBYazar();
		dbYazar.sil(baglan.getStmt(), id);
	}
	
	public static void ekle(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBYazar dbYazar = new DBYazar();
		
		System.out.print("Eklemek istediðiniz yazarýn adý: ");
		
		scan.nextLine(); 
		// next intden next line geçerken oluþan hataya çözüm
		
		String ad = scan.nextLine();
		System.out.print("Eklemek istediðiniz yazarýn soyadi: ");
		String soyad = scan.nextLine();
		
		Yazar yazar = new Yazar(ad,soyad);
		
		dbYazar.ekle(baglan.getStmt(), yazar);
	}
}
