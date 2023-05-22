package iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;

public class Modele {
	
	Joueur joueur1;
	Joueur joueur2;
	
	//TODO ajouter constructeur en fonction du type de jeu
	
	ContenuCase[][] plateau = new ContenuCase[8][8];
	
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
	public ContenuCase[][] getPions() {
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
	
	/** 
	 * Permet d'ajouter un pion au tableau de pions représentant
	 * le tableau de jeu. La couleur est déduite automatiquement.
	 * @param ligne la ligne où ajouter le pion (de 0 à 7)
	 * @param colonne la colonne où ajouter le pion (de 0 à 7)
	 */
	public boolean ajouterPion(int ligne, int colonne) {
		return true; //TODO bouchon
	}
	
	public boolean peutAjouterBouton(int ligne, int colonne, ContenuCase couleur) {
		return true; //TODO bouchon
	}
}
