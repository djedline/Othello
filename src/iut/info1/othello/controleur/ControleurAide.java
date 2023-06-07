package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Affiche l'aide et la met à jour.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class ControleurAide {
        
        private Scene fenetreAide;
        
        /** 
         * Crée le contrôleur en gardant en mémoire la scène
         * précédente.
         * @param fenetrePrecedente la scène précédente
         */
        public ControleurAide(Scene fenetrePrecedente) {
                this.fenetreAide = fenetrePrecedente ;
        }
        /**
         * Revient au Menu pricipal.
         * @param event l'évènement déclenché
         */
        @FXML
        void retourMenu(ActionEvent event) {
                Main.changerScene(fenetreAide);
        }
}