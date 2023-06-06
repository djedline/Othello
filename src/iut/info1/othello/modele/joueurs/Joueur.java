package iut.info1.othello.modele.joueurs;

import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.ContenuCase;

/**
 * Représente tout joueur, qu'il s'agisse d'un joueur humain ou d'une IA.
 */
public class Joueur {

	/**
	 * Nom du joueur.
	 */
	protected String nom;
	
	/**
	 * La couleur de pion associée au joueur. Ne peut être RIEN.
	 */
	private ContenuCase couleur;

	/**
	 * Crée un joueur assigné à une couleur de pion.
	 * @param couleur la couleur de pion associée.
	 * @param i l'indice du joueur
	 * @throws IllegalArgumentException si la couleur passée en paramètre
	 * est RIEN.
	 */
	public Joueur(int i, ContenuCase couleur) {
		if (couleur == RIEN) {
			throw new IllegalArgumentException("Un joueur ne peut "
					+ "poser des cases vides.");
		}
		this.couleur = couleur;
		this.nom = "Joueur " + i;
	}

	/**
	 * @return la couleur du joueur
	 */
	public ContenuCase getCouleur() {
		return couleur;
	}
	
	/**
	 * @return le nom par défaut du joueur.
	 */
	public String getNom() {
		return nom;
	}

}
