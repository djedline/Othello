package iut.info1.othello.modele.joueurs;

import iut.info1.othello.modele.ContenuCase;

/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
public class JoueurHumain extends Joueur {

        /** TODO comment initial state
         * @param couleur
         */
        public JoueurHumain(ContenuCase couleur) {
                super(couleur);
                System.out.println("Je suis un humain");
        }
}