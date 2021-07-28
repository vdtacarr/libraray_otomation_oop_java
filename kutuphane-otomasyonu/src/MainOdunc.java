import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import nesne.Kitap;
import nesne.Odunc;
import nesne.Okur;

import sql.Baglan;
import sql.DBKitap;
import sql.DBOdunc;
import sql.DBOkur;

public class MainOdunc {
	public enum Hata{
		HATA_VAR,L�STE_BO�
	}
	public static void oduncMain(Scanner scan){
		boolean oduncDevammi = true;
		while(oduncDevammi){
			System.out.println("Od�n�le ilgili yapmak istedi�iniz i�lemi se�iniz");
			System.out.println("1-�d�n� ver\n2-�d�n� Al\n3-Listele\n4-Okur ��k��");
			int secim = scan.nextInt();
			switch (secim) {
			case 1:
				oduncVer(scan);
				break;
			case 2:
				oduncAl(scan);
				break;
			case 3:
				listele();
				break;
			case 4:
				oduncDevammi = false;
				break;
			default:
				System.out.println("Yanl�� se�im yapt�n�z.");
				break;
			}
		}
	}
	
	public static void listele(){
		Baglan baglan = Baglan.getInstance();
		DBOdunc dbOdunc = new DBOdunc();
		ArrayList<Odunc> oduncler = dbOdunc.listele(baglan.getStmt());
		if(oduncler == null){
			System.err.println(Hata.HATA_VAR);
			return;
		}
		
		if(oduncler.size() == 0){
			System.out.println(Hata.L�STE_BO�);
			return;
		}
		
		for (Odunc odunc : oduncler) {
			DBOkur dbOkur = new DBOkur();
			Okur okur = dbOkur.getirId(baglan.getStmt(), odunc.getOkurId());
			DBKitap dbKitap = new DBKitap();
			Kitap kitap = dbKitap.getirId(baglan.getStmt(), odunc.getKitapId());
			System.out.println(
					odunc.getAlimTarihiTypeString()
					+ " " +
					odunc.getTeslimTarihiTypeString()
					+ " " +
					okur.getAd()
					+ " " +
					okur.getSoyad()
					+ " " +
					kitap.getKitapAdi()
					);
		}
	}
	
	public static void oduncVer(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBOdunc dbOdunc = new DBOdunc();
		MainOkur.listele();
		System.out.print("�d�n� vermek istedi�iniz okurun idsini giriniz: ");
		int okurId = scan.nextInt();
		MainKitap.listele();
		System.out.print("�d�n� vermek istedi�iniz kitab�n idsini giriniz: ");
		int kitapId = scan.nextInt();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tarih = new Date();
		try {
			Date almaTarihi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat.format(tarih));
			Odunc odunc = new Odunc(okurId,kitapId,almaTarihi);
			dbOdunc.ekle(baglan.getStmt(), odunc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void oduncAl(Scanner scan){
		Baglan baglan = Baglan.getInstance();
		DBOdunc dbOdunc = new DBOdunc();
		DBOkur dbOkur = new DBOkur();
		MainOkur.listele();
		System.out.println("Teslim etmek isteyen okur idsi: ");
		int okurId = scan.nextInt();
		Okur okur = dbOkur.getirId(baglan.getStmt(), okurId);
		if(okur == null){
			System.err.println("Okur bulunamad�");
			return;
		}
		MainKitap.listele();
		System.out.println("Teslim etmek istenen kitap idsi: ");
		int kitapId = scan.nextInt();
		Odunc odunc = dbOdunc.getirOkurVeKitapId(baglan.getStmt(), okurId, kitapId);
		if(odunc == null){
			System.err.println("�d�n� Kayd� bulunamad�");
			return;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tarih = new Date();
		try {
			Date teslimTarihi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat.format(tarih));
			int cezaPuani = odunc.setTeslimTarihi(teslimTarihi);
			dbOdunc.guncelle(baglan.getStmt(), odunc);
			okur.setCezaPuani(cezaPuani);
			dbOkur.guncelle(baglan.getStmt(), okur);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
