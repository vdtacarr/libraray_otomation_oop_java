package interfaces;

import java.sql.Statement;
import java.util.ArrayList;

public interface DB<T> {
	public void ekle(Statement stmt, T t);
	public void sil(Statement stmt, int id);
	public ArrayList<T> listele(Statement stmt);
}
