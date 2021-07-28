package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import interfaces.DB;
import nesne.Yazar;

public class DBYazar implements DB<Yazar> {
	public void ekle(Statement stmt, Yazar yazar){
		String sorgu = "INSERT INTO yazarlar (adi,soyadi) VALUES ('" + yazar.getAd() + "','" + yazar.getSoyad() + "');";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sil(Statement stmt, int id) {
		String sorgu = "DELETE FROM yazarlar WHERE id = " + id + ";";
		
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Yazar> listele(Statement stmt) {
		String sorgu = "SELECT * FROM yazarlar;";
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			ArrayList<Yazar> yazarlar = new ArrayList<Yazar>();
			while(rs.next()){
				int id = rs.getInt("id");
				String ad = rs.getString("adi");
				String soyad = rs.getString("soyadi");
				Date olusturmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				
				Yazar yazar = new Yazar(id, ad, soyad, olusturmaTarihi, guncellemeTarihi);
				yazarlar.add(yazar);
			}
			return yazarlar;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Yazar getir(Statement stmt, int id){
		String sorgu = "SELECT * FROM yazarlar WHERE id = " + id + ";";
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sorgu);
			
			if(rs.next()){
				int yazarId = rs.getInt("id");
				String ad = rs.getString("adi");
				String soyad = rs.getString("soyadi");
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Yazar yazar = new Yazar(yazarId, ad, soyad,olusturulmaTarihi,guncellemeTarihi);
				return yazar;
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
