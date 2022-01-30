package com.azienda.mydbapp.db.models;

import java.util.List;

public class Fornitore {

	private Integer idFornitore;
	private String nomeSocieta; // -----> DB NomeSocietà
	private String contatto;
	private String posizione;
	private String indirizzo;
	private String citta; // ------------> Città
	private String zona;
	private String cap;
	private String paese;
	private String telefono;
	private String fax;
	private String homePage;
	private List<Prodotto> listaProdotti;

	public Fornitore() {

	}

	public Fornitore(Integer idFornitore, String nomeSocieta, String contatto, String posizione, String indirizzo,
			String citta, String zona, String cap, String paese, String telefono, String fax, String homePage) {
		super();
		this.idFornitore = idFornitore;
		this.nomeSocieta = nomeSocieta;
		this.contatto = contatto;
		this.posizione = posizione;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.zona = zona;
		this.cap = cap;
		this.paese = paese;
		this.telefono = telefono;
		this.fax = fax;
		this.homePage = homePage;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public Integer getIdFornitore() {
		return idFornitore;
	}

	public String getNomeSocieta() {
		return nomeSocieta;
	}

	public String getContatto() {
		return contatto;
	}

	public String getPosizione() {
		return posizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public String getZona() {
		return zona;
	}

	public String getCap() {
		return cap;
	}

	public String getPaese() {
		return paese;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getFax() {
		return fax;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setIdFornitore(Integer idFornitore) {
		this.idFornitore = idFornitore;
	}

	public void setNomeSocieta(String nomeSocieta) {
		this.nomeSocieta = nomeSocieta;
	}

	public void setContatto(String contatto) {
		this.contatto = contatto;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}
