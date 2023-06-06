package iut.info1.othello.vue;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
public class AffichageJeu extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader chargeurFXML = new FXMLLoader();
        chargeurFXML.setLocation(getClass().getResource("Jeu.fxml"));
        Parent racine = chargeurFXML.load();
        Scene scene = new Scene(racine);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setTitle("Othello");
        stage.setHeight(488);
        stage.setWidth(615);
        stage.setScene(scene);
        stage.show();

    }


    /** 
     * programme principal
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
        launch(args);
    }
}