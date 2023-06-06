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
	public JoueurHumain(int i, ContenuCase couleur) {
		super(i, couleur);
		super.nom = "Joueur humain " + i;
	}
}