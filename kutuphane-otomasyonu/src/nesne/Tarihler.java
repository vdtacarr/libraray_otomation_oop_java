package nesne;

import java.util.Date;

public class Tarihler extends Idler {
	
	private Date olusturmaTarihi;
	private Date guncellenmeTarihi;
	
	public Tarihler(){
		super();
	}
	
	public Tarihler(int id, Date olusturmaTarihi, Date guncellenmeTarihi) {
		super(id);
		this.olusturmaTarihi = olusturmaTarihi;
		this.guncellenmeTarihi = guncellenmeTarihi;
	}
	
	public Date getOlusturmaTarihi() {
		return olusturmaTarihi;
	}
	public Date getGuncellenmeTarihi() {
		return guncellenmeTarihi;
	}
	
}
