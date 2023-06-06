package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/** 
 * Contrôleur de la scène de jeu.
 */
public class ControleurJeu {

	/** correspond à la grille du plateau */
	@FXML
	private GridPane grille;

	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void startNewGame(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU_MODE_JEU);
	}
	
	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void stopGame(ActionEvent event) {
		System.err.println("Not yet implemented");
	}
	
	/**
	 * Ouvre le Menu d'aide.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void openAide(ActionEvent event) {
		Main.changerScene(Main.SCENE_AIDE);
	}
	
	/**
	 * Revient au Menu de choix de mode de jeu.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void backToMenu(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU_MODE_JEU);
	}
	
	/**
	 * Crée les écouteurs sur les boutons à l'initialisation du contrôleur.
	 */
	@FXML
	public void initialize() {
		for (Node child : grille.getChildren()) {
			child.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Integer row = grille.getRowIndex(child);
					Integer column = grille.getColumnIndex(child);
					row = (row == null) ? 0 : row;
					column = (column == null) ? 0 : column;
					System.out.println("Ligne : " + row + ", colonne : " + column);
					//TODO démerde toi pour appeler le modèle
				}
			});
		}
	}
}
