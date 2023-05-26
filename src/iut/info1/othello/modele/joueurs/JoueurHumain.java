package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

public class JoueurHumain extends Joueur {

	public JoueurHumain(ContenuCase couleur) {
		super(couleur);
		System.out.println("Je suis un humain");
	}
}