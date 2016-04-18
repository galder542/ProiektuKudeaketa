package org.sudoku.sftwring;

import java.io.IOException;
import java.util.ArrayList;

public class ProbatzekoMain2 {

	public static void main(String[] args) {
		sudokuaAusazBete();
		frogaBerriak();

	}

	private static void frogaBerriak() {
		adabegiFrogak();
		aukeratuLeihoaFrogak();
		erregistroLehioaFrogak();
		generadoreSudokuFrogak();
		laguntzaFrogak();
		sudokuAdapterFrogak();
		klasifikazioaFrogak();
		sudokuSolverFrogak();
		zifraFrogak();

	}

	private static void zifraFrogak() {
		System.out.println("Datuak ondo zifratzen dira?\n---------------------------");
		Erabiltzaile erab3=new Erabiltzaile("martin2", 7, "12345");

		Zifra zifrPas = new Zifra(erab3.getPasahitza());
		try {
			String zifra= zifrPas.encrypt("12345");
			System.out.println("Zifratutako pasahitza: "+zifra);
			if (zifrPas.decrypt(zifra).equals("12345")) {
				System.out.println("Deszifratu...OK");
			}else System.out.println("Deszifratu...ERROR");
			ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("martin", "12345",zifra);
			if(ErabiltzaileLista.getErabiltzaileLista().badago("martin"))
				System.out.println("Erabiltzailea gehituta...OK");				
			else	System.out.println("Erabiltzailea gehituta...ERROR");}catch (Exception e) {
				System.out.println("Excepzioa:");
				e.printStackTrace();
			}
	}

	private static void sudokuSolverFrogak() {
		System.out.println("Beti soluzio berdina (bakarra) bueltatzen da?\n-----------------------------------------------"); 
		SudokuAdapter sa=new SudokuAdapter();
		sa.setZailtasuna(0);
		GeneradoreSudoku genSudo = new GeneradoreSudoku(0);
		genSudo.beteAusaz();
		if(genSudo instanceof GeneradoreSudoku)
			System.out.println("Generadore...OK");
		else System.out.println("Generadore...ERROR");
		System.out.println("- Soluzio bakarra du?");
		if (genSudo.soluzioBakarra()) {
			System.out.println("Bakarra...OK");
		}else System.out.println("Bakarra...ERROR");
		sa.pasatu(genSudo);
		System.out.println("Hasieran dugun sudokua");
		sa.inprimatuSudokuZuzena();
		System.out.println("Bukaeran, hasieran dituen zenbaki berdinak posizio berdinean ditu, 0-ak kenduta? ");
		sa.inprimatuSudoku();
	}

	private static void sudokuAdapterFrogak() {
		System.out.println("Patroia era zuzenenan funtzionatzen du?\n---------------------------------------");   
		System.out.println("Sortuko dugu SudokuAdapter motako objektua: " );	
		SudokuAdapter sa=new SudokuAdapter();
		if(sa instanceof SudokuAdapter)
			System.out.println("Adapter...OK");
		else System.out.println("Adapter...ERROR");
		sa.setZailtasuna(0);
		System.out.println("Sortuko dugu GeneradoreSudoku motako objektua: " );
		GeneradoreSudoku genSudo = new GeneradoreSudoku(0);
		if(genSudo instanceof GeneradoreSudoku)
			System.out.println("Generadore...OK");
		else System.out.println("Generadore...ERROR");
		genSudo.beteAusaz();
		sa.pasatu(genSudo);
		System.out.println("Eta orain sudokuAdapter motako objektuak, sudoku klaseko metodoak eskuragai ditu: \nAdibidez beteZeroz edo inprimatu:");
		System.out.println("Hasieran Adapterra...");
		sa.inprimatuSudoku();
		sa.beteZeroz();
		System.out.println("Betezeroz egin ondoren...");
		sa.inprimatuSudoku();
	}

