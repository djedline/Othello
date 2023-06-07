package iut.info1.othello.controleur;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;
import iut.info1.othello.modele.joueurs.IA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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
	
	/** Contient le score du 1e joueur*/
    @FXML
    private Label score1;

    /** Contient le score du 2e joueur*/
    @FXML
    private Label score2;

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
				public void handle(MouseEvent event) {
					ControleurJeu.this.handle(child, event);
				}
			});
		}
	}
	
	/**
	 * Gère l'ajout de pion suite au clic.
	 * @param bouton le bouton affecté
	 * @param event l'évènement du clic
	 */
	void handle(Node bouton, MouseEvent event){
		int row = getRowOfChild(bouton);
		int column = getColumnOfChild(bouton);
		System.out.printf("Ligne : %d, colonne : %d\n", row, column);
		ContenuCase couleur = modele.getJoueurActuel().getCouleur();
		if (modele.peutAjouterPion(row, column, couleur)) {
			modele.ajouterPion(row, column);
			changerAffichagePion(bouton, couleur);
		};
		updateTourDuJoueur();
		updateScore();
	}
	
	/**
	 * Appelle la fonction de jeu de l'IA et affiche son résultat.
	 */
	protected void faireJouerIA(IA joueur) {
		joueur.jouer(modele);
	}

	/**
	 * @return la ligne dans laquelle on trouve l'enfant
	 */
	private int getRowOfChild(Node child){
		Integer row = GridPane.getRowIndex(child);
		row = (row == null) ? 0 : row;
		return row;
	}
	
	/**
	 * @return la colonne dans laquelle on trouve l'enfant
	 */
	private int getColumnOfChild(Node child){
		Integer column = GridPane.getColumnIndex(child);
		column = (column == null) ? 0 : column;
		return column;
	}
	
	/**
	 * Permet de retrouver un bouton dans la grille
	 * @throws IllegalArgumentException si le node n'est pas dans le plateau
	 */
	private Node identifiePion(int ligneCherchee, int colonneCherchee) {
		int row;
		int column;
		for (Node enfant : grille.getChildren()) {
			row = getRowOfChild(enfant);
			column = getColumnOfChild(enfant);
			if (row == ligneCherchee && column == colonneCherchee) {
				return enfant;
			}
		}
		throw new IllegalArgumentException("Ce Node n'appartient pas au plateau");
	}

	/**
	 * Revient au Menu pricipal.
	 * @param event l'évènement déclenché
	 */
	@FXML
	private void menuDeroulant(ActionEvent event) {
		Main.changerScene(Main.SCENE_MENU);
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
		new Alert(AlertType.WARNING, "Fonction non implémentée.", ButtonType.OK).show();
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
		tourDuJoueur.setText("C'est le tour de " + modele.getJoueurActuel().getNom());
	}
	
	private void updateScore() {
		score1.setText("" + modele.getPions().getBlanc());
		score2.setText("" + modele.getPions().getNoir());
	}

	/**
	 * Permet de changer l'apparence d'une case sur le plateau.
	 * @param bouton la case à modifier
	 * @param couleur la couleur a ajouter (NOIR ou BLANC)
	 * @throws IllegalArgumentException si la couleur du pion est invalide.
	 */
	private void changerAffichagePion(Node bouton, ContenuCase couleur) {
		if (couleur == ContenuCase.RIEN) {
			throw new IllegalArgumentException("Impossible d'ajouter un pion vide");
		}
		String cssColor;
		if (couleur == ContenuCase.BLANC) {
			cssColor = "blanc";
		} else {
			cssColor = "noir";
		}
		if (bouton instanceof Button) {
			Button clicked = (Button) bouton;
			clicked.getStyleClass().remove("plateau-case");
			clicked.getStyleClass().add(cssColor);
			clicked.applyCss();
		}
	}
}
