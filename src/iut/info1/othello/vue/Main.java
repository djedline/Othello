package iut.info1.othello.vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader chargeurFXML = new FXMLLoader();
		chargeurFXML.setLocation(getClass().getResource("Jeu.fxml"));
		Parent racine = chargeurFXML.load();
		Scene scene = new Scene(racine);
		
		stage.setTitle("Othello");
		stage.setScene(scene);
		stage.show();
		
		
	}

	public static void main(String[] args) {
		launch();
		
	}

}
