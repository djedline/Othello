package iut.info1.othello.controleur;

import iut.info1.othello.modele.Modele;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/** TODO comment class responsibility (SRP)
 * @author Djed
 *
 */
public class ControleurJeu {

	/** créer un gridpane */
	@FXML
	private GridPane grille;

	@FXML
	public void initialize() {
		System.out.println("TEST");
		for (Node child : grille.getChildren()) {
			child.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					Integer row = grille.getRowIndex(child);
					Integer column = grille.getColumnIndex(child);
					row = (row == null) ? 0 : row;
					column = (column == null) ? 0 : column;
					System.out.println("Ligne : " + row + ", colonne : " + column);
					//TODO démerde toi pour appeler le modèle
				}
			});
		}
	}
	
	void click(MouseEvent event) {
		Node node;
		try {
			System.out.println(event.getTarget());
			node = (Node) event.getTarget();
			System.out.println(grille);
			System.out.println(grille.getRowIndex(node));
			System.out.println(grille.getColumnIndex(node));
		} catch (Exception e) {
			System.out.println("Le clic n'a pas pu être pris en compte.");
		}
	}

}
