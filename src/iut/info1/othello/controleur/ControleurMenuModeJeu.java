package iut.info1.othello.controleur;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;

import iut.info1.othello.modele.Modele;
import iut.info1.othello.modele.joueurs.JoueurHumain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Le contrôleur associé au menu du choix du mode de jeu.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class ControleurMenuModeJeu {
        
        /**
         * Lance une partie entre joueurs humains et affiche l'écran de jeu.
         */
        @FXML
        private void creerPartiePVP() {
                Modele modele = new Modele(new JoueurHumain(1, BLANC), 
                                new JoueurHumain(2, NOIR));
                Main.changerSceneJeu(modele);
        }
        
        /**
         * Lance une partie avec une IA facile et affiche l'écran de jeu.
         */
        @FXML
        private void creerPartieIAFacile() {
        	new Alert(AlertType.WARNING, "Fonction non implémentée.", ButtonType.OK).show();
        }
        
        /**
         * Lance une partie avec une IA difficile et affiche l'écran de jeu.
         */
        @FXML
        private void creerPartieIADifficile() {
        	new Alert(AlertType.WARNING, "Fonction non implémentée.", ButtonType.OK).show();
        }

}