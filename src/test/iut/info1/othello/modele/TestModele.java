package test.iut.info1.othello.modele;

import static iut.info1.othello.modele.CouleurPion.BLANC;
import static iut.info1.othello.modele.CouleurPion.NOIR;
import static iut.info1.othello.modele.CouleurPion.RIEN;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iut.info1.othello.modele.CouleurPion;
import iut.info1.othello.modele.Modele;

class TestModele {
	
	Modele initialisé;

	@BeforeEach
	void setUp() throws Exception {
		initialisé = new Modele();
	}

	@Test
	void testGetPions() {
		final CouleurPion[][] RESULTAT = {
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

}
