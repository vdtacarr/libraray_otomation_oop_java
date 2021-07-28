package sql;

import java.sql.Statement;
import java.util.ArrayList;

public interface DB<T> { // <T> herhangi bir tip i�in demek oluyor
	public void ekle(Statement stmt, T t);
	public void sil(Statement stmt,int id);
	public ArrayList<T> listele(Statement stmt);
}
