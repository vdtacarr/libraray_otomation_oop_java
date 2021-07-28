package kitap;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import nesne.Kitap;
import nesne.Tur;
import nesne.Yazar;
import sql.Baglan;
import sql.DBKitap;
import sql.DBTur;
import sql.DBYazar;

public class Test extends JFrame {

	private JPanel frmKitapEkle;
	private JTextField jTextAdi;
	private JTextField jTextBarkod;
	private JTextField jTextSayfaSayisi;
	private JTextField jTextBaski;
	private JTextField jTextStok;
	private JComboBox<Tur> comboBoxTur;
	private JComboBox<Yazar> comboBoxYazar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		frmKitapEkle = new JPanel();
		frmKitapEkle.setBounds(100, 100, 314, 277);
		frmKitapEkle.setLayout(null);
		
		jTextAdi = new JTextField();
		jTextAdi.setBounds(104, 11, 115, 20);
		frmKitapEkle.add(jTextAdi);
		jTextAdi.setColumns(10);
		
		jTextBarkod = new JTextField();
		jTextBarkod.setColumns(10);
		jTextBarkod.setBounds(104, 37, 115, 20);
		frmKitapEkle.add(jTextBarkod);
		
		jTextSayfaSayisi = new JTextField();
		jTextSayfaSayisi.setColumns(10);
		jTextSayfaSayisi.setBounds(104, 62, 115, 20);
		frmKitapEkle.add(jTextSayfaSayisi);
		
		jTextBaski = new JTextField();
		jTextBaski.setColumns(10);
		jTextBaski.setBounds(104, 88, 115, 20);
		frmKitapEkle.add(jTextBaski);
		
		jTextStok = new JTextField();
		jTextStok.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
				
			}
		});
		jTextStok.setColumns(10);
		jTextStok.setBounds(104, 114, 115, 20);
		frmKitapEkle.add(jTextStok);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setBounds(10, 17, 72, 14);
		frmKitapEkle.add(lblAd);
		
		JLabel lblBarkod = new JLabel("Barkod :");
		lblBarkod.setBounds(10, 43, 72, 14);
		frmKitapEkle.add(lblBarkod);
		
		JLabel lblSayfaSays = new JLabel("Sayfa say\u0131s\u0131 : ");
		lblSayfaSays.setBounds(10, 68, 84, 14);
		frmKitapEkle.add(lblSayfaSays);
		
		JLabel lblBaskSays = new JLabel("Bask\u0131 : ");
		lblBaskSays.setBounds(10, 91, 84, 14);
		frmKitapEkle.add(lblBaskSays);
		
		JLabel lblStok = new JLabel("Stok : ");
		lblStok.setBounds(10, 117, 84, 14);
		frmKitapEkle.add(lblStok);
		
		JLabel lblYazar = new JLabel("Yazar : ");
		lblYazar.setBounds(10, 143, 84, 14);
		frmKitapEkle.add(lblYazar);
		
		JLabel lblTr = new JLabel("T\u00FCr : ");
		lblTr.setBounds(10, 172, 84, 14);
		frmKitapEkle.add(lblTr);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = jTextAdi.getText();
				String barkod = jTextBarkod.getText();
				String sayfaSayisi = jTextSayfaSayisi.getText();
				String baski = jTextBaski.getText();
				int stok = Integer.parseInt(jTextStok.getText());
				Tur tur = (Tur)comboBoxTur.getSelectedItem();
				Yazar yazar = (Yazar)comboBoxYazar.getSelectedItem();
				
				
				Baglan baglan = Baglan.getInstance();
				DBKitap dbKitap = new DBKitap();
				
				Kitap kitap = new Kitap(ad,barkod,sayfaSayisi,baski,stok,tur.getId(),yazar.getId());
				
				dbKitap.ekle(baglan.getStmt(), kitap);
				JOptionPane.showMessageDialog(frmKitapEkle, "Eklendi");
			}
		});
		btnKaydet.setBounds(104, 214, 89, 23);
		frmKitapEkle.add(btnKaydet);
		
		Baglan baglan = Baglan.getInstance();
		DBYazar dbYazar = new DBYazar();
		ArrayList<Yazar> yazarlar = dbYazar.listele(baglan.getStmt());
		
		comboBoxYazar = new JComboBox<Yazar>();
		comboBoxYazar.setBounds(104, 140, 115, 20);
		frmKitapEkle.add(comboBoxYazar);
		for (Yazar yazar : yazarlar) {
			comboBoxYazar.addItem(yazar);
		}
		
		comboBoxTur = new JComboBox<Tur>();
		comboBoxTur.setBounds(104, 169, 115, 20);
		frmKitapEkle.add(comboBoxTur);
		
		DBTur dbTur = new DBTur();
		ArrayList<Tur> turler = dbTur.listele(baglan.getStmt());
		
		for (Tur tur : turler) {
			comboBoxTur.addItem(tur);
		}
	}

}
