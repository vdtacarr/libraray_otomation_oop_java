package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import nesne.Okur;
import interfaces.DB;

public class DBOkur implements DB<Okur> {

	public void ekle(Statement stmt, Okur okur) {
		String sorgu = "INSERT INTO okurlar (adi, soyadi,ceza_puani, telefon) VALUES('"+okur.getAd()+"', '"+okur.getSoyad()+"', '"+okur.getCezaPuani()+"','"+okur.getTelefon()+"')";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sil(Statement stmt, int id) {
		String sorgu = "DELETE FROM okurlar WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Okur> listele(Statement stmt) {
		String sorgu = "SELECT * FROM okurlar";
		ArrayList<Okur> okurlar = new ArrayList<Okur>();
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			while(rs.next()){
				int id = rs.getInt("id");
				String ad = rs.getString("adi");
				String soyad = rs.getString("soyadi");
				int cezaPuani = rs.getInt("ceza_puani");
				String telefon = rs.getString("telefon");
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Okur okur = new Okur(id,ad,soyad,cezaPuani,telefon,olusturulmaTarihi,guncellemeTarihi);
				okurlar.add(okur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return okurlar;
	}
	
	public Okur getirId(Statement stmt, int id){
		String sorgu = "SELECT * FROM okurlar WHERE id = " + id + ";";
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			if(rs.next()){
				String ad = rs.getString("adi");
				String soyad = rs.getString("soyadi");
				int cezaPuani = rs.getInt("ceza_puani");
				String telefon = rs.getString("telefon");
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Okur okur = new Okur(id,ad,soyad,cezaPuani,telefon,olusturulmaTarihi,guncellemeTarihi);
				return okur;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void guncelle(Statement stmt, Okur okur){
		String sorgu = "UPDATE okurlar SET adi='"+okur.getAd()+"', soyadi='"+okur.getSoyad()+"', ceza_puani='"+okur.getCezaPuani()+"', telefon='"+okur.getTelefon()+"' WHERE ID="+okur.getId()+";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
