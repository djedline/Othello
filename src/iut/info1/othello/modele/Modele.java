package iut.info1.othello.modele;

import iut.info1.othello.modele.joueurs.IA;
import iut.info1.othello.modele.joueurs.Joueur;

/**
 * Représente la logique du jeu. 
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
public class Modele {

    Joueur joueur1;
    Joueur joueur2;
    Joueur joueurActuel;

    //TODO ajouter constructeur en fonction du type de jeu

    Plateau plateau;

    /**
     * Crée un plateau de 8*8 cases avec la configuration
     * par défaut.
     * @param j1 
     * @param j2 
     */
    public Modele(Joueur j1, Joueur j2) {
        plateau = new Plateau();

        this.joueur1 = j1;
        this.joueur2 = j2;

        joueurActuel = joueur1;
    }

    /**
     * @return le tableau de pions
     * Le tableau étant mutable, toute modification risque d'impacter DURABLEMENT
     * le fonctionnement du programme. A utiliser pour lecture seulement.
     */
    public Plateau getPions() {
        return plateau;
    }

    /**
     * Permet de changer le joueur qui doit jouer, au changement
     * de tour. Relance un tour si le joueur suivant est une 
     * IA.
     */
    public void changerJoueur() {
        if(isFinJeu()) {
            // TODO 
        } else {
            joueurActuel = 
                    (joueurActuel == joueur1) ? joueur2 : joueur1;
            if (joueurActuel instanceof IA) {
                ((IA) joueurActuel).jouer(this);
            }
        }
    }

    /** 
     * Permet d'ajouter un pion au tableau de pions représentant
     * le tableau de jeu. La couleur est déduite automatiquement.
     * @param ligne la ligne où ajouter le pion (de 0 à 7)
     * @param colonne la colonne où ajouter le pion (de 0 à 7)
     */
    public void ajouterPion(int ligne, int colonne) {
        try {
            plateau.setTableau(ligne, colonne, joueurActuel.getCouleur());
        } catch (IllegalArgumentException erreur) {
            System.out.println("Impossible de poser ici");
        }
    }

    /**
     * Affiche les éléments du plateau.
     */
    @Override
    public String toString() {
        String resultat = new String();
        for (int lignes = 0 ; lignes < plateau.getNbLignes() ; lignes++) {
            resultat += "-------------------------\n|";
            for (int colonnes = 0 ; colonnes < plateau.getNbColonnes() ; colonnes++) {
                String pion = " ";
                switch (plateau.getCouleur(lignes, colonnes)) {
                case NOIR -> pion =  "⚫";
                case BLANC -> pion = "⚪";
                case RIEN -> pion =  "  ";
                }
                resultat += pion + "|";
            }
            resultat+="\n";
        }
        resultat += "-------------------------";
        return resultat;
    }

    /**
     * Prédicat vérifiant la fin du jeu (toutes les cases sont remplies)
     * @return true si toutes les cases ont un pion, false sinon
     */
    public boolean isFinJeu() {
        boolean toutesCasesPleines;
        toutesCasesPleines = plateau.getCaseVide() == 0;
        return toutesCasesPleines;
    }

    /**
     * @return la joueur dont c'est le tour
     */
    public Joueur getJoueurActuel() {
        return joueurActuel;
    }
}
