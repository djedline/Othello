/*
 * GestionPlateau.java                                    2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;


/** 
 * Permet de créer un plateau de 8x8
 * @author Djed
 *
 */
public class Plateau {

    private ContenuCase[][] plateau = new ContenuCase[8][8];
    private ContenuCase[][]tableauPosition;

    /** 
     * Créer un plateau d'othello
     * et l'initialise
     */
    public Plateau() {
        for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
                plateau[lignes][colonnes] = RIEN;
            }
        }
        plateau[3][3] = NOIR;
        plateau[4][4] = NOIR;
        plateau[3][4] = BLANC;
        plateau[4][3] = BLANC;
    }

    /** 
     * @return le plateau
     */
    public ContenuCase[][] getPlateau() {
        return plateau;//STUB
    }

    /** 
     * Permet de vérifier que la pose souhaité par l'utilisateur
     * fait bien partie des pose possible
     * @param ligne la ligne du plateau où le pion doit être déplacé
     * @param colonne la colonne du tableau où le pion doit être déplacé
     * @param couleur la couleur du pion qui doit être posé
     * @return true si le pion peut être posé
     *         false sinon
     */
    public boolean comparePosage(int ligne, int colonne, ContenuCase couleur) {
        positionPossible(couleur);
        return tableauPosition[ligne][colonne] == couleur;

    }

    /** 
     * Vérifie toutes les positions possible pour une couleur de pion définie
     * et stocke les possibilités dans un tableau
     * @param couleurPion la couleur du pion qui doit être placé sur le plateau
     */
    public void positionPossible(ContenuCase couleurPion) {
        tableauPosition = new ContenuCase[8][8];
        for (int lignes = 0 ; lignes < tableauPosition.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < tableauPosition[lignes].length ; colonnes++) {
                if (plateau[lignes][colonnes] == RIEN) {
                    if (autorisePosagePerpendiculaire(lignes, colonnes, couleurPion)) {
                        tableauPosition[lignes][colonnes] = couleurPion;
                    } 
                } else {
                    tableauPosition[lignes][colonnes] = RIEN;
                }
            }
        } 
    }

    /** 
     * Permet de vérifer les conditions de pose pour un pion d'une couleur donnée
     * Vérifie les conditions de pose vertical et horizontal
     * @param ligne la ligne du plateau où le pion doit être posé
     * @param colonne la colonne du tableau où le pion doit être posé
     * @param couleur la couleur du pion qui doit être posé 
     * @return true si l'utilisateur peut poser
     *         false sinon
     */
    public boolean autorisePosagePerpendiculaire(int ligne, int colonne, ContenuCase couleur) {
        boolean posagePossible = false;
        ContenuCase couleurAdversaire;
        if (couleur == NOIR) {
            couleurAdversaire = BLANC;
        } else {
            couleurAdversaire = NOIR;
        }

        if(ligne == 7 && plateau[ligne-1][colonne] == couleurAdversaire) {
            posagePossible = true;
        } else if (colonne == 7 && plateau[ligne][colonne-1] == couleurAdversaire){
            posagePossible = true;
        } else if (ligne == 0 && plateau[ligne+1][colonne] == couleurAdversaire) {
            posagePossible = true; 
        } else if (colonne == 0 && plateau[ligne][colonne+1] == couleurAdversaire) {
            posagePossible = true; 
        } else if(ligne != 7 && colonne != 7){
            if ( ligne != 0 && plateau[ligne-1][colonne] == couleurAdversaire) {
                for(int haut = ligne; haut > 0 && plateau[haut][colonne] != couleur; haut--) {
                    posagePossible = true;
                }
            }
            if (plateau[ligne+1][colonne] == couleurAdversaire && ligne != 7) {
                for(int bas = ligne; bas < 7 && plateau[bas][colonne] != couleur; bas++) {
                    posagePossible = true;
                }
            }
            if (plateau[ligne][colonne+1] == couleurAdversaire && colonne != 7) {
                for(int droite = colonne; droite < 7 && plateau[ligne][droite] != couleur; droite++) {
                    posagePossible = true;
                }
            }
            if ( colonne != 0 && plateau[ligne][colonne-1] == couleurAdversaire) {
                for(int gauche = colonne; gauche > 0 && plateau[ligne][gauche] != couleur; gauche--) {
                    posagePossible = true;
                }
            }
        }
        return posagePossible;

    }

    /** 
     * Permet de modifier le plateau
     * Si l'utilisateur pose un pion qui peut être posé
     * alors le pion apparaîtra sur le plateau
     * @param ligne la ligne du plateau où le pion doit être posé
     * @param colonne la colonne du tableau où le pion doit être posé
     * @param couleur la couleur du pion qui doit être posé 
     * @return un message indiquant que le pion a bien était posé
     * @throws IllegalArgumentException() si l'utilisateur ne peut pas poser
     */
    public String setTableau(int ligne, int colonne, ContenuCase couleur) {
        if(comparePosage(ligne, colonne, couleur)) {
            plateau[ligne][colonne] = couleur;
        } else {
            throw new IllegalArgumentException();
        }
        return "Posé";
    }

    /** 
     * Permet de connaître le nombre de pions noir présent sur plateau
     * @return le nombre de pions de couleur noir présent sur le plateau
     */
    public int getNoir() {
        int nbNoir = 0;
        for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
                if (plateau[lignes][colonnes] == NOIR) {
                    nbNoir++;
                }
            }
        }
        return nbNoir;

    }

    /** 
     * Permet de connaître le nombre de pions blanc présent sur plateau
     * @return le nombre de pions de couleur noir présent sur le plateau
     */
    public int getBlanc() {
        int nbBlanc = 0;
        for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
                if (plateau[lignes][colonnes] == BLANC) {
                    nbBlanc++;
                }
            }
        }
        return nbBlanc;

    }

    /** 
     * Vérifie si une case du plateau est vide
     * @param ligne la ligne du plateau où la case doit être vérifié
     * @param colonne la colonne du tableau où la case doit être vérifié
     * @return true si la cas est vide
     *         false si la case contient un pion
     */
    public boolean isVide(int ligne, int colonne) {
        return plateau[ligne][colonne] == RIEN;
    }

    /** 
     * Permet de connaître la couleur du pion posé sur la case
     * @param ligne la ligne du plateau où la case doit être vérifié
     * @param colonne la colonne du tableau où la case doit être vérifié
     * @return la couleur du pion posé sur la case;
     */
    public ContenuCase getCouleur(int ligne, int colonne) {
        return plateau[ligne][colonne];

    }

    /** 
     * Permet de connaître le nombre de ligne dans le plateau
     * @return le nombre de ligne du plateau
     */
    public int getNbLignes() {
        return plateau.length;
    }

    /** 
     * Permet de connaître le nombre de ligne dans le plateau
     * @return le nombre de ligne du plateau
     */
    public int getNbColonnes() {
        return plateau[0].length;
    }

    /** 
     * Permet de connaître le nombre de case vide sur plateau
     * @return le nombre de case vide présent sur le plateau
     */
    public int getCaseVide() {
        int nbVide = 0;
        for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
                if (plateau[lignes][colonnes] == RIEN) {
                    nbVide++;
                }
            }
        }
        return nbVide;

    }

}
