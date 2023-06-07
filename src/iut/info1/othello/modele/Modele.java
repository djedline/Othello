package iut.info1.othello.modele;

import iut.info1.othello.modele.joueurs.Joueur;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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
        	alerteGagnant();
        } else {
            joueurActuel = 
                    (joueurActuel == joueur1) ? joueur2 : joueur1;
        }
    }

    /**
     * Affiche le gagnant.
     */
    private void alerteGagnant() {
    	Joueur joueurNoir;
    	Joueur joueurBlanc;
    	if (joueur1.getCouleur() == ContenuCase.NOIR) {
    		joueurNoir = joueur1;
    		joueurBlanc = joueur2;
    	} else {
    		joueurNoir = joueur2;
    		joueurBlanc = joueur1;
    	}
    	Joueur gagnant = plateau.getBlanc() > plateau.getNoir() ? joueurBlanc 
    			: joueurNoir;
        new Alert(AlertType.INFORMATION, 
        		gagnant.getNom() + " a gagné.", 
        		ButtonType.OK);
	}

	/** 
     * Permet d'ajouter un pion au tableau de pions représentant
     * le tableau de jeu. La couleur est déduite automatiquement.
     * @param ligne la ligne où ajouter le pion (de 0 à 7)
     * @param colonne la colonne où ajouter le pion (de 0 à 7)
     * @throws IllegalArgumentException s'il est impossible de poser
     * un pion à cet endroit
     */
    public void ajouterPion(int ligne, int colonne) throws IllegalArgumentException{
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

    /**
     * Prédicat vérifiant la validité d'un ajout.
     * @param row la ligne de la case à vérifier
     * @param column la colonne de la case à vérifier
     * @param couleur la couleur du pion à ajouter
     * @return
     */
	public boolean peutAjouterPion(int ligne, int colonne, ContenuCase couleur) {
		return ligne >= 0 && ligne <= 7
				&& colonne >= 0 && colonne <= 7
				&& couleur != ContenuCase.RIEN
				&& plateau.getCouleur(ligne, colonne) == ContenuCase.RIEN;
	}
}
