package com.azienda.mydbapp.db.models.factory;

import com.azienda.mydbapp.db.models.Ordine;

public class OrdineModelFactory extends ModelFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Model<Ordine> creaOggettoModel() {
		return new Ordine();
	}

}
