package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import nesne.Tur;
import interfaces.DB;

public class DBTur implements DB<Tur> {

	public void ekle(Statement stmt, Tur tur) {
		String sorgu = "INSERT INTO turler (adi) VALUES ('" + tur.getAd() + "');";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sil(Statement stmt, int id) {
		String sorgu = "DELETE FROM turler WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Tur> listele(Statement stmt) {
		String sorgu = "SELECT * FROM turler";
		ArrayList<Tur> turler = new ArrayList<Tur>();
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			while(rs.next()){
				int id = rs.getInt("id");
				String turAdi = rs.getString("adi");
				Date olusturmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Tur tur = new Tur(id,turAdi,olusturmaTarihi,guncellemeTarihi);
				turler.add(tur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return turler;
	}
	
	public Tur getir(Statement stmt, int id){
		String sorgu = "SELECT * FROM turler WHERE id = " + id + ";";
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			
			if(rs.next()){
				int turId = rs.getInt("id");
				String ad = rs.getString("adi");
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Tur tur = new Tur(turId,ad,olusturulmaTarihi,guncellemeTarihi);
				return tur;
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
