package com.azienda.mydbapp.db.models.factory;

import java.util.List;

public abstract class ModelFactory {

	/**
	 * Le sottoclassi sovrascriveranno questo metodo per creare specifici Oggetti
	 * Models.
	 * 
	 * @param <T>
	 * @return Oggetto delle classi presenti nel pkj db.models (Cliente oppure
	 *         Ordine ecc ecc)
	 */
	public abstract <T> Model<T> creaOggettoModel();

	public <T> void visualizza(List<T> t) {
		Model<T> model = creaOggettoModel();
		model.stampaFormattato(t);
	}

	public <T> Model<T> getOggettoModelLetto() {
		Model<T> model = creaOggettoModel();
		model.leggi();
		return model.getOggettoLetto();
	}

	public <T> Model<T> getOgettoById(String idOggetto) {
		Model<T> model = creaOggettoModel();
		return model.getOggetto(idOggetto);
	}

}
