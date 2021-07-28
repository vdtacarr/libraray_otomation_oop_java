package nesne;

import java.util.Date;

public class Yazar extends Tarihler {
	private String ad;
	private String soyad;
	
	public Yazar(String ad, String soyad){
		super();
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public Yazar(int id, String ad, String soyad, Date olusturmaTarihi, Date guncellemeTarihi) {
		super(id, olusturmaTarihi, guncellemeTarihi);
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public String getAd() {
		return ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public String toString(){
		return ad + " " + soyad;
	}
	
}
