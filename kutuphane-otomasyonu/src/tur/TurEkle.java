package tur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import nesne.Tur;

import sql.Baglan;
import sql.DBTur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class TurEkle {

	private JFrame frmTurEkle;
	private JTextField jTextAd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurEkle window = new TurEkle();
					window.frmTurEkle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TurEkle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurEkle = new JFrame();
		frmTurEkle.setTitle("T\u00FCr ekle");
		frmTurEkle.setResizable(false);
		frmTurEkle.setBounds(100, 100, 246, 142);
		frmTurEkle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTurEkle.getContentPane().setLayout(null);
		
		jTextAd = new JTextField();
		jTextAd.setBounds(73, 22, 142, 20);
		frmTurEkle.getContentPane().add(jTextAd);
		jTextAd.setColumns(10);
		
		JLabel lblAd = new JLabel("Ad\u0131 :");
		lblAd.setBounds(10, 25, 46, 14);
		frmTurEkle.getContentPane().add(lblAd);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Baglan baglan = Baglan.getInstance();
				DBTur dbTur = new DBTur();
				String ad = jTextAd.getText();
				
				Tur tur = new Tur(ad);
				dbTur.ekle(baglan.getStmt(), tur);
				JOptionPane.showMessageDialog(frmTurEkle, "Eklendi");
				frmTurEkle.dispatchEvent(new WindowEvent(frmTurEkle, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnEkle.setBounds(73, 66, 130, 23);
		frmTurEkle.getContentPane().add(btnEkle);
	}

}
