package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;

/**
 * IA jouant en Othello aléatoirement.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class IAFacile extends IA {
        
        /**
         * Crée une IA facile.
         * @param i l'entier associé au joueur
         * @param couleur la couleur de ses pions
         */
        public IAFacile(int i, ContenuCase couleur) {
                super(i, couleur);
                System.out.println("Je suis une IA facile");
        }
        
        @Override
        public void jouer(Modele modele) {
                int ligne;
                int colonne;
                boolean peutAjouterPion = false;
                int nbEchecs = 0;
                do {
                        ligne   = (int) Math.random() * 8;
                        colonne = (int) Math.random() * 8;
                        peutAjouterPion = modele.getPions().autorisePosagePerpendiculaire(ligne, colonne, getCouleur());
                } while (!peutAjouterPion && nbEchecs < 200);
                if (peutAjouterPion) {
                        modele.ajouterPion(ligne, colonne);
                }
                modele.changerJoueur();
        }
}