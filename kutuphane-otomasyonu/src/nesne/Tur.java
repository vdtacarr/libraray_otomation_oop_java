package nesne;

import java.util.Date;

public class Tur extends Tarihler {
	private String ad;
	public Tur(String ad){
		this.ad = ad;
	}
	
	public Tur(int id, String ad, Date olusturmaTarihi, Date guncellemeTarihi){
		super(id,olusturmaTarihi,guncellemeTarihi);
		this.ad = ad;
	}
	
	public String getAd() {
		return ad;
	}
	
	public String toString(){
		return ad;
	}
	
}
