package iut.info1.othello.controleur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controleur extends Application {
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader chargeurFXML = new FXMLLoader();
		chargeurFXML.setLocation(getClass().getResource("test/iut/info1/othello/vue/Jeu.fxml"));
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
