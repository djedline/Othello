package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

/**
 * Représente un joueur humain.
 */
public class JoueurHumain extends Joueur {

	/**
	 * Crée un joueur humain.
	 * @param couleur la couleur de pion associée.
	 */
	public JoueurHumain(ContenuCase couleur) {
		super(couleur);
		System.out.println("Je suis un humain");
	}
}