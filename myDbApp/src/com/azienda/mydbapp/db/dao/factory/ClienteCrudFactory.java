package com.azienda.mydbapp.db.dao.factory;

import com.azienda.mydbapp.db.dao.ClienteService;
import com.azienda.mydbapp.db.dao.Crud;
import com.azienda.mydbapp.db.models.Cliente;

public class ClienteCrudFactory extends CrudFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Crud<Cliente> createServiceCrud() {
		return new ClienteService();
	}

}
