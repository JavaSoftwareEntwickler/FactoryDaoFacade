package com.azienda.mydbapp.db.models.factory;

import java.util.List;

public interface Model<T> {

	void stampaFormattato(List<T> lista);

	Model<T> getOggetto(String id);

	Model<T> getOggettoLetto();

	void leggi();

	void setId(String idOggetto);

}
