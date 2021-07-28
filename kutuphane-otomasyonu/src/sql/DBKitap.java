package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import nesne.Kitap;
import interfaces.DB;

public class DBKitap implements DB<Kitap>  {
	public void ekle(Statement stmt, Kitap kitap) {
		String sorgu = "INSERT INTO kitaplar (adi,barkod,sayfa_sayisi,baski,stok,tur_id,yazar_id) VALUES ('" + kitap.getKitapAdi() + "', '" + kitap.getBarkod() + "', '" + kitap.getSayfaSayisi() + "', '"+kitap.getBaski()+"', '"+kitap.getStok()+"', '"+kitap.getTurId()+"', '"+kitap.getYazarId()+"');";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sil(Statement stmt, int id) {
		String sorgu = "DELETE FROM kitaplar WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Kitap> listele(Statement stmt) {
		String sorgu = "SELECT * FROM kitaplar";
		ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			while(rs.next()){
				int id = rs.getInt("id");
				String kitapAdi = rs.getString("adi");
				String barkod = rs.getString("barkod");
				String sayfaSayisi = rs.getString("sayfa_sayisi") ;
				String baski = rs.getString("baski") ;
				int stok = rs.getInt("stok");
				int turId = rs.getInt("tur_id");
				int yazarId = rs.getInt("yazar_id");
				Date olusturmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Kitap kitap = new Kitap(id,kitapAdi,barkod,sayfaSayisi,baski,stok,turId,yazarId,olusturmaTarihi,guncellemeTarihi);
				kitaplar.add(kitap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kitaplar;
	}
	
	public Kitap getirId(Statement stmt,int id){
		String sorgu = "SELECT * FROM kitaplar WHERE id="+id+";";
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			if(rs.next()){
				String kitapAdi = rs.getString("adi");
				String barkod = rs.getString("barkod");
				String sayfaSayisi = rs.getString("sayfa_sayisi") ;
				String baski = rs.getString("baski") ;
				int stok = rs.getInt("stok");
				int turId = rs.getInt("tur_id");
				int yazarId = rs.getInt("yazar_id");
				Date olusturmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Kitap kitap = new Kitap(id,kitapAdi,barkod,sayfaSayisi,baski,stok,turId,yazarId,olusturmaTarihi,guncellemeTarihi);
				return kitap;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
