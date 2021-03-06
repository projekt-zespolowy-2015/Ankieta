package mvc.controller;

import java.util.List;

import mvc.model.Ankieta;
import mvc.model.AnkietaBaza;
import mvc.view.AnkietaView;

public class AnkietaController {

	private AnkietaBaza ankietaModel;
	private AnkietaView ankietaView;
	
	public AnkietaController(AnkietaBaza model, AnkietaView view) {
		this.ankietaModel = model;
		this.ankietaView = view;
		
		view.setController(this);
		
		refreshAnkiety();
	}
	
	public void insertAnkieta(Ankieta ankieta) {
		ankietaModel.insertAnkieta(ankieta);
		refreshAnkiety();
	}
	
	public void updateAnkieta(Ankieta ankieta) {
		ankietaModel.updateAnkieta(ankieta);
		refreshAnkiety();
	}
	
	public void deleteAnkieta(Integer ankietaId) {
		ankietaModel.deleteAnkieta(ankietaId);
		refreshAnkiety();
	}
	
	private void refreshAnkiety() {
		List<Ankieta> ankiety = ankietaModel.getAnkiety();
		ankietaView.refreshAnkiety(ankiety);
	}
}

