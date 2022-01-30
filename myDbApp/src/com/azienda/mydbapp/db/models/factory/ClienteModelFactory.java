package com.azienda.mydbapp.db.models.factory;

import com.azienda.mydbapp.db.models.Cliente;

public class ClienteModelFactory extends ModelFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Model<Cliente> creaOggettoModel() {
		return new Cliente();
	}

}
