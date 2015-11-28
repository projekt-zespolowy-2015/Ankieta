package mvc;
 
import mvc.controller.PytanieController;
import mvc.model.PytanieBaza;
import mvc.view.PytanieView;

public class PytanieDBApplication {

	public static void main(String[] args) {
		
		PytanieBaza pytanieModel = new PytanieBaza();
		PytanieView pytanieView = new PytanieView();
		new PytanieController(pytanieModel, pytanieView);
		
		pytanieView.setVisible(true);
	}
}
