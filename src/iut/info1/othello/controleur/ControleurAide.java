package iut.info1.othello.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
public class ControleurAide {
        
        private Scene fenetreAide;
        
        /** TODO comment initial state
         * @param fenetrePrecedente
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