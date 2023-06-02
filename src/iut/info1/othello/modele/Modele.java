package iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.joueurs.Joueur;

public class Modele {
	
	Joueur joueur1;
	Joueur joueur2;
	Joueur joueurActuel;
	
	//TODO ajouter constructeur en fonction du type de jeu
	
	ContenuCase[][] plateau = new ContenuCase[8][8];
	
	/**
	 * Crée un plateau de 8*8 cases avec la configuration
	 * par défaut.
	 */
	public Modele(Joueur j1, Joueur j2) {
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
	 * Permet de changer le joueur qui doit jouer, au changement
	 * de tour.
	 */
	public void changerJoueur() {
		if (joueur1 == joueurActuel) {
			joueurActuel = joueur2;
		} else {
			joueurActuel = joueur1;
		}
	}
	
	/** 
	 * Permet d'ajouter un pion au tableau de pions représentant
	 * le tableau de jeu. La couleur est déduite automatiquement.
	 * @param ligne la ligne où ajouter le pion (de 0 à 7)
	 * @param colonne la colonne où ajouter le pion (de 0 à 7)
	 */
	public void ajouterPion(int ligne, int colonne) {
	}
	
	public boolean peutAjouterPion(int ligne, int colonne, ContenuCase couleur) {
		return ligne >= 0 && ligne <= 7
				&& colonne >= 0 && colonne <= 7
				&& (couleur == BLANC || couleur == NOIR)
				&& plateau[ligne][colonne] == RIEN;
	}
	
	/**
	 * Permet de trouver l'ensemble des cases adjacentes (diagonales inclues) au pion qui va être posé
	 * 
	 *  
	 */
	
	//TODO faire la fonction
	
	
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
