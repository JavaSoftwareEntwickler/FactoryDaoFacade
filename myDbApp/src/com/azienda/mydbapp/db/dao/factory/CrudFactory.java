package com.azienda.mydbapp.db.dao.factory;

import java.util.List;

import com.azienda.mydbapp.db.dao.Crud;

public abstract class CrudFactory {

	/**
	 * Le sottoclassi sovrascriveranno questo metodo per creare specifici Oggetti
	 * Service presenti nell pkj db.dao
	 * 
	 * @param <T>
	 * @return Oggetto ClienteService oppure OrdineService
	 */
	public abstract <T> Crud<T> createServiceCrud();

	public <T> List<T> getList() {
		Crud<T> serviceCrud = createServiceCrud();
		return serviceCrud.findAll();
	}

	public <T> boolean add(T t) {
		Crud<T> serviceCrud = createServiceCrud();
		return (serviceCrud.add(t)) ? true : false;
	}

	public <T> boolean delete(T t) {
		Crud<T> serviceCrud = createServiceCrud();
		return (serviceCrud.delete(t)) ? true : false;
	}

	public <T> Crud<T> cercaByID(T t) {
		Crud<T> serviceCrud = createServiceCrud();
		return serviceCrud.cercaById(t);
	}

}
