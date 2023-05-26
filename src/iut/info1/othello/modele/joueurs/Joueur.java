package iut.info1.othello.modele.joueurs;

import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.ContenuCase;

public class Joueur {

	String nom;
	ContenuCase couleur;

	public Joueur(ContenuCase couleur) {
		if (couleur != RIEN) {
			this.couleur = couleur;}
	}

	public ContenuCase getCouleur() {
		return couleur;
	}

	public void jouer() {

	}

}
