package iut.info1.othello.controleur;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;

import iut.info1.othello.modele.Modele;
import iut.info1.othello.modele.joueurs.IADifficile;
import iut.info1.othello.modele.joueurs.IAFacile;
import iut.info1.othello.modele.joueurs.JoueurHumain;
import javafx.fxml.FXML;

/**
 * Le contrôleur associé au menu du choix du mode de jeu.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class ControleurMenuModeJeu {
	
	/**
	 * Lance une partie entre joueurs humains et affiche l'écran de jeu.
	 */
	@FXML
	public void creerPartiePVP() {
		new Modele(new JoueurHumain(BLANC), new JoueurHumain(NOIR));
		Main.changerScene(Main.SCENE_JEU);
	}
	
	/**
	 * Lance une partie avec une IA facile et affiche l'écran de jeu.
	 */
	@FXML
	public void creerPartieIAFacile() {
		new Modele(new JoueurHumain(BLANC), new IAFacile(NOIR));
		Main.changerScene(Main.SCENE_JEU);
	}
	
	/**
	 * Lance une partie avec une IA difficile et affiche l'écran de jeu.
	 */
	@FXML
	public void creerPartieIADifficile() {
		new Modele(new JoueurHumain(BLANC), new IADifficile(NOIR));
		Main.changerScene(Main.SCENE_JEU);
	}

}
