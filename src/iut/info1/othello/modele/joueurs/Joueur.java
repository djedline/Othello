package iut.info1.othello.modele.joueurs;

import static iut.info1.othello.modele.ContenuCase.RIEN;

import iut.info1.othello.modele.ContenuCase;

/**
 * Représente tout joueur, qu'il s'agisse d'un joueur humain ou d'une IA.
 */
public class Joueur {

        /**
         * Nom du joueur, défini par avance.
         */
        private String nom;
        
        /**
         * La couleur de pion associée au joueur. Ne peut être RIEN.
         */
        private iut.info1.othello.modele.ContenuCase couleur;

        /**
         * Crée un joueur assigné à une couleur de pion.
         * @param i l'entier associé au joueur
         * @param couleur la couleur de ses pions
         * @throws IllegalArgumentException si la couleur passée en paramètre
         * est RIEN.
         */
        public Joueur(int i, iut.info1.othello.modele.ContenuCase couleur) {
                if (couleur == RIEN) {
                        throw new IllegalArgumentException("Un joueur ne peut "
                                        + "poser des cases vides.");
                }
                this.couleur = couleur;
        }

        /**
         * @return la couleur du joueur
         */
        public ContenuCase getCouleur() {
                return couleur;
        }
        
        /**
         * @return le nom par défaut du joueur.
         */
        public String getNom() {
                return nom;
        }

}