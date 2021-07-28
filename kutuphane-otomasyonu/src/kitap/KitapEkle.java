package kitap;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import sql.Baglan;
import sql.DBKitap;
import sql.DBTur;
import sql.DBYazar;

import nesne.Kitap;
import nesne.Tur;
import nesne.Yazar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KitapEkle extends JFrame {

	private JPanel cntntPaneKitap;
	private JTextField jTextAdi;
	private JTextField jTextBarkod;
	private JTextField jTextSayfaSayisi;
	private JTextField jTextBaski;
	private JTextField jTextStok;
	private JComboBox<Tur> jCmbBoxTur;
	private JComboBox<Yazar> jCmbBoxYazar;
	/**
	 * Create the frame.
	 */
	public KitapEkle() {
		setTitle("Kitap Ekle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 300);
		cntntPaneKitap = new JPanel();
		cntntPaneKitap.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cntntPaneKitap);
		
		JLabel lblAdi = new JLabel("Adi :");
		
		JLabel lblNewLabel = new JLabel("Barkod :");
		
		JLabel lblSayfaSays = new JLabel("Sayfa Say\u0131s\u0131 :");
		
		JLabel lblBask = new JLabel("Bask\u0131 :");
		
		JLabel lblStok = new JLabel("Stok :");
		
		JLabel lblTr = new JLabel("T\u00FCr :");
		
		JLabel lblYazar = new JLabel("Yazar :");
		
		jTextAdi = new JTextField();
		jTextAdi.setColumns(10);
		
		jTextBarkod = new JTextField();
		jTextBarkod.setColumns(10);
		
		jTextSayfaSayisi = new JTextField();
		jTextSayfaSayisi.setColumns(10);
		
		jTextBaski = new JTextField();
		jTextBaski.setColumns(10);
		
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
		
		jCmbBoxTur = new JComboBox<Tur>();
		jCmbBoxTur.setToolTipText("");
		Baglan baglan = Baglan.getInstance();
		DBTur dbTur = new DBTur();
		ArrayList<Tur> turler = dbTur.listele(baglan.getStmt());
		for (Tur tur : turler) {
			jCmbBoxTur.addItem(tur);
		}
		
		jCmbBoxYazar = new JComboBox<Yazar>();
		DBYazar dbYazar = new DBYazar();
		ArrayList<Yazar> yazarlar = dbYazar.listele(baglan.getStmt());
		for (Yazar yazar : yazarlar) {
			jCmbBoxYazar.addItem(yazar);
		}
		JButton jBtnKaydet = new JButton("Kaydet");
		jBtnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = jTextAdi.getText();
				String barkod = jTextBarkod.getText();
				String sayfaSayisi = jTextSayfaSayisi.getText();
				String baski = jTextBaski.getText();
				int stok = Integer.parseInt(jTextStok.getText());
				Tur tur = (Tur)jCmbBoxTur.getSelectedItem();
				Yazar yazar = (Yazar)jCmbBoxYazar.getSelectedItem();
				
				DBKitap dbKitap = new DBKitap();
				Kitap kitap = new Kitap(ad,barkod,sayfaSayisi,baski,stok,tur.getId(),yazar.getId());
				dbKitap.ekle(Baglan.getInstance().getStmt(), kitap);
				
				JOptionPane.showMessageDialog(cntntPaneKitap, "Eklendi");
			}
		});
		GroupLayout gl_cntntPaneKitap = new GroupLayout(cntntPaneKitap);
		gl_cntntPaneKitap.setHorizontalGroup(
			gl_cntntPaneKitap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cntntPaneKitap.createSequentialGroup()
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cntntPaneKitap.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAdi)
								.addComponent(lblNewLabel)
								.addComponent(lblSayfaSays)
								.addComponent(lblBask)
								.addComponent(lblStok)
								.addComponent(lblTr)
								.addComponent(lblYazar))
							.addGap(23)
							.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jCmbBoxYazar, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jTextStok)
								.addComponent(jTextBaski)
								.addComponent(jTextSayfaSayisi)
								.addComponent(jTextBarkod)
								.addComponent(jTextAdi)
								.addComponent(jCmbBoxTur, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_cntntPaneKitap.createSequentialGroup()
							.addGap(51)
							.addComponent(jBtnKaydet, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_cntntPaneKitap.setVerticalGroup(
			gl_cntntPaneKitap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cntntPaneKitap.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdi)
						.addComponent(jTextAdi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(jTextBarkod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSayfaSays)
						.addComponent(jTextSayfaSayisi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBask)
						.addComponent(jTextBaski, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStok)
						.addComponent(jTextStok, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTr)
						.addComponent(jCmbBoxTur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cntntPaneKitap.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYazar)
						.addComponent(jCmbBoxYazar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jBtnKaydet)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		cntntPaneKitap.setLayout(gl_cntntPaneKitap);
	}
}
