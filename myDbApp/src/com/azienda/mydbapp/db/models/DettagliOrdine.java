package com.azienda.mydbapp.db.models;

import java.util.ArrayList;
import java.util.List;

public class DettagliOrdine {

	private String idOrdine;
	private String idProdotto;
	private Double prezzoUnitario;
	private Integer quantita; // ----------> nel DB Quantità
	private Float sconto;
	private List<Prodotto> listaProdotti;

	public DettagliOrdine() {
		this.listaProdotti = new ArrayList<>();
	}

	public DettagliOrdine(String idOrdine, String idProdotto, Double prezzoUnitario, Integer quantita, Float sconto) {

		this.idOrdine = idOrdine;
		this.idProdotto = idProdotto;
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.sconto = sconto;
		this.listaProdotti = new ArrayList<>();
	}

	public String getIdOrdine() {
		return idOrdine;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public Double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public Float getSconto() {
		return sconto;
	}

	public void setIdOrdine(String idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public void setPrezzoUnitario(Double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public void setSconto(Float sconto) {
		this.sconto = sconto;
	}

}
