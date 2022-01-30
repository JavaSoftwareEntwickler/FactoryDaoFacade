package com.azienda.mydbapp.db.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.azienda.mydbapp.db.models.factory.Model;

public class Ordine implements Model<Ordine> {

	private int idOrdine;
	private String idCliente;
	private String indirizzoDestinatario;
	private String cittaDestinatario; // nel DB----> citt‡Destinatario
	private String destinatario;
	private List<DettagliOrdine> listaDettagliOrdini;

	public Ordine() {
		this.listaDettagliOrdini = new ArrayList<>();
	}

	public Ordine(int idOrdine, String idCliente) {
		super();
		this.idOrdine = idOrdine;
		this.idCliente = idCliente;
		this.listaDettagliOrdini = new ArrayList<>();
	}

	public Ordine(int idOrdine, String idCliente, String indirizzoDestinatario, String cittaDestinatario,
			String destinatario) {
		this.idOrdine = idOrdine;
		this.idCliente = idCliente;
		this.indirizzoDestinatario = indirizzoDestinatario;
		this.cittaDestinatario = cittaDestinatario;
		this.destinatario = destinatario;
		this.listaDettagliOrdini = new ArrayList<>();
	}

	public List<DettagliOrdine> getDettagliOrdini() {
		return listaDettagliOrdini;
	}

	public void setDettagliOrdini(List<DettagliOrdine> dettagliOrdini) {
		this.listaDettagliOrdini = dettagliOrdini;
	}

	public boolean add(DettagliOrdine detOrd) {
		return (Integer.parseInt(detOrd.getIdOrdine()) == idOrdine) ? listaDettagliOrdini.add(detOrd) : false;
	}

	public void rimuoviDettagliOrdine(DettagliOrdine detOrd) {
		listaDettagliOrdini.remove(detOrd);
	}

	public DettagliOrdine getDettagliOrdineById(int idOrdine) {
		var detOrd = new DettagliOrdine();
		for (DettagliOrdine dettOrdine : listaDettagliOrdini)
			detOrd = (Integer.parseInt(dettOrdine.getIdOrdine()) == (idOrdine)) ? dettOrdine : null;
		return detOrd;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public String getIndirizzoDestinatario() {
		return indirizzoDestinatario;
	}

	public String getCittaDestinatario() {
		return cittaDestinatario;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public void setIndirizzoDestinatario(String indirizzoDestinatario) {
		this.indirizzoDestinatario = indirizzoDestinatario;
	}

	public void setCittaDestinatario(String cittaDestinatario) {
		this.cittaDestinatario = cittaDestinatario;
	}

	@Override
	public Ordine getOggettoLetto() {
		this.leggi();
		return this;
	}

	@Override
	public Ordine getOggetto(String idOggetto) {
		this.setId(idOggetto);
		return this;
	}

	@Override
	public void setId(String idOggetto) {
		this.idOrdine = Integer.parseInt(idOggetto);
	}

	@Override
	public void stampaFormattato(List<Ordine> lista) {
		for (int i = 0; i < lista.size(); i++) {
			var o = lista.get(i);
			System.out.printf(
					"%n***************%nId Ordine ----> %1$s  Id Cliente ----> %2$s  Citta'Destinatario ----> %3$s %n***************%nLista Ordini:%n",
					o.getIdOrdine(), o.getIdCliente(), o.getCittaDestinatario(), o.getIdCliente());
			for (DettagliOrdine ord : o.getDettagliOrdini()) {
				System.out.printf("Id Prodotto --> %1$s   Quantita --> %2$s   Prezzo Unitario: --> %3$s %n",
						ord.getIdProdotto(), ord.getQuantita(), ord.getPrezzoUnitario());
			}
		}

	}

	@Override
	public void leggi() {
		this.setIdOrdine(Integer.parseInt(JOptionPane.showInputDialog("Inserisci idOrdine:")));
		this.setIdCliente(JOptionPane.showInputDialog("Inserisci IdCliente:"));
		this.setIndirizzoDestinatario(JOptionPane.showInputDialog("Inserisci indirizzoDestinatario :"));
		this.setCittaDestinatario(JOptionPane.showInputDialog("Inserisci cittaDestinatario :"));
		this.setDestinatario(JOptionPane.showInputDialog("Inserisci destinatario:"));
	}
}
