package iut.info1.othello.controleur;


import iut.info1.othello.modele.Modele;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/** 
 * Contrôleur de la scène de jeu.
 */
public class ControleurJeu {

	/** correspond à la grille du plateau */
	@FXML
	private GridPane grille;
	
	/** Le modèle du jeu avec lequel le contrôleur interagit*/
	private Modele modele;
	

	/** Affiche le nom du joueur dont c'est le tour */
    @FXML
    private Label tourDuJoueur;
	
	/**
	 * Crée le contrôleur de jeu et lui associe un modèle.
	 * @param modele le modèle associé, avec des joueurs différents.
	 */
	public ControleurJeu(Modele modele) {
		this.modele = modele;
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

	/**
	 * Permet au joueur de passer son tour.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void passerTour(ActionEvent event) {
		modele.changerJoueur();
	}

	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void startNewGame(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU_MODE_JEU);
	}
	
	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void stopGame(ActionEvent event) {
		System.err.println("Not yet implemented");
	}
	
	/**
	 * Ouvre le Menu d'aide.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void openAide(ActionEvent event) {
		Main.changerSceneAide();
	}
	
	/**
	 * Revient au Menu de choix de mode de jeu.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void backToMenu(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU);
	}
	
	private void updateTourDuJoueur() {
		tourDuJoueur.setText("C'est le tour du joueur " + modele.getJoueurActuel().getNom());
	}
}
