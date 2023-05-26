package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

public class IAFacile extends Joueur {
	
	/**
	 * Crée une IA facile.
	 * @param couleur la couleur de pion associée.
	 */
	public IAFacile(ContenuCase couleur) {
		super(couleur);
		System.out.println("Je suis une IA facile");
	}
}
