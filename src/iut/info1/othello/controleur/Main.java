package iut.info1.othello.controleur;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage fenetre;
	public static Scene sceneMenu;
	public static Scene sceneMenuModeJeu;
	public static Scene sceneJeu;

	/**
	 * Crée les scènes au sein de la fenêtre de jeu.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		fenetre = stage;
		sceneMenu = createScene("../vue/Menu.fxml");
		sceneMenuModeJeu = createScene("../vue/MenuModeDeJeu.fxml");
		//sceneJeu = createScene("../vue/Jeu.fxml");
		fenetre.setTitle("Othello");
		fenetre.setScene(sceneMenu);
		fenetre.show();
	}

	public Scene createScene(String url) throws IOException {
		FXMLLoader chargeurFXML = new FXMLLoader();
		chargeurFXML.setLocation(getClass().getResource(url));
		Parent racine = chargeurFXML.load();
		Scene scene = new Scene(racine);
		return scene;
	}
	
	public static void changerScene(Scene scene) {
		fenetre.setScene(scene);
		fenetre.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
