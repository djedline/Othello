/*
 * PlateauTest.java                                    2 juin 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft"
 */
package iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
class PlateauTest {
    
    private ContenuCase[][] plateau = new ContenuCase[8][8];
    private Plateau plateauTest;
    private Plateau plateauTestInitial;

    /** TODO comment method role
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        for (int lignes = 0 ; lignes < plateau.length ; lignes++) {
            for (int colonnes = 0 ; colonnes < plateau[lignes].length ; colonnes++) {
                plateau[lignes][colonnes] = RIEN;
            }
        }
        plateau[3][3] = NOIR;
        plateau[4][4] = NOIR;
        plateau[3][4] = BLANC;
        plateau[4][3] = BLANC;
        plateauTestInitial = new Plateau();
    }

    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#initialisationPlateau()}.
     */
    @Test
    void testPlateau() {
        assertArrayEquals(plateau, plateauTestInitial.getPlateau());
    }

    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#balayagePlateau()}.
     */
    @Test
    void testBalayagePlateau() {
        assertArrayEquals(plateau, plateauTestInitial.getPlateau());
    }

    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#autorisePosage(int, int, iut.info1.othello.modele.ContenuCase)}.
     */
    @Test
    void testAutorisePosage() {
        // test pions noirs
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(3,3,NOIR));
        assertTrue(plateauTestInitial.autorisePosagePerpendiculaire(3,5,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(3,6,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(3,7,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(3,2,NOIR));
        assertTrue(plateauTestInitial.autorisePosagePerpendiculaire(4,2,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(4,5,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(4,1,NOIR));
        assertTrue(plateauTestInitial.autorisePosagePerpendiculaire(2,4,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(5,4,NOIR));
        assertTrue(plateauTestInitial.autorisePosagePerpendiculaire(5,3,NOIR));
        assertFalse(plateauTestInitial.autorisePosagePerpendiculaire(2,3,NOIR));
        
        // test pions
    }
    
    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#modificationTableau(int, int, iut.info1.othello.modele.getCaseVide)}.
     */
    @Test
    void testcomparePosage() {
        assertFalse(plateauTestInitial.comparePosage(3,3,NOIR));
    }
    
    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#modificationTableau(int, int, iut.info1.othello.modele.ContenuCase)}.
     */
    @Test
    void testSetTableau() {
        assertThrows(IllegalArgumentException.class,()-> plateauTestInitial.setTableau(3,3,NOIR));
        //assertEquals("posé", plateauTestInitial.setTableau(5,3,NOIR));
        //System.out.println(plateauTest.comparePosage(3,3,NOIR));
    }
    
    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#modificationTableau(int, int, iut.info1.othello.modele.getNoir)}.
     */
    @Test
    void testGetNoir() {
        assertEquals(2,plateauTestInitial.getNoir());
    }
    
    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#modificationTableau(int, int, iut.info1.othello.modele.getBlanc)}.
     */
    @Test
    void testGetBlanc() {
        assertEquals(2,plateauTestInitial.getBlanc());
    }
    
    /**
     * Test method for {@link iut.info1.othello.modele.Plateau#modificationTableau(int, int, iut.info1.othello.modele.getCaseVide)}.
     */
    @Test
    void testGetCaseVide() {
        assertEquals(60,plateauTestInitial.getCaseVide());
    }
    
}
