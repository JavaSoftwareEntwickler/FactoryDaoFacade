package com.azienda.mydbapp.db;

import com.azienda.mydbapp.db.dao.factory.ClienteCrudFactory;
import com.azienda.mydbapp.db.dao.factory.OrdineCrudFactory;
import com.azienda.mydbapp.db.dao.factory.CrudFactory;
import com.azienda.mydbapp.db.models.factory.ClienteModelFactory;
import com.azienda.mydbapp.db.models.factory.ModelFactory;
import com.azienda.mydbapp.db.models.factory.OrdineModelFactory;

public class Facade {

	private ModelFactory oggettoModel;
	private CrudFactory oggettoCrud;

	public Facade(Object oggetto) {

		if (oggetto.equals("CLIENTE")) {
			oggettoModel = new ClienteModelFactory();
			oggettoCrud = new ClienteCrudFactory();

		} else if (oggetto.equals("ORDINE")) {
			oggettoModel = new OrdineModelFactory();
			oggettoCrud = new OrdineCrudFactory();
		}
	}

	public void aggiungi() {
		oggettoCrud.add(oggettoModel.getOggettoModelLetto());
	}

	public void elimina(String idOggetto) {
		oggettoCrud.delete(oggettoModel.getOgettoById(idOggetto));
	}

	public void visualizza() {
		oggettoModel.visualizza(oggettoCrud.getList());
	}

}
