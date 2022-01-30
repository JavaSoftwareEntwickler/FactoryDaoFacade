package com.azienda.mydbapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.azienda.mydbapp.db.DbConfig;
import com.azienda.mydbapp.db.models.DettagliOrdine;
import com.azienda.mydbapp.db.models.Ordine;

public class OrdineService extends DbConfig implements Crud<Ordine> {

	@Override
	public List<Ordine> findAll() {
		List<Ordine> ordini = new ArrayList<>();

		Connection conn1 = null;
		Connection conn2 = null;
		Statement stmt1 = null;
		PreparedStatement stmt2 = null;

		try {
			Class.forName(driver);
			conn1 = DriverManager.getConnection(conStr, user, passw);
			conn2 = DriverManager.getConnection(conStr, user, passw);
			stmt1 = conn1.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM ordini");
			String sql = "SELECT * FROM `dettagli ordini` ordini WHERE idordine = ?";

			while (rs1.next()) {
				var ordine = new Ordine(Integer.parseInt(rs1.getString("idordine")), rs1.getString("IDCliente"));
				ordini.add(ordine);

				stmt2 = conn2.prepareStatement(sql);
				stmt2.setInt(1, ordine.getIdOrdine());
				ResultSet rs2 = stmt2.executeQuery();

				while (rs2.next()) {
					var dettagliOrdine = new DettagliOrdine(rs2.getString("idordine"), rs2.getString("idprodotto"),
							Double.parseDouble(rs2.getString("prezzoUnitario")),
							Integer.parseInt(rs2.getString("quantità")), Float.parseFloat(rs2.getString("sconto")));
					ordine.add(dettagliOrdine);
				}
			}
			conn1.close();
			conn2.close();
		} catch (Exception e) {
			System.out.printf("Il DB è spento. Eventuali dettagli errore : %1$s %n", e.getMessage());
		}
		return ordini;
	}

	@Override
	public boolean add(Ordine t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Ordine t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upDate(Ordine t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Crud<Ordine> cercaById(Ordine t) {
		// TODO Auto-generated method stub
		return null;
	}

}
