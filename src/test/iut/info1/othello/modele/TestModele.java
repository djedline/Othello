package test.iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;
import iut.info1.othello.modele.joueurs.JoueurHumain;

/**
 * Tests unitaires de la classe TestModele.
 * @author BAUDROIT Leïla
 * @author BOYER Djedline
 * @author BRIOT Nael
 */
class TestModele {

	private Modele initialisé;

	@BeforeEach
	void setUp() throws Exception {
		initialisé = new Modele(new JoueurHumain(1, BLANC), new JoueurHumain(2, NOIR));
	}

	@Test
	void testGetPions() {
		final ContenuCase[][] RESULTAT = {
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, NOIR, BLANC, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, BLANC, NOIR, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
				{RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN, RIEN},
		};
		assertArrayEquals(RESULTAT, initialisé.getPions().getPlateau());
	}

	@Test
	void testTostring() {
		final String RESULTAT = """
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------
			|  |  |  |⚫|⚪|  |  |  |
			-------------------------
			|  |  |  |⚪|⚫|  |  |  |
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------
			|  |  |  |  |  |  |  |  |
			-------------------------""";
		assertEquals(RESULTAT, initialisé.toString());
	}
	
	@Test
	void testPeutAjouterPion() {
		// Ne pas ajouter de pion hors du plateau
		assertFalse(initialisé.peutAjouterPion(-1, -1, NOIR));
		assertFalse(initialisé.peutAjouterPion(8, 8, NOIR));
		
		// Ne pas ajouter de pion sur les existants
		assertFalse(initialisé.peutAjouterPion(3, 3, NOIR));
		assertFalse(initialisé.peutAjouterPion(3, 4, NOIR));
		
		// Ne pas ajouter de trou
		assertFalse(initialisé.peutAjouterPion(4, 2, RIEN));
		
		// Ajouter un pion proche des autres
		assertTrue(initialisé.peutAjouterPion(4, 2, NOIR));
		
		// Ajouter un pion trop loin des autres
		//TODO compléter les règles de posage
		//assertFalse(initialisé.peutAjouterPion(0, 0, NOIR));
	}
}
