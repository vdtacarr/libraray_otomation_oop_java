package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Baglan {
	private static Baglan instance = null;
	private String url;
	private Connection conn = null;
	private Statement stmt = null;
	
	private String host = "localhost";
	private String port = "3306";
	private String veritabani = "kutuphane";
	
	private String kullanicAdi = "root";
	private String sifre = "1234";
	
	private Baglan(){
		
	}
	
	public static Baglan getInstance(){
		if(instance == null){
			instance = new Baglan();
			instance.baglantiBaslat();
		}
		return instance;
	}
	
	private void baglantiBaslat(){
		url = "jdbc:mysql://" + host + ":" + port + 
				"/" + veritabani + 
				"?useUnicode=true" +
				"&useJDBCCompliantTimezoneShift=true" +
				"&useLegacyDatetimeCode=false" +
				"&serverTimezone=UTC";
		
		try {
			conn = DriverManager.getConnection(url,kullanicAdi,sifre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Statement getStmt() {
		return stmt;
	}
	
}
