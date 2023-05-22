package test.iut.info1.othello.modele;

import static iut.info1.othello.modele.ContenuCase.BLANC;
import static iut.info1.othello.modele.ContenuCase.NOIR;
import static iut.info1.othello.modele.ContenuCase.RIEN;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.othello.modele.ContenuCase;
import iut.info1.othello.modele.Modele;

class TestModele {

	Modele initialisé;

	@BeforeEach
	void setUp() throws Exception {
		initialisé = new Modele();
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
		assertArrayEquals(RESULTAT, initialisé.getPions());
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
	void testAjouterPion() {
		assertEquals(false, initialisé.ajouterPion(0, 0));
	}
}
