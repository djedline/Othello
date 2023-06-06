package iut.info1.othello.controleur;


import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;
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
	
	private Modele modele;
	
	public ControleurJeu(Modele modele) {
		this.modele = modele;
	}

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
		Main.changerSceneAide();
	}
	
	/**
	 * Revient au Menu de choix de mode de jeu.
	 * @param event l'évènement déclenché
	 */
	@FXML
	void backToMenu(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU);
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
					System.out.printf("Ligne : %d, colonne : %d\n", row, column);
					if(modele.peutAjouterPion(row, column, 
					   modele.getJoueurActuel().getCouleur())) {
							modele.ajouterPion(row, column);
					};
					System.out.println(modele);
				}
			});
		}
	}
}
