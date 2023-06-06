package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControleurAide {
	
	private Stage fenetreAide;
	
	public ControleurAide(Stage fenetreAide) {
		this.fenetreAide = fenetreAide ;
	}
	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void retourMenu(ActionEvent event) {
	//	if (fenetreAide == null) 
		Main.changerScene(Main.SCENE_MENU);
	//	
	}
}
