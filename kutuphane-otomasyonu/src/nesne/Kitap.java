package nesne;

import java.util.Date;

import interfaces.IKitap;

public class Kitap extends Tarihler implements IKitap {
	private String kitapAdi;
	private String barkod;
	private String sayfaSayisi;
	private String baski;
	private int stok;
	private int turId;
	private int yazarId;
	
	public Kitap(String kitapAdi, String barkod, String sayfaSayisi,
			String baski, int stok, int turId, int yazarId) {
		super();
		this.kitapAdi = kitapAdi;
		this.barkod = barkod;
		this.sayfaSayisi = sayfaSayisi;
		this.baski = baski;
		this.stok = stok;
		this.turId = turId;
		this.yazarId = yazarId;
	}
	
	public Kitap(int id, String kitapAdi, String barkod, String sayfaSayisi,
			String baski, int stok, int turId, int yazarId,
			Date olusturmaTarihi, Date guncellemeTarihi) {
		super(id, olusturmaTarihi, guncellemeTarihi);
		this.kitapAdi = kitapAdi;
		this.barkod = barkod;
		this.sayfaSayisi = sayfaSayisi;
		this.baski = baski;
		this.stok = stok;
		this.turId = turId;
		this.yazarId = yazarId;
	}
	
	public String getKitapAdi() {
		return kitapAdi;
	}
	public String getBarkod() {
		return barkod;
	}
	public String getSayfaSayisi() {
		return sayfaSayisi;
	}
	public String getBaski() {
		return baski;
	}
	public int getStok() {
		return stok;
	}
	public int getTurId() {
		return turId;
	}
	public int getYazarId() {
		return yazarId;
	}
}
