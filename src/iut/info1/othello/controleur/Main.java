package iut.info1.othello.controleur;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Point d'entrée du jeu.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class Main extends Application {
	
	/** 
	 * Indice pour la scène du menu principal
	 */
	public static final int SCENE_MENU = 0;
	
	/** 
	 * Indice pour la scène du menu de choix du mode de jeu
	 */
	public static final int SCENE_MENU_MODE_JEU = 1;
	
	/** 
	 * Indice pour la scène du jeu
	 */
	public static final int SCENE_JEU = 2;
	
	private static Scene[] scenes = new Scene[3];
	
	private static Stage fenetre;

	/**
	 * Crée les scènes au sein de la fenêtre de jeu.
	 * @see {@code javafx.application.Application#start(Stage)}
	 */
	@Override
	public void start(Stage stage) throws Exception {
		fenetre = stage;
		scenes[0] = createScene("../vue/Menu.fxml");
		scenes[1] = createScene("../vue/MenuModeDeJeu.fxml");
		scenes[2] = createScene("../vue/Jeu.fxml");
		fenetre.setTitle("Othello");
		fenetre.setScene(scenes[SCENE_MENU]);
		fenetre.show();
	}

	/**
	 * Crée une scène à partir de l'URL de son fichier fxml.
	 * @param urlFXML l'url relative à ce fichier du fichier FXML
	 * @return la scene issue de ce fichier
	 * @throws IOException si le fichier ne peut être créé
	 */
	public Scene createScene(String urlFXML) throws IOException {
		FXMLLoader chargeurFXML = new FXMLLoader();
		chargeurFXML.setLocation(getClass().getResource(urlFXML));
		Parent racine = chargeurFXML.load();
		Scene scene = new Scene(racine);
		return scene;
	}
	
	/**
	 * Change la scène affichée dans la fenêtre par celle
	 * dont le numéro est indiqué en paramètre. Voir constantes
	 * de scène.
	 * @param numeroScene l'indice de la scène à utiliser
	 */
	public static void changerScene(int numeroScene) {
		if (numeroScene < 0 || numeroScene >= scenes.length) {
			throw new IllegalArgumentException();
		}
		changerScene(scenes[numeroScene]);
	}
	
	/**
	 * Change la scène affichée dans la fenêtre par celle passée en paramètre
	 * et l'affiche
	 * @param scene la scène à afficher 
	 */
	private static void changerScene(Scene scene) {
		fenetre.setScene(scene);
		fenetre.show();
	}

	/**
	 * Point d'entrée de l'application
	 * @param args les arguments de la ligne de commande (inutilisés)
	 */
	public static void main(String[] args) {
		launch();
	}
}
