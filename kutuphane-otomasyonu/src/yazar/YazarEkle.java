package yazar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import sql.Baglan;
import sql.DBYazar;

import nesne.Yazar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YazarEkle {

	private JFrame frmYazarEkle;
	private JTextField jTextSoyadi;
	private JTextField jTextAdi;
	private JLabel lblSoyad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YazarEkle window = new YazarEkle();
					window.frmYazarEkle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public YazarEkle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYazarEkle = new JFrame();
		frmYazarEkle.setResizable(false);
		frmYazarEkle.setTitle("Yazar Ekle");
		frmYazarEkle.setBounds(100, 100, 257, 190);
		frmYazarEkle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYazarEkle.getContentPane().setLayout(null);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglan baglan = Baglan.getInstance();
				DBYazar dbYazar = new DBYazar();
				String ad = jTextAdi.getText();
				String soyad = jTextSoyadi.getText();
				
				Yazar yazar = new Yazar(ad,soyad);
				
				dbYazar.ekle(baglan.getStmt(), yazar);
			}
		});
		btnKaydet.setBounds(83, 108, 96, 23);
		frmYazarEkle.getContentPane().add(btnKaydet);
		
		jTextSoyadi = new JTextField();
		jTextSoyadi.setBounds(79, 55, 128, 23);
		frmYazarEkle.getContentPane().add(jTextSoyadi);
		jTextSoyadi.setColumns(10);
		
		JLabel lblAd = new JLabel("Ad\u0131:");
		lblAd.setBounds(23, 25, 46, 14);
		frmYazarEkle.getContentPane().add(lblAd);
		
		jTextAdi = new JTextField();
		jTextAdi.setBounds(79, 21, 128, 23);
		frmYazarEkle.getContentPane().add(jTextAdi);
		jTextAdi.setColumns(10);
		
		lblSoyad = new JLabel("Soyad\u0131:");
		lblSoyad.setBounds(23, 59, 46, 14);
		frmYazarEkle.getContentPane().add(lblSoyad);
	}
}
