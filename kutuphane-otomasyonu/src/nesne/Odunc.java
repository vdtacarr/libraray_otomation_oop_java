package nesne;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Odunc extends Tarihler {
	private int okurId;
	private int kitapId;
	private Date alimTarihi;
	private Date teslimTarihi;
	public Odunc(int okurId, int kitapId, Date alimTarihi) {
		super();
		this.okurId = okurId;
		this.kitapId = kitapId;
		this.alimTarihi = alimTarihi;
		this.teslimTarihi = null;
	}
	
	public Odunc(int id, int okurId, int kitapId, Date alimTarihi, Date teslimtarihi,
			Date olusturmaTarihi, Date guncellemeTarihi) {
		super(id, olusturmaTarihi, guncellemeTarihi);
		this.okurId = okurId;
		this.kitapId = kitapId;
		this.alimTarihi = alimTarihi;
		this.teslimTarihi = teslimtarihi;
	}
	
	public int getOkurId() {
		return okurId;
	}
	
	public int getKitapId() {
		return kitapId;
	}
	
	public Date getAlimTarihi() {
		return alimTarihi;
	}
	
	public String getAlimTarihiTypeString() {
		String tarih = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(alimTarihi);
		return tarih;
	}
	
	public Date getTeslimTarihi() {
		return teslimTarihi;
	}
	
	public String getTeslimTarihiTypeString() {
		if(teslimTarihi == null)
			return null;
		String tarih = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(teslimTarihi);
		return tarih;
	}
	
	public int setTeslimTarihi(Date teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
		return cezaHesapla(alimTarihi, teslimTarihi);
	}
	
	public int cezaHesapla(Date alimTarihi, Date teslimTarihi){
		long gunMiliSaniye = Math.abs(alimTarihi.getTime() - teslimTarihi.getTime());
		long gun = TimeUnit.DAYS.convert(gunMiliSaniye, TimeUnit.MILLISECONDS);
		return (int)gun - 10;
	}
	
}
