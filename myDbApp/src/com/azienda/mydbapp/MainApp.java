package com.azienda.mydbapp;

import javax.swing.JOptionPane;

import com.azienda.mydbapp.db.Facade;

public class MainApp {

	private static Facade dataBaseFacade;

	public static void menuPrincipale() {
		int scelta = -1;
		do {
			scelta = Integer.parseInt(
					JOptionPane.showInputDialog("Con quale tabella vuoi lavorare?\n1. Clienti \n2. Ordini:\n0. Esci"));
			switch (scelta) {
			case 1:

				dataBaseFacade = new Facade("CLIENTE");
				menuOperazioni();

				break;
			case 2:

				dataBaseFacade = new Facade("ORDINE");
				menuOperazioni();

				break;
			case 0:

				JOptionPane.showMessageDialog(null, "Grazie ed arrivederci.");

				break;
			default:

				JOptionPane.showMessageDialog(null, "Opzione non valida.");

				break;
			}
		} while (scelta != 0);
	}

	private static void menuOperazioni() {

		int scelta = -1;
		do {
			scelta = Integer.parseInt(JOptionPane
					.showInputDialog("Operazioni disponibili: \n1. Visualizza\n2. Aggiungi:\n3. Elimina:\n0. Esci"));
			switch (scelta) {
			case 1:

				dataBaseFacade.visualizza();

				break;
			case 2:

				dataBaseFacade.aggiungi();

				break;
			case 3:

				String idOggetto = JOptionPane.showInputDialog("Digita id ");
				dataBaseFacade.elimina(idOggetto);

				break;
			default:
				break;
			}
		} while (scelta != 0);
	}
}
