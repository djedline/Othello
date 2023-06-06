package iut.info1.othello.controleur;


import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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
					ContenuCase couleur = modele.getJoueurActuel().getCouleur();
					if (modele.peutAjouterPion(row, column, couleur)) {
						modele.ajouterPion(row, column);
						changerPion(child, couleur);
					};
					System.out.println(modele);
					updateTourDuJoueur();
				}
			});
		}
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
		tourDuJoueur.setText("C'est le tour de " + modele.getJoueurActuel().getNom());
	}

	/**
	 * Permet de changer l'apparence d'une case sur le plateau.
	 * @param bouton la case à modifier
	 * @param couleur la couleur a ajouter (NOIR ou BLANC)
	 * @throws IllegalArgumentException si la couleur du pion est invalide.
	 */
	protected void changerPion(Node bouton, ContenuCase couleur) {
		if (couleur == RIEN) {
			throw new IllegalArgumentException("Impossible d'ajouter un pion vide");
		}
		String cssColor;
		//String url;
		if (couleur == BLANC) {
			cssColor = "blanc";
			/*
			url = ControleurJeu.class.getResource(
					"../../../../../../images/pion_noir.png").toExternalForm();
					
					*/
		} else {
			cssColor = "noir";
			/*
			url = ControleurJeu.class.getResource(
					"../../../../../../images/pion_blanc.png").toExternalForm();
					*/
		}
		//Image imagePion = new Image(url);
		if (bouton instanceof Button) {
			Button clicked = (Button) bouton;
			clicked.getStyleClass().remove("plateau-case");
			clicked.getStyleClass().add(cssColor);
			clicked.applyCss();
			/*
			BackgroundImage bg = new BackgroundImage(imagePion, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
							BackgroundPosition.CENTER, null);
			Platform.runLater(() -> clicked.getStyleClass().add("blanc"));
			clicked.setBackground(Background.fill(new Color(0.1, 0.1, 0.1, 1)));
			*/
		
		}
	}
}