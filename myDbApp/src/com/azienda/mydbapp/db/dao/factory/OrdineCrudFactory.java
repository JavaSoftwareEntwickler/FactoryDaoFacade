package com.azienda.mydbapp.db.dao.factory;

import com.azienda.mydbapp.db.dao.Crud;
import com.azienda.mydbapp.db.dao.OrdineService;
import com.azienda.mydbapp.db.models.Ordine;

public class OrdineCrudFactory extends CrudFactory {

	@SuppressWarnings("unchecked")
	@Override
	public Crud<Ordine> createServiceCrud() {
		return new OrdineService();
	}

}