	private static void laguntzaFrogak() {
		System.out.println("Laguntza behar bezala funtzionatzen du?\n---------------------------------------");
		Sudokua s = new Sudokua();
		s.getBloke(0).setKasila(0,0, new Kasila(5));
		s.getBloke(0).getKasila(0,0).setFinkoa(true);
		s.getBloke(0).setKasila(0,1, new Kasila(3));
		s.getBloke(0).getKasila(0,1).setFinkoa(true);
		s.getBloke(0).setKasila(0,2, new Kasila(4));
		s.getBloke(0).setKasila(1,0, new Kasila(6));
		s.getBloke(0).getKasila(1,0).setFinkoa(true);
		s.getBloke(0).setKasila(1,1, new Kasila(7));
		s.getBloke(0).setKasila(1,2, new Kasila(2));
		s.getBloke(0).setKasila(2,0, new Kasila(1));
		s.getBloke(0).setKasila(2,1, new Kasila(9));
		s.getBloke(0).getKasila(2,1).setFinkoa(true);
		s.getBloke(0).setKasila(2,2, new Kasila(8));
		s.getBloke(0).getKasila(2,2).setFinkoa(true);

		s.getBloke(1).setKasila(0,0, new Kasila(6));
		s.getBloke(1).setKasila(0,1, new Kasila(7));
		s.getBloke(1).getKasila(0,1).setFinkoa(true);
		s.getBloke(1).setKasila(0,2, new Kasila(8));
		s.getBloke(1).setKasila(1,0, new Kasila(1));
		s.getBloke(1).getKasila(1,0).setFinkoa(true);
		s.getBloke(1).setKasila(1,1, new Kasila(9));
		s.getBloke(1).getKasila(1,1).setFinkoa(true);
		s.getBloke(1).setKasila(1,2, new Kasila(5));
		s.getBloke(1).getKasila(1,2).setFinkoa(true);
		s.getBloke(1).setKasila(2,0, new Kasila(3));
		s.getBloke(1).setKasila(2,1, new Kasila(4));
		s.getBloke(1).setKasila(2,2, new Kasila(2));

		s.getBloke(2).setKasila(0,0, new Kasila(9));
		s.getBloke(2).setKasila(0,1, new Kasila(1));
		s.getBloke(2).setKasila(0,2, new Kasila(2));
		s.getBloke(2).setKasila(1,0, new Kasila(3));
		s.getBloke(2).setKasila(1,1, new Kasila(4));
		s.getBloke(2).setKasila(1,2, new Kasila(8));
		s.getBloke(2).setKasila(2,0, new Kasila(5));
		s.getBloke(2).setKasila(2,1, new Kasila(6));
		s.getBloke(2).getKasila(2,1).setFinkoa(true);
		s.getBloke(2).setKasila(2,2, new Kasila(7));

		s.getBloke(3).setKasila(0,0, new Kasila(8));
		s.getBloke(3).getKasila(0,0).setFinkoa(true);
		s.getBloke(3).setKasila(0,1, new Kasila(5));
		s.getBloke(3).setKasila(0,2, new Kasila(9));
		s.getBloke(3).setKasila(1,0, new Kasila(4));
		s.getBloke(3).getKasila(1,0).setFinkoa(true);
		s.getBloke(3).setKasila(1,1, new Kasila(2));
		s.getBloke(3).setKasila(1,2, new Kasila(6));
		s.getBloke(3).setKasila(2,0, new Kasila(7));
		s.getBloke(3).getKasila(2,0).setFinkoa(true);
		s.getBloke(3).setKasila(2,1, new Kasila(1));
		s.getBloke(3).setKasila(2,2, new Kasila(3));

		s.getBloke(4).setKasila(0,0, new Kasila(7));
		s.getBloke(4).setKasila(0,1, new Kasila(6));
		s.getBloke(4).getKasila(0,1).setFinkoa(true);
		s.getBloke(4).setKasila(0,2, new Kasila(1));
		s.getBloke(4).setKasila(1,0, new Kasila(8));
		s.getBloke(4).getKasila(1,0).setFinkoa(true);
		s.getBloke(4).setKasila(1,1, new Kasila(5));
		s.getBloke(4).setKasila(1,2, new Kasila(3));
		s.getBloke(4).getKasila(1,2).setFinkoa(true);
		s.getBloke(4).setKasila(2,0, new Kasila(9));
		s.getBloke(4).setKasila(2,1, new Kasila(2));
		s.getBloke(4).getKasila(2,1).setFinkoa(true);
		s.getBloke(4).setKasila(2,2, new Kasila(4));

		s.getBloke(5).setKasila(0,0, new Kasila(4));
		s.getBloke(5).setKasila(0,1, new Kasila(2));
		s.getBloke(5).setKasila(0,2, new Kasila(3));
		s.getBloke(5).getKasila(0,2).setFinkoa(true);
		s.getBloke(5).setKasila(1,0, new Kasila(7));
		s.getBloke(5).setKasila(1,1, new Kasila(9));
		s.getBloke(5).setKasila(1,2, new Kasila(1));
		s.getBloke(5).getKasila(1,2).setFinkoa(true);
		s.getBloke(5).setKasila(2,0, new Kasila(8));
		s.getBloke(5).setKasila(2,1, new Kasila(5));
		s.getBloke(5).setKasila(2,2, new Kasila(6));
		s.getBloke(5).getKasila(2,2).setFinkoa(true);

		s.getBloke(6).setKasila(0,0, new Kasila(9));
		s.getBloke(6).setKasila(0,1, new Kasila(6));
		s.getBloke(6).getKasila(0,1).setFinkoa(true);
		s.getBloke(6).setKasila(0,2, new Kasila(1));
		s.getBloke(6).setKasila(1,0, new Kasila(2));
		s.getBloke(6).setKasila(1,1, new Kasila(8));
		s.getBloke(6).setKasila(1,2, new Kasila(7));
		s.getBloke(6).setKasila(2,0, new Kasila(3));
		s.getBloke(6).setKasila(2,1, new Kasila(4));
		s.getBloke(6).setKasila(2,2, new Kasila(5));

		s.getBloke(7).setKasila(0,0, new Kasila(5));
		s.getBloke(7).setKasila(0,1, new Kasila(3));
		s.getBloke(7).setKasila(0,2, new Kasila(7));
		s.getBloke(7).setKasila(1,0, new Kasila(4));
		s.getBloke(7).getKasila(1,0).setFinkoa(true);
		s.getBloke(7).setKasila(1,1, new Kasila(1));
		s.getBloke(7).getKasila(1,1).setFinkoa(true);
		s.getBloke(7).setKasila(1,2, new Kasila(9));
		s.getBloke(7).getKasila(1,2).setFinkoa(true);
		s.getBloke(7).setKasila(2,0, new Kasila(2));
		s.getBloke(7).setKasila(2,1, new Kasila(8));
		s.getBloke(7).getKasila(2,1).setFinkoa(true);
		s.getBloke(7).setKasila(2,2, new Kasila(6));

		s.getBloke(8).setKasila(0,0, new Kasila(2));
		s.getBloke(8).getKasila(0,0).setFinkoa(true);
		s.getBloke(8).setKasila(0,1, new Kasila(8));
		s.getBloke(8).getKasila(0,1).setFinkoa(true);
		s.getBloke(8).setKasila(0,2, new Kasila(4));
		s.getBloke(8).setKasila(1,0, new Kasila(6));
		s.getBloke(8).setKasila(1,1, new Kasila(3));
		s.getBloke(8).setKasila(1,2, new Kasila(5));
		s.getBloke(8).getKasila(1,2).setFinkoa(true);
		s.getBloke(8).setKasila(2,0, new Kasila(1));
		s.getBloke(8).setKasila(2,1, new Kasila(7));
		s.getBloke(8).getKasila(2,1).setFinkoa(true);
		s.getBloke(8).setKasila(2,2, new Kasila(9));
		s.getBloke(8).getKasila(2,2).setFinkoa(true);
		//Bloke proba:
		System.out.println("- Bloke guztiak ondo daude eta bueltatzen duen emaitza -1 da? "+s.laguntzaBloke());
		s.getBloke(1).getKasila(0, 2).setFinkoa(true);
		s.getBloke(1).getKasila(0, 2).setBalioZuzena(1);
		System.out.println("- 2. blokean zenbaki errepikatu bat gehituko dugu(finko moduan)...1 ematen du? "+s.laguntzaBloke());
		s.getBloke(1).getKasila(0, 2).setFinkoa(false);
		s.getBloke(1).getKasila(0, 2).setBalioZuzena(8);
		s.getBloke(8).getKasila(2, 0).aldatu(5);

		System.out.println("- 9. blokean zenbaki errepikatu bat gehitu dugu...8 ematen du? "+s.laguntzaBloke());
		s.getBloke(1).getKasila(0, 2).setFinkoa(true);
		s.getBloke(1).getKasila(0, 2).setBalioZuzena(1);
		System.out.println("- 2 Bloke ezberdinetan zenbakiak errepikatuta daude...8 edo 1 ematen du? "+s.laguntzaBloke());
		s.getBloke(1).getKasila(0, 2).setFinkoa(false);
		s.getBloke(1).getKasila(0, 2).setBalioZuzena(8);
		s.getBloke(8).getKasila(2, 0).aldatu(0);
		//
		System.out.println("Zutabe proba:");
		System.out.println();
		System.out.println("Zutabe guztiak ondo daude eta bueltatzen duen emaitza -1 da? "+s.laguntzaZutabe());
		s.getBloke(0).getKasila(0, 2).setFinkoa(true);
		s.getBloke(0).getKasila(0, 2).setBalioZuzena(1);
		s.getBloke(3).getKasila(0, 2).setFinkoa(true);
		s.getBloke(3).getKasila(0, 2).setBalioZuzena(1);

		System.out.println("- 3.zutabean zenbaki errepikatu bat gehituko dugu(finko moduan)...2 ematen du? "+s.laguntzaZutabe());
		s.getBloke(1).getKasila(0, 2).setFinkoa(false);
		s.getBloke(1).getKasila(0, 2).setBalioZuzena(8);
		s.getBloke(3).getKasila(0, 2).setFinkoa(false);
		s.getBloke(3).getKasila(0, 2).setBalioZuzena(2);

		s.getBloke(8).getKasila(0, 2).aldatu(9);
		System.out.println("- 9. zutabean zenbaki errepikatu gehitu da...8 ematen du? "+s.laguntzaZutabe());
		s.getBloke(6).getKasila(0, 0).aldatu(5);
		System.out.println("- 2 Zutabe ezberdinetan zenbakiak errepikatuta daude...8 edo 0 ematen du? "+s.laguntzaZutabe());
		s.getBloke(6).getKasila(0, 0).aldatu(0);
		s.getBloke(8).getKasila(0, 2).aldatu(0);

		//
		System.out.println("Ilara proba:");
		System.out.println();
		System.out.println("- Ilara guztiak ondo daude eta bueltatzen duen emaitza -1 da? "+s.laguntzaIlarak());

		s.getBloke(1).getKasila(0, 0).setFinkoa(true);
		s.getBloke(1).getKasila(0, 0).setBalioZuzena(5);

		System.out.println("- 1.ilaran zenbaki errepikatu bat gehituko dugu(finko moduan)...0 ematen du? "+s.laguntzaIlarak());
		s.getBloke(1).getKasila(0, 0).setFinkoa(false);
		s.getBloke(1).getKasila(0, 0).setBalioZuzena(6);

		s.getBloke(7).getKasila(2, 2).aldatu(8);
		System.out.println("- 9. ilaran zenbaki errepikatua gehitu da...8 ematen du? "+s.laguntzaIlarak());
		s.getBloke(1).getKasila(0, 0).setBalioZuzena(5);
		System.out.println("- 2 Ilara ezberdinetan zenbakiak errepikatuta daude...8 edo 0 ematen du? "+s.laguntzaIlarak());
		s.getBloke(1).getKasila(0, 0).aldatu(0);
		s.getBloke(7).getKasila(2, 2).aldatu(0);
	}

