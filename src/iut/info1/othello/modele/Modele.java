package iut.info1.othello.modele;

import static iut.info1.othello.modele.CouleurPion.BLANC;
import static iut.info1.othello.modele.CouleurPion.NOIR;
import static iut.info1.othello.modele.CouleurPion.RIEN;

public class Modele {
	
	CouleurPion[][] plateau = new CouleurPion[8][8];
	
	/**
	 * Crée un plateau de 8*8 cases avec la configuration
	 * par défaut.
	 */
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

	/**
	 * @return le tableau de pions
	 * Le tableau étant mutable, toute modification risque d'impacter DURABLEMENT
	 * le fonctionnement du programme. A utiliser pour lecture seulement.
	 */
	public CouleurPion[][] getPions() {
		return plateau;
	}

	/**
	 * Affiche les éléments du plateau.
	 */
	@Override
	public String toString() {
		String resultat = new String();
		for (int lignes = 0 ; lignes < getPions().length ; lignes++) {
			resultat += "-------------------------\n|";
			for (int colonnes = 0 ; colonnes < getPions()[lignes].length ; colonnes++) {
				String pion = " ";
				switch (getPions()[lignes][colonnes]) {
				case NOIR -> pion =  "⚫";
				case BLANC -> pion = "⚪";
				case RIEN -> pion =  "  ";
				}
				resultat += pion + "|";
			}
			resultat+="\n";
		}
		resultat += "-------------------------";
		return resultat;
	}
}
