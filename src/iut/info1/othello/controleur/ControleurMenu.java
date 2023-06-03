package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Le contrôleur associé au menu principal
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class ControleurMenu {
	
	/**
	 * Affiche l'aide du jeu.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void aide(ActionEvent event) {
		Main.changerScene(Main.SCENE_AIDE);
	}

	/**
	 * Permet de continuer une partie sauvegardée.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void continuer(ActionEvent event) {
		System.err.println("Not yet implemented");
	}

	/**
	 * Permet de commencer une nouvelle partie
	 * @param event l'évènement déclenché
	 */
	@FXML
	void nouvellePartie(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU_MODE_JEU);
	}

}
