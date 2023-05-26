package iut.info1.othello.vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{ 

	@Override
	public void start(Stage primaryStage) throws Exception{
		FXMLLoader chargeurFXML = new FXMLLoader();
		/*
		* on indique au chargeur quelle est la vue fxml qu'il devra charger :
		* ici VueExemple1.fxml
		*/
		chargeurFXML.setLocation(getClass().getResource("Jeu.fxml"));
		/*
		* création d'un objet de type parent qui est initialisé avec le résultat du
		* chargement de la vue FXML. Ou dit autrement le code écrit en FXML est transformé
		* en un objet Java
		*/
		Parent racine = chargeurFXML.load();
		Scene scene = new Scene(racine);
		// on définit le titre, la hauteur et la largeur de la fenêtre
		primaryStage.setTitle("Compter caractères");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
