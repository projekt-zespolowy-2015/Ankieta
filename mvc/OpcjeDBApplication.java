package mvc;
 
import mvc.controller.OpcjeController;
import mvc.model.OpcjeBaza;
import mvc.view.OpcjeView;

public class OpcjeDBApplication {

	public static void main(String[] args) {
		
		OpcjeBaza opcjeModel = new OpcjeBaza();
		OpcjeView opcjeView = new OpcjeView();
		new OpcjeController(opcjeModel, opcjeView);
		
		opcjeView.setVisible(true);
	}
}
