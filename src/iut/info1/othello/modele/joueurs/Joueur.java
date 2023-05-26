package iut.info1.othello.modele.joueurs;

import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.ContenuCase;

public class Joueur {

	String nom;
	ContenuCase couleur;

	/**
	 * Crée un joueur assigné à une couleur de pion.
	 * @param couleur
	 */
	public Joueur(ContenuCase couleur) {
		if (couleur == RIEN) {
			throw new IllegalArgumentException("Un joueur ne peut "
					+ "poser des cases vides.");
		}
		this.couleur = couleur;
	}

	public ContenuCase getCouleur() {
		return couleur;
	}

	public void jouer() {

	}

}
