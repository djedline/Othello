package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

/**
 * Le contrôleur associé au menu principal
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class ControleurMenu {
        
        /**
         * Affiche l'aide du jeu.
         * @param event l'évènement déclenché
         */
        @FXML
        private void aide(ActionEvent event) {
                Main.changerSceneAide();
        }

        /**
         * Permet de continuer une partie sauvegardée.
         * @param event l'évènement déclenché
         */
        @FXML
        private void continuer(ActionEvent event) {
        	new Alert(AlertType.WARNING, "Fonction non implémentée.", ButtonType.OK).show();
        }

        /**
         * Permet de commencer une nouvelle partie
         * @param event l'évènement déclenché
         */
        @FXML
        private void nouvellePartie(ActionEvent event) {
                Main.changerScene(Main.SCENE_MENU_MODE_JEU);
        }

}
