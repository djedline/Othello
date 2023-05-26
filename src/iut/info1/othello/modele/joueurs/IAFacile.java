package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

public class IAFacile extends Joueur {
	
	public IAFacile(ContenuCase couleur) {
		super(couleur);
		System.out.println("Je suis une IA facile");
	}
}
