package com.azienda.mydbapp.db.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.azienda.mydbapp.db.models.factory.Model;

public class Cliente implements Model<Cliente> {

	private String id;
	private String nomeSocietà;
	private String contatto;
	private String posizione;
	private String indirizzo;
	private String citta; // sub db -----------> città
	private String zona;
	private String cap;
	private String paese;
	private String telefono;
	private String fax;

	private List<Ordine> listaOrdini;

	public Cliente() {
		this.listaOrdini = new ArrayList<>();
	}

	public Cliente(String idCliente, String nomeSocietà, String contatto, String telefono, String citta) {
		super();
		this.id = idCliente;
		this.nomeSocietà = nomeSocietà;
		this.contatto = contatto;
		this.telefono = telefono;
		this.citta = citta;
		this.listaOrdini = new ArrayList<>();
	}

	public Cliente(String idCliente, String nomeSocietà, String contatto, String posizione, String indirizzo,
			String citta, String zona, String cap, String paese, String telefono, String fax) {
		this.id = idCliente;
		this.nomeSocietà = nomeSocietà;
		this.contatto = contatto;
		this.posizione = posizione;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.zona = zona;
		this.cap = cap;
		this.paese = paese;
		this.telefono = telefono;
		this.fax = fax;
	}

	public void setListaOrdini(List<Ordine> listaOrdini) {
		this.listaOrdini = listaOrdini;
	}

	public List<Ordine> getListaOrdini() {
		return listaOrdini;
	}

	public boolean addOrdine(Ordine or) {
		return (or.getIdCliente().equalsIgnoreCase(id)) ? listaOrdini.add(or) : false;
	}

	public void rimuoviOrdine(Ordine or) {
		listaOrdini.remove(or);
	}

	public Ordine getOrdineById(String idCliente) {
		var ord = new Ordine();
		for (Ordine ordine : listaOrdini)
			ord = (ordine.getIdCliente().equalsIgnoreCase(idCliente)) ? ordine : null;
		return ord;
	}

	public String getIdCliente() {
		return id;
	}

	public void setIdCliente(String idCliente) {
		this.id = idCliente;
	}

	public String getNomeSocietà() {
		return nomeSocietà;
	}

	public void setNomeSocietà(String nomeSocietà) {
		this.nomeSocietà = nomeSocietà;
	}

	public String getContatto() {
		return contatto;
	}

	public void setContatto(String contatto) {
		this.contatto = contatto;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public void leggi() {

		setIdCliente(JOptionPane.showInputDialog("Inserisci idcliente:"));
		setNomeSocietà(JOptionPane.showInputDialog("Inserisci nome società:"));
		setContatto(JOptionPane.showInputDialog("Inserisci nome contatto :"));
		setPosizione(JOptionPane.showInputDialog("Inserisci posizione Lavorativa del contatto :"));
		setIndirizzo(JOptionPane.showInputDialog("Inserisci indirizzo:"));
		setCitta(JOptionPane.showInputDialog("Inserisci Città:"));
		setZona(JOptionPane.showInputDialog("Inserisci Zona:"));
		setCap(JOptionPane.showInputDialog("Inserisci il Cap:"));
		setPaese(JOptionPane.showInputDialog("Inserisci il Paese:"));
		setTelefono(JOptionPane.showInputDialog("Inserisci il telefono:"));
		setFax(JOptionPane.showInputDialog("Inserisci il fax:"));

	}

	@Override
	public Cliente getOggettoLetto() {
		this.leggi();
		return this;

	}

	@Override
	public void stampaFormattato(List<Cliente> lista) {
		for (Cliente cl : lista) {
			System.out.printf(
					"%n%n***************%nId Cliente ----> %1$s  Nome Societa' ----> %2$s  Citta' ----> %3$s %n***************%nLista Ordini:%n",
					cl.getIdCliente(), cl.getNomeSocietà(), cl.getCitta());
			for (Ordine ord : cl.getListaOrdini()) {
				System.out.printf("Id Ordine: %1$s %n", ord.getIdOrdine());
			}
		}
	}

	@Override
	public Cliente getOggetto(String idOggetto) {
		this.setId(idOggetto);
		return this;
	}

	@Override
	public void setId(String idOggetto) {
		this.id = idOggetto;
	}

}
