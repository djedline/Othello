package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleurMenu {
	
	@FXML
	void aide(ActionEvent event) {
		System.out.println("Not yet implemented");
	}

	@FXML
	void continuer(ActionEvent event) {
		System.out.println("Not yet implemented");
	}

	@FXML
	void nouvellePartie(ActionEvent event) {
		Main.changerScene(Main.sceneMenuModeJeu);
	}

}
