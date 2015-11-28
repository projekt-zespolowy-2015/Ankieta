package mvc;
 
import mvc.controller.AnkietaController;
import mvc.model.AnkietaBaza;
import mvc.view.AnkietaView;

public class AnkietaDBApplication {

	public static void main(String[] args) {
		
		AnkietaBaza ankietaModel = new AnkietaBaza();
		AnkietaView ankietaView = new AnkietaView();
		new AnkietaController(ankietaModel, ankietaView);
		
		ankietaView.setVisible(true);
	}
}
