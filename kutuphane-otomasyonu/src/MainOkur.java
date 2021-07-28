import java.util.ArrayList;
import java.util.Scanner;

import nesne.Okur;
import sql.Baglan;
import sql.DBOkur;


public class MainOkur {
	public static void okurMain(Scanner scan){
		boolean okurDevammi = true;
		while(okurDevammi){
			System.out.println("Okurlarla ilgili yapmak istediðiniz iþlemi seçiniz");
			System.out.println("1-Ekle\n2-Sil\n3-Listele\n4-Ceza Öde\n5-Okur çýkýþ");
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
				cezaOde(scan);
				break;
			case 5:
				okurDevammi = false;
				break;
			default:
				System.out.println("Yanlýþ seçim yaptýnýz.");
				break;
			}
		}
	}
	
	public static void cezaOde(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBOkur dbOkur = new DBOkur();
		listele();
		System.out.println("Ceza Ödemek isteyen kullanýcýnýn idsi");
		int id = scan.nextInt();
		Okur okur = dbOkur.getirId(baglan.getStmt(), id);
		System.out.println(okur.getAd() + " " + okur.getSoyad() + " kullanýcýnýn cezasý " + cezaHesapla(okur.getCezaPuani()));
		System.out.print("Ceza ödemek istiyorsa 1:");
		int deger = scan.nextInt();
		if(deger == 1){
			okur.cezaPuaniSifirla();
			dbOkur.guncelle(baglan.getStmt(), okur);
			System.out.println("Ödeme iþlemi baþarýlý");
		} else {
			System.out.println("Ödeme yapýlmadý");
		}
	}
	
	
	public static void listele(){
		Baglan baglan = Baglan.getInstance();
		DBOkur dbOkur = new DBOkur();
		ArrayList<Okur> okurlar = dbOkur.listele(baglan.getStmt());
		
		if(okurlar != null) {
			for(int i = 0; i < okurlar.size(); i++){
				Okur okur = okurlar.get(i);
				System.out.println(
						okur.getId() + 
						" " +
						okur.getAd() + 
						" " +
						okur.getSoyad() +
						" " +
						cezaHesapla(okur.getCezaPuani()) +
						"TL " + 
						okur.getTelefon() +
						" " + 
						okur.getOlusturmaTarihi() +
						" " +
						okur.getGuncellenmeTarihi());
			}
			if(okurlar.size() == 0){
				System.out.println("Liste Boþ");
			}
		} else {
			System.err.println("Hata var");
		}
		
	}
	
	public static double cezaHesapla(int ceza){
		return ceza * 0.10;
	}
	
	public static void sil(Scanner scan){
		listele();
		System.out.print("Silmek istediðiniz okurun idsini giriniz");
		int id = scan.nextInt();
		Baglan baglan = Baglan.getInstance();
		DBOkur dbOkur = new DBOkur();
		dbOkur.sil(baglan.getStmt(), id);
	}
	
	public static void ekle(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBOkur dbOkur = new DBOkur();
		
		System.out.print("Eklemek istediðiniz okurun adý: ");
		
		scan.nextLine(); 
		// next intden next line geçerken oluþan hataya çözüm
		
		String okurunAdi = scan.nextLine();
		System.out.println("Eklemek istediðiniz okurun soyadý: ");
		String okurunSoyadi = scan.nextLine();
		System.out.println("Eklemek istediðiniz okurun telefonu: ");
		String okurunTelefonu = scan.nextLine();
		
		Okur okur = new Okur(okurunAdi, okurunSoyadi, okurunTelefonu);
		dbOkur.ekle(baglan.getStmt(), okur);
	}
}
