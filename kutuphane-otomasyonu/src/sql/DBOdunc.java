package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import nesne.Odunc;
import interfaces.DB;

public class DBOdunc implements DB<Odunc> {

	public void ekle(Statement stmt, Odunc odunc) {
		String sorgu = "INSERT INTO oduncler (alim_tarih, teslim_tarih, okur_id, kitap_id) VALUES('"+odunc.getAlimTarihiTypeString()+"', '"+odunc.getTeslimTarihiTypeString()+"', '"+odunc.getOkurId()+"','"+odunc.getKitapId()+"')";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sil(Statement stmt, int id) {
		String sorgu = "DELETE FROM oduncler WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Odunc> listele(Statement stmt) {
		String sorgu = "SELECT * FROM oduncler";
		ArrayList<Odunc> oduncler = new ArrayList<Odunc>();
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			while(rs.next()){
				int id = rs.getInt("id");
				Date alimTarihi = rs.getDate("alim_tarih");
				Date teslimTarihi = rs.getDate("teslim_tarih");
				int okurId = rs.getInt("okur_id");
				int kitapId = rs.getInt("kitap_id");
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Odunc odunc = new Odunc(id,okurId,kitapId,alimTarihi,teslimTarihi,olusturulmaTarihi,guncellemeTarihi);
				oduncler.add(odunc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oduncler;
	}
	
	public void guncelle(Statement stmt, Odunc odunc){
		String sorgu = "UPDATE oduncler SET teslim_tarih='"+odunc.getTeslimTarihiTypeString()+"'  WHERE ID="+odunc.getId()+";";
		try {
			stmt.executeUpdate(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Odunc getirOkurVeKitapId(Statement stmt, int okurId, int kitapId){
		String sorgu = "SELECT * FROM oduncler WHERE okur_id = " + okurId + " and kitap_id = " + kitapId + ";";
		try {
			ResultSet rs = stmt.executeQuery(sorgu);
			if(rs.next()){
				int id = rs.getInt("id");
				Date alimTarihi = rs.getDate("alim_tarih");
				Date teslimTarihi = null;
				try{
					teslimTarihi = rs.getDate("teslim_tarih");
				} catch(SQLException e){
					
				}
				Date olusturulmaTarihi = rs.getDate("olusturulma_tarihi");
				Date guncellemeTarihi = rs.getDate("guncelleme_tarihi");
				Odunc odunc = new Odunc(id,okurId,kitapId,alimTarihi,teslimTarihi,olusturulmaTarihi,guncellemeTarihi);
				return odunc;
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
