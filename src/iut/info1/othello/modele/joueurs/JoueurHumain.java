package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
public class JoueurHumain extends Joueur {

        /**
         * Représente un joueur humain.
         * @param i l'entier associé au joueur
         * @param couleur la couleur de ses pions
         */
        public JoueurHumain(int i, ContenuCase couleur) {
                super(i, couleur);
        }
}