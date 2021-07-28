package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import nesne.Kitap;
import sql.Baglan;
import sql.DBKitap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import kitap.KitapEkle;
import kitap.KitapEkle1;
import kitap.Test;

public class MainEkrani {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=1198,79
	 */
	private final JButton button_4 = new JButton("New button");
	private JTable jTableKitapListe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEkrani window = new MainEkrani();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainEkrani() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		frame.getContentPane().add(panelHeader, BorderLayout.NORTH);
		
		JButton btnKitapEkrani = new JButton("Kitap");
		btnKitapEkrani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglan baglan = Baglan.getInstance();
				DBKitap dbKitap = new DBKitap();
				ArrayList<Kitap> kitaplar = dbKitap.listele(baglan.getStmt());
				
				Object[][] eklenecekData = new Object [kitaplar.size()][];
				int i = 0;
				for(Kitap kitap : kitaplar){
					
					eklenecekData[i] = new Object[]{
							kitap.getId(),kitap.getKitapAdi(),kitap.getBarkod(), kitap.getSayfaSayisi(), kitap.getBaski(), kitap.getStok(), kitap.getTurId(), kitap.getYazarId()};
					i++;
				}
				String col[] = {"id","Adý","Barkod", "Sayfa Sayýsý", "Baský", "Stok", "Tür", "Yazar"};
				DefaultTableModel tbmodel=new DefaultTableModel(eklenecekData,col);

		        jTableKitapListe.setModel(tbmodel);
		 
				
			}
		});
		
		JButton btnYazar = new JButton("Yazar");
		
		JButton button_1 = new JButton("New button");
		
		JButton button_2 = new JButton("New button");
		
		JButton button_3 = new JButton("New button");
		GroupLayout gl_panelHeader = new GroupLayout(panelHeader);
		gl_panelHeader.setHorizontalGroup(
			gl_panelHeader.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHeader.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnKitapEkrani, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnYazar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_3)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelHeader.setVerticalGroup(
			gl_panelHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelHeader.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelHeader.createParallelGroup(Alignment.LEADING)
						.addComponent(btnYazar, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKitapEkrani, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelHeader.setLayout(gl_panelHeader);
		
		JPanel panelKitapDrawer = new JPanel();
		frame.getContentPane().add(panelKitapDrawer, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KitapEkle kitapEkle = new KitapEkle();
				kitapEkle.setVisible(true);
			}
		});
		
		JButton btnSil = new JButton("Sil");
		GroupLayout gl_panelKitapDrawer = new GroupLayout(panelKitapDrawer);
		gl_panelKitapDrawer.setHorizontalGroup(
			gl_panelKitapDrawer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKitapDrawer.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelKitapDrawer.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSil, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panelKitapDrawer.setVerticalGroup(
			gl_panelKitapDrawer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelKitapDrawer.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSil)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		panelKitapDrawer.setLayout(gl_panelKitapDrawer);
		
		JPanel panelKitapEkrani = new JPanel();
		frame.getContentPane().add(panelKitapEkrani, BorderLayout.CENTER);
		panelKitapEkrani.setLayout(new BorderLayout(0, 0));
		
		jTableKitapListe = new JTable();
		panelKitapEkrani.add(jTableKitapListe);
	}
}
