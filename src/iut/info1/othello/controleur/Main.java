package iut.info1.othello.controleur;

import java.io.IOException;
import java.net.URL;

import iut.info1.othello.modele.Modele;
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

	private static Scene[] scenes = new Scene[2];

	private static Stage fenetre;

	/**
	 * Crée les scènes au sein de la fenêtre de jeu.
	 * @see {@code javafx.application.Application#start(Stage)}
	 */
	@Override
	public void start(Stage stage) throws Exception {
		fenetre = stage;

		try {
			scenes[0] = createScene("../vue/Menu.fxml");
			scenes[1] = createScene("../vue/MenuModeDeJeu.fxml");
		} catch (Exception e) {
			System.err.println(e.getMessage());;
		}

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
	private Scene createScene(String urlFXML) throws IOException {
		Scene scene;
		try {
			FXMLLoader chargeurFXML = new FXMLLoader();
			URL resource = Main.class.getResource(urlFXML);
			chargeurFXML.setLocation(resource);
			Parent racine = chargeurFXML.load();
			scene = new Scene(racine);

		} catch (Exception e) {
			throw new IOException("La scène : \"" + urlFXML 
					+ "\" n'a pas pu être crée.\n"
					+ e.getStackTrace());
		}
		return scene;
	}

	/**
	 * Crée une scène à partir de l'URL de son fichier fxml.
	 * @param urlFXML l'url relative à ce fichier du fichier FXML
	 * @return la scene issue de ce fichier
	 * @throws IOException si le fichier ne peut être créé
	 */
	private static Scene createScene(String urlFXML, Object controller) 
			throws IOException {
		Scene scene;
		try {
			FXMLLoader chargeurFXML = new FXMLLoader();
			URL resource = Main.class.getResource(urlFXML);
			chargeurFXML.setLocation(resource);
			chargeurFXML.setController(controller);
			Parent racine = chargeurFXML.load();
			scene = new Scene(racine);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("La scène : \"" + urlFXML 
					+ "\" n'a pas pu être crée.\n");
		}
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
	 * Permet de charger la scène de jeu principal.
	 * @param modele le modèle de la scène à créer
	 */
	public static void changerSceneJeu(Modele modele) {
		try {
			Scene scene = createScene("../vue/Jeu.fxml", 
					new ControleurJeu(modele));
			changerScene(scene);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void changerSceneAide() {
		try {
			Scene scene = createScene("../vue/Aide.fxml", 
					new ControleurAide(fenetre.getScene()));
			scene.getStylesheets().add(
					Main.class.getResource("../vue/all.css").toExternalForm());
			changerScene(scene);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Change la scène affichée dans la fenêtre par celle passée en paramètre
	 * et l'affiche
	 * @param scene la scène à afficher 
	 */
	public static void changerScene(Scene scene) {
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
