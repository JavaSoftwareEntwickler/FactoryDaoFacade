package com.azienda.mydbapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.azienda.mydbapp.db.DbConfig;
import com.azienda.mydbapp.db.models.Cliente;
import com.azienda.mydbapp.db.models.Ordine;

public class ClienteService extends DbConfig implements Crud<Cliente> {

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clienti = new ArrayList<>();
		Connection conn1 = null;
		Connection conn2 = null;
		Statement stmt1 = null;
		Statement stmt2 = null;// esistono anche le TransactionalWritert ---> "piú transazioni gestibili
		// "assieme" che sono una serie di query
		// poi si devono o confermare o annullare ---> :commit oppure :rollback;

		try {
			Class.forName(driver);

			conn1 = DriverManager.getConnection(conStr, user, passw);
			conn2 = DriverManager.getConnection(conStr, user, passw);
			stmt1 = conn1.createStatement();
			stmt2 = conn2.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM CLIENTI");
			ResultSet rs2 = null;

			while (rs1.next()) {
				var c = new Cliente(rs1.getString("IDCliente"), rs1.getString("NomeSocietà"), rs1.getString("Contatto"),
						rs1.getString("Telefono"), rs1.getString("Città"));
				clienti.add(c);

				rs2 = stmt2.executeQuery("SELECT * FROM ORDINI WHERE IDCliente = '" + c.getIdCliente() + "'");
				while (rs2.next()) {
					var ord = new Ordine(Integer.parseInt(rs2.getString("IDOrdine")), rs2.getString("IDCliente"));
					c.addOrdine(ord);
				}
			}
			conn1.close();
			conn2.close();
		} catch (Exception e) {
			System.out.printf("Il DB è spento. Eventuali dettagli errore : %1$s %n", e.getMessage());
		}
		return clienti;
	}

	@Override
	public Crud<Cliente> cercaById(Cliente cli) {

		Connection conn1 = null;
		Statement stmt1 = null;

		return null;
	}

	@Override
	public boolean add(Cliente c) {
		var righeInserite = 0;
		Connection conn = null;
		PreparedStatement prtStm = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr, user, passw);
			String sql = "INSERT INTO clienti (idcliente, nomesocietà, indirizzo, città) VALUES(?,?,?,?)";
			prtStm = conn.prepareStatement(sql);
			prtStm.setString(1, c.getIdCliente());
			prtStm.setString(2, c.getNomeSocietà());
			prtStm.setString(3, c.getIndirizzo());
			prtStm.setString(4, c.getCitta());
			righeInserite = prtStm.executeUpdate();
			prtStm.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (righeInserite > 0) ? true : false;
	}

	@Override
	public boolean delete(Cliente c) {
		var righeEliminate = 0;
		Connection conn = null;
		PreparedStatement prSt = null;

		try {
			String sql = "DELETE FROM clienti WHERE IDCliente = ?";
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr, user, passw);
			prSt = conn.prepareStatement(sql);

			prSt.setString(1, c.getIdCliente());
			righeEliminate = prSt.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		}

		return (righeEliminate > 0) ? true : false;
	}

	@Override
	public boolean upDate(Cliente c) {

		var righeAggiornate = 0;
		Connection conn = null;
		PreparedStatement prSt = null;

		try {
			String sql = "UPDATE clienti set nomesocietà = ?, indirizzo = ?, città = ? WHERE idcliente = ?;";
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr, user, passw);
			prSt = conn.prepareStatement(sql);

			prSt.setString(4, c.getIdCliente());
			prSt.setString(1, c.getNomeSocietà());
			prSt.setString(2, c.getIndirizzo());
			prSt.setString(3, c.getCitta());
			righeAggiornate = prSt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (righeAggiornate > 0) ? true : false;
	}

}
