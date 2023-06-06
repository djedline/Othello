package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleurAide {
	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void retourMenu(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU);
	}

}