	private static void klasifikazioaLeihoaFrogak() {
		//System.out.println("Klasifikazio leihoaren frogak:\n------------------------------");  	
	}


	private static void klasifikazioaFrogak() {

		klasifikazioBerriaSortuFrogak();
		addFrogak();
		eguneratuFrogak();
		emanErabHonenPosFrogak();
		erabiltzaileenListaKlasifikatorianFrogak();
		tamainaFrogak();


	}

	private static void tamainaFrogak() {
		Klasifikazioa kl=new Klasifikazioa();
		System.out.println("Hasieran tamaina 0?"+ kl.tamaina());
		kl.eguneratu();
		System.out.println("Erabiltzaile bi daudelari ErabiltzaileListan klasifikazioa eguneratuta, tamaina 2?"+ kl.tamaina());
		kl.inprimatuKlasifikazioa();


	}

	private static void erabiltzaileenListaKlasifikatorianFrogak() {
		Klasifikazioa kl=new Klasifikazioa();
		System.out.println("Hasieran ez du ezer ematen?");
		ArrayList<Erabiltzaile> arr=kl.erabiltzaileenListaKlasifikatorian();
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).inprimatuDatuak();
		}
		kl.eguneratu();
		System.out.println("Bi erabiltzaile daudelarik lehena martin2 eta bigarrena martin?");
		arr=kl.erabiltzaileenListaKlasifikatorian();
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).inprimatuDatuak();
		}

	}

	private static void emanErabHonenPosFrogak() {

		ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("martin2", "12345");
		Erabiltzaile erab3 = ErabiltzaileLista.getErabiltzaileLista().bilatuErabiltzaile("martin2", "12345");
		System.out.println("Hasieran...");
		Klasifikazioa klasif=new Klasifikazioa();
		System.out.println("Klasifikazioa berria sortu da");
		if (klasif.erabiltzaileenListaKlasifikatorian().isEmpty()){
			System.out.println("Zerrenda hutsik");
		}
		klasif.inprimatuKlasifikazioa();
		klasif.erabiltzaileenListaKlasifikatorian().add(erab3);
		System.out.println("Klasifikazioa eguneratu aurretik...");
		if (klasif.erabiltzaileenListaKlasifikatorian().isEmpty()){
			System.out.println("Zerrenda hutsik");
		}erab3.gehituPuntuak(100);
		klasif.eguneratu();

		System.out.println("Eguneratu ostean...");
		System.out.println(erab3.getIzen()+"-(r)en Posizioa: "+klasif.emanErabHonenPos(erab3));
		klasif.inprimatuKlasifikazioa();
	}


	private static void eguneratuFrogak() {
		Erabiltzaile erab3=new Erabiltzaile("martin2", 7, "12345");
		Zifra zifrPas = new Zifra(erab3.getPasahitza());
		try {
			String zifra= zifrPas.encrypt("12345");
			System.out.println("Zifratutako pasahitza: "+zifra);
			if (zifrPas.decrypt(zifra).equals("12345")) {
				System.out.println("Deszifratu...OK");
			}else System.out.println("Deszifratu...ERROR");
			ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("martin", "12345",zifra);
			System.out.println("Hasieran...");
			Klasifikazioa klasif=new Klasifikazioa();
			System.out.println("Klasifikazioa berria sortu da");
			if (klasif.erabiltzaileenListaKlasifikatorian().isEmpty()){
				System.out.println("Zerrenda hutsik");
			}
			klasif.inprimatuKlasifikazioa();
			klasif.erabiltzaileenListaKlasifikatorian().add(erab3);
			System.out.println("Klasifikazioa eguneratu aurretik...");
			if (klasif.erabiltzaileenListaKlasifikatorian().isEmpty()){
				System.out.println("Zerrenda hutsik");
			}erab3.gehituPuntuak(100);
			klasif.eguneratu();
			System.out.println("Eguneratu ostean...");
			klasif.inprimatuKlasifikazioa();}
		catch(Exception e){
			e.printStackTrace();
		}


	}

	private static void addFrogak() {
		System.out.println("- Erabiltzailea era zuzenean gehitzen da?");
		Erabiltzaile erab3=new Erabiltzaile("martin2", 7, "12345");
		Zifra zifrPas = new Zifra(erab3.getPasahitza());
		try {
			String zifra= zifrPas.encrypt("12345");
			System.out.println("Zifratutako pasahitza: "+zifra);
			if (zifrPas.decrypt(zifra).equals("12345")) {
				System.out.println("Deszifratu...OK");
			}else System.out.println("Deszifratu...ERROR");
			ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("martin", "12345",zifra);
			System.out.println("Hasieran...");
			Klasifikazioa klasif=new Klasifikazioa();
			System.out.println("Klasifikazioa berria sortu da");
			if (klasif.erabiltzaileenListaKlasifikatorian().isEmpty()){
				System.out.println("Zerrenda hutsik");
			}
			klasif.inprimatuKlasifikazioa();
			klasif.erabiltzaileenListaKlasifikatorian().add(erab3);
			klasif.eguneratu();
			System.out.println("Bukaeran...");
			klasif.inprimatuKlasifikazioa();}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	private static void klasifikazioBerriaSortuFrogak() {
		System.out.println("- Klasifikazioa sortzen da? -");
		Klasifikazioa klasif=new Klasifikazioa();
		if (klasif instanceof Klasifikazioa){
			System.out.println("Kaixo klasifikazio berria naiz!");
		}
		else System.out.println("Klasifikazioa ez dago");

	}

	private static void generadoreSudokuFrogak() {
		System.out.println("Sudoku berria ausaz eta zailtazunaren arabera sortzen da?\n---------------------------------------------------------");

		System.out.println("- Kasila kopuru egokia kentzen da zailtasunaren arabera?");
		int kontErraza=0;
		int kontErtaina=0;
		int kontZaila=0;
		GeneradoreSudoku sErraza = new GeneradoreSudoku(0);
		GeneradoreSudoku sErtaina = new GeneradoreSudoku(1);
		GeneradoreSudoku sZaila = new GeneradoreSudoku(2);
		sErraza.beteAusaz();
		sErtaina.beteAusaz();
		sZaila.beteAusaz();
		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sErraza.getSudokuKasila(f, i).getErabiltzaileBal()==0){
					kontErraza++;
				}
			}
		}
		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sErtaina.getSudokuKasila(f, i).getErabiltzaileBal()==0){
					kontErtaina++;
				}
			}
		}
		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sZaila.getSudokuKasila(f, i).getErabiltzaileBal()==0){
					kontZaila++;
				}
			}
		}
		System.out.print("Sudoku errezari kendutako kasila kopurua: "+kontErraza+" ");
		if (kontErraza>=44&&kontErraza<48){
			System.out.println("Erraza...OK");
		}
		else
			System.out.println("Erraza...ERROR");
		System.out.print("Sudoku ertainari kendutako kasila kopurua: "+kontErtaina+" ");
		if (kontErtaina>=48&&kontErtaina<52){
			System.out.println("Ertaina...OK");
		}
		else
			System.out.println("Ertaina...ERROR");
		System.out.print("Sudoku zailari kendutako kasila kopurua: "+kontZaila+" ");


		if (kontZaila>=52&&kontZaila<56){
			System.out.println("Zaila...OK");
		}
		else
			System.out.println("Zaila...ERROR");

		System.out.println("- Sudokuek soluzio bakarra dute?");
		if (sErraza.soluzioBakarra()) {
			System.out.println("Erraza...OK");
		}
		else System.out.println("Erraza...ERROR");
		if (sErtaina.soluzioBakarra()) {
			System.out.println("Ertaina...OK");
		}
		else System.out.println("Ertaina...ERROR");
		if (sZaila.soluzioBakarra()) {
			System.out.println("Zaila...OK");
		}
		else System.out.println("Zaila...ERROR");

	}

	private static void erregistroLehioaFrogak() {
		System.out.println("3.Erregistroa ondo dabil?\n-------------------------");
		Erabiltzaile erab4=new Erabiltzaile("martin2", 7, "12345");

		Zifra zifrPas = new Zifra(erab4.getPasahitza());
		try {
			String zifra= zifrPas.encrypt("12345");
			System.out.println("Zifratutako pasahitza: "+zifra);

			ErabiltzaileLista.getErabiltzaileLista().gehituErabiltzaile("martin", "12345",zifra);
			if (ErabiltzaileLista.getErabiltzaileLista().badago("martin")) {
				System.out.println("Erailtzailea gehitu...OK");
			}else System.out.println("Erabiltzailea gehitu...ERROR");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void aukeratuLeihoaFrogak() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-oOo-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("2.Aukeratu leihoaren metodoen frogak:\n------------------------------------");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");

		//klasifikazioaFrogak();
		generadoreSudokuFrogak();
		zailtasunaFrogak();
		klasifikazioaFrogak();
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");
	}

	private static void zailtasunaFrogak() {

		System.out.println("- Zailtasun bat aukeratuta beharrezko kasilak kentzen dira?");
		int kontErraza=0;
		int kontErtaina=0;
		int kontZaila=0;
		Sudokua sErraza = new SudokuAdapter();
		Sudokua sErtaina = new SudokuAdapter();
		Sudokua sZaila = new SudokuAdapter();
		sErraza.ausazBete(0);
		sErtaina.ausazBete(1);
		sZaila.ausazBete(2);


		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sErraza.getKasila(f, i).getErabiltzaileBal()==0){
					kontErraza++;
				}
			}
		}
		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sErtaina.getKasila(f, i).getErabiltzaileBal()==0){
					kontErtaina++;
				}
			}
		}
		for (int f = 0; f < 9; f++) {
			for (int i = 0; i < 9; i++) {
				if(sZaila.getKasila(f, i).getErabiltzaileBal()==0){
					kontZaila++;
				}
			}
		}
		System.out.print("Sudoku errezari kendutako kasila kopurua: "+kontErraza+" ");
		if (kontErraza>=44&&kontErraza<48){
			System.out.println("Erraza...OK");
		}
		else
			System.out.println("Erraza...ERROR");
		System.out.print("Sudoku ertainari kendutako kasila kopurua: "+kontErtaina+" ");
		if (kontErtaina>=48&&kontErtaina<52){
			System.out.println("Ertaina...OK");
		}
		else
			System.out.println("Ertaina...ERROR");
		System.out.print("Sudoku zailari kendutako kasila kopurua: "+kontZaila+" ");


		if (kontZaila>=52&&kontZaila<56){
			System.out.println("Zaila...OK");
		}
		else
			System.out.println("Zaila...ERROR");


	}



	private static void adabegiFrogak() {
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-oOo-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("1.Adabegi klasearen metodoen frogak:\n------------------------------------");
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");
		adabegiaSortuFrogak();
		semeaGehituFrogak();
		semeaEzabatuFrogak();
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");
	}

	private static void semeaEzabatuFrogak() {
		System.out.print("- Semea ezabatzen da? \n");
		Adabegia<String> ada=new Adabegia<String>("Adabegi berria naiz", 0);
		Adabegia<String> adaSeme=ada.gehituSemea("Ni semea naiz aldiz", 0);
		System.out.print(ada.content+",");
		System.out.println(adaSeme.content);
		System.out.println("Semerik gabe utziko dugu adabegia:");
		ada.ezabatuSemea("Ni semea naiz aldiz");
		if(ada.semea.isEmpty())System.out.println("Semea ezabatuta...OK");
		else System.out.println("Ezin izan da semea ezabatu...ERROR");

	}

	private static void semeaGehituFrogak() {
		System.out.print("- Semea sortzen da? ");
		Adabegia<String> ada=new Adabegia<String>("Adabegi berria naiz", 0);
		Adabegia<String> adaSeme=ada.gehituSemea("Ni semea naiz aldiz", 0);
		System.out.print(ada.content+",");
		System.out.println(adaSeme.content);

		if (ada.semea==null) {
			System.out.println("Ez da gehitu....ERROR");
		}
		else System.out.println("Gehitu da....OK");
	}

	private static void adabegiaSortuFrogak() {
		System.out.print("- Adabegi berria zara? ");
		Adabegia<String> ada=new Adabegia<String>("Adabegi berria naiz", 0);
		if (ada.content.equals("Adabegi berria naiz"))
			System.out.println(ada.content+"\nSortu...OK");
		else
			System.out.println("Sortu...ERROR");
	}


	private static void sudokuaAusazBete() {
		System.out.println("0.Sudokua ausaz betetzen da?\n----------------------------");

		//GeneradoreSudoku s = new GeneradoreSudoku();
		Sudokua s = new SudokuAdapter();
		System.out.println("\nHasieran...\n");
		//s.beteAusaz();
		s.ausazBete(0);

		System.out.println("\nAusaz bete ondoren...\n");
		//		s.inprimatuSudokuZuzena();

		s.inprimatuSudoku();
		System.out.println("\n");
		//s.inprimatuZuzena();
	}

}
