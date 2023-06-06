package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;

/**
 * Représente les IA faciles et difficiles.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class IA extends Joueur {

	/**
	 * @see {@code iut.info1.othello.modele.joueurs.Joueur#Joueur(int, ContenuCase)}
	 */
	public IA(int i, ContenuCase couleur) {
		super(i, couleur);
	}
	
	public void jouer(Modele modele) {
	}

}
