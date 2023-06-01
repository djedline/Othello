package iut.info1.othello.vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	/**
	 * Lance l'écran de jeu
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader chargeurFXML = new FXMLLoader();
		chargeurFXML.setLocation(getClass().getResource("MenuModeDeJeu.fxml"));
		Parent racine = chargeurFXML.load();
		Scene scene = new Scene(racine);
		
		stage.setTitle("Othello");
		stage.setScene(scene);
		stage.show();
	}
}
