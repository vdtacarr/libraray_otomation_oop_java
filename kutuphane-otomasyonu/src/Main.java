import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean calis = true;
		Scanner scan = new Scanner(System.in);
		while(calis){
			System.out.println("Yapmak istedi�iniz i�lemi se�iniz");
			System.out.println("1-Kitap\n2-Yazar\n3-T�r\n4-Okur\n5-Odunc\n6-��k��");
			int secim = scan.nextInt();
			switch (secim) {
			case 1:
				MainKitap.kitapMain(scan);
				break;
			case 2:
				MainYazar.yazarMain(scan);
				break;
			case 3:
				MainTur.turMain(scan);
				break;
			case 4:
				MainOkur.okurMain(scan);
				break;
			case 5:
				MainOdunc.oduncMain(scan);
				break;
			case 6:
				calis = false;
				break;
			default:
				System.out.println("Yanl�� se�im yapt�n�z.");
				break;
			}
		}
		scan.close();
	}
}
