package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;

/**
 * IA jouant en Othello aléatoirement.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class IAFacile extends IA {
	
	/**
	 * Crée une IA facile.
	 * @param couleur la couleur de pion associée.
	 */
	public IAFacile(ContenuCase couleur) {
		super(couleur);
		System.out.println("Je suis une IA facile");
	}
	
	@Override
	public void jouer(Modele modele) {
		int ligne;
		int colonne;
		boolean peutAjouterPion = false;
		int nbEchecs = 0;
		do {
			ligne   = (int) Math.random() * 8;
			colonne = (int) Math.random() * 8;
			peutAjouterPion = modele.peutAjouterPion(ligne, colonne, getCouleur());
		} while (!peutAjouterPion && nbEchecs < 200);
		if (peutAjouterPion) {
			modele.ajouterPion(ligne, colonne);
		}
		modele.changerJoueur();
	}
}
