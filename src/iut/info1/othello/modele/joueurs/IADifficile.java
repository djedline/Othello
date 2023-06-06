package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

/**
 * Représente une IA difficile.
 */
public class IADifficile extends IA {
        
        /**
         * Crée une IA difficile.
         * @param couleur la couleur de pion qui lui est associée.
         */
        public IADifficile(ContenuCase couleur) {
                super(couleur);
                System.out.println("Je suis une IA difficile");
        }

}