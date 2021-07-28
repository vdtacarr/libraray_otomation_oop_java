package nesne;

import java.util.Date;

public class Okur extends Tarihler {
	private String ad;
	private String soyad;
	private int cezaPuani;
	private String telefon;
	
	public Okur(String ad, String soyad, String telefon) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.cezaPuani = 0;
		this.telefon = telefon;
	}

	public Okur(int id, String ad, String soyad, int cezaPuani, String telefon, Date olusturmaTarihi, Date guncellenmeTarihi) {
		super(id, olusturmaTarihi, guncellenmeTarihi);
		this.ad = ad;
		this.soyad = soyad;
		this.cezaPuani = cezaPuani;
		this.telefon = telefon;
	}
	
	public String getAd() {
		return ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public int getCezaPuani() {
		return cezaPuani;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setCezaPuani(int cezaPuani) {
		this.cezaPuani += cezaPuani;
	}
	
	public void cezaPuaniSifirla(){
		this.cezaPuani = 0;
	}
}
