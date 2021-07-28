import java.util.ArrayList;
import java.util.Scanner;

import nesne.Tur;
import sql.Baglan;
import sql.DBTur;


public class MainTur {
	public static void turMain(Scanner scan){
		boolean turDevammi = true;
		while(turDevammi){
			System.out.println("T�rle ilgili yapmak istedi�iniz i�lemi se�iniz");
			System.out.println("1-Ekle\n2-Sil\n3-Listele\n4-T�r ��k��");
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
				turDevammi = false;
				break;
			default:
				System.out.println("Yanl�� se�im yapt�n�z.");
				break;
			}
		}
	}
	
	public static void listele(){
		Baglan baglan = Baglan.getInstance();
		DBTur dbTur = new DBTur();
		ArrayList<Tur> turler = dbTur.listele(baglan.getStmt());
		if(turler != null) {
			for(int i = 0; i < turler.size(); i++){
				Tur tur = turler.get(i);
				System.out.println(
						tur.getId() + 
						" " +
						tur.getAd() +
						" " + 
						tur.getOlusturmaTarihi() +
						" " +
						tur.getGuncellenmeTarihi());
			}
			if(turler.size() == 0){
				System.out.println("Liste Bo�");
			}
		} else {
			System.err.println("Hata var");
		}
		
	}
	
	public static void sil(Scanner scan){
		listele();
		System.out.print("Silmek istedi�iniz t�r�n idsini giriniz");
		int id = scan.nextInt();
		Baglan baglan = Baglan.getInstance();
		DBTur dbTur = new DBTur();
		dbTur.sil(baglan.getStmt(), id);
	}
	
	public static void ekle(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBTur dbTur = new DBTur();
		
		System.out.print("Eklemek istedi�iniz t�r�n ad�: ");
		
		scan.nextLine(); 

		String ad = scan.nextLine();
		
		Tur tur = new Tur(ad);
		
		dbTur.ekle(baglan.getStmt(), tur);
	}
}
