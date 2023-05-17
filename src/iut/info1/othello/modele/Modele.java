package iut.info1.othello.modele;

import static iut.info1.othello.modele.CouleurPion.BLANC;
import static iut.info1.othello.modele.CouleurPion.NOIR;
import static iut.info1.othello.modele.CouleurPion.RIEN;

public class Modele {
	
	CouleurPion[][] plateau = new CouleurPion[8][8];
	
	public Modele() {
		for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
			for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
				plateau[lignes][colonnes] = RIEN;
			}
		}
		plateau[3][3] = NOIR;
		plateau[4][4] = NOIR;
		plateau[3][4] = BLANC;
		plateau[4][3] = BLANC;
	}

	public CouleurPion[][] getPions() {
		return plateau;
	}

	@Override
	public String toString() {
		String resultat = new String();
		for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
			resultat += "--------------";
			for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
				resultat += String.format("%2d", plateau[lignes][colonnes]);
			}
		}
		return super.toString();
	}

}
