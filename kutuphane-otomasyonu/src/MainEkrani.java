import java.awt.EventQueue;

import javax.swing.JFrame;


public class MainEkrani {

	private JFrame frmKtphaneOtomasyonu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEkrani window = new MainEkrani();
					window.frmKtphaneOtomasyonu.setVisible(true);
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
		frmKtphaneOtomasyonu = new JFrame();
		frmKtphaneOtomasyonu.setTitle("K\u00FCt\u00FCphane Otomasyonu");
		frmKtphaneOtomasyonu.setBounds(100, 100, 450, 300);
		frmKtphaneOtomasyonu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
