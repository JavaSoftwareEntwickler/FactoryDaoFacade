package com.azienda.mydbapp.db.dao;

import java.util.List;
//si possono implementare metodi di default

//sfruttando il princio dell' inferenza
//uso il Templeate Generic

public interface Crud<T> {

	public List<T> findAll();

	public boolean add(T t);

	public boolean delete(T t);

	public boolean upDate(T t);

	public Crud<T> cercaById(T t);

}
