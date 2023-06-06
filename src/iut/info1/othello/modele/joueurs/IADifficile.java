package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

/**
 * Représente une IA difficile.
 */
public class IADifficile extends IA {
	
	/**
	 * Crée une IA difficile.
	 * @param i l'indice du joueur
	 * @param couleur la couleur de pion qui lui est associée.
	 */
	public IADifficile(int i, ContenuCase couleur) {
		super(i, couleur);
		System.out.println("Je suis une IA difficile");
	}

}
