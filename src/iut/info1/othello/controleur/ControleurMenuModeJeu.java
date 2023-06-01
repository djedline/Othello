package iut.info1.othello.controleur;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;

import iut.info1.othello.modele.Modele;
import iut.info1.othello.modele.joueurs.IADifficile;
import iut.info1.othello.modele.joueurs.IAFacile;
import iut.info1.othello.modele.joueurs.JoueurHumain;
import javafx.fxml.FXML;

/**
 * Affiche le menu de choix du mode de jeu.
 */
public class ControleurMenu {

	public ControleurMenu() {
	}
	
	@FXML
	public void creerPartiePVP() {
		new Modele(new JoueurHumain(BLANC), new JoueurHumain(NOIR));
	}
	
	@FXML
	public void creerPartieIAFacile() {
		new Modele(new JoueurHumain(BLANC), new IAFacile(NOIR));
	}
	
	@FXML
	public void creerPartieIADifficile() {
		new Modele(new JoueurHumain(BLANC), new IADifficile(NOIR));
	}

}
