package com.azienda.mydbapp.esempi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {

	public static void esempio01(String paese) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// ------------------connessione a: protocolli //macchina/nomeDB user, psw
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");

			String sql = "SELECT * FROM city WHERE CountryCode = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, paese);
			ResultSet rSet = stmt.executeQuery();
			var r = 0;
			while (rSet.next()) {
				System.out.print(rSet.getString("name") + " -> " + rSet.getString("population"));
				System.out.println();
				r++;
			}

			System.out.println("Trovate " + r + " riga/righe");

			rSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void esempio02() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");
			String sql = "SELECT MAX(population) AS \"Totale\" FROM city";
			stmt = conn.createStatement();

			ResultSet rSet = stmt.executeQuery(sql);

			while (rSet.next()) {
				System.out.print("Totale citta' con popolazione massima -> " + rSet.getString("Totale"));
				System.out.println();
			}

			rSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void esempio03(String nome) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");

			String sql = "SELECT * FROM city WHERE NAME LIKE CONCAT('%',?,'%');";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rSet = stmt.executeQuery();
			var r = 0;
			while (rSet.next()) {
				System.out.print(rSet.getString("NAME") + " -> " + rSet.getString("population"));
				System.out.println();
				r++;
			}

			System.out.println("Trovate " + r + " riga/righe");

			rSet.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void esempio04(String nome, String code, int popolazione) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");

			String sql = "INSERT INTO city (name, countrycode, population) VALUES(?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, code);
			stmt.setInt(3, popolazione);
			int righe = stmt.executeUpdate();

			System.out.println("Inserite " + righe + " riga/righe");

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void esempio05(String nuovoNome, String nome) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");
			String sql = "UPDATE city SET name = ? WHERE name = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nuovoNome);
			stmt.setString(2, nome);
			int righe = stmt.executeUpdate();

			System.out.println("Modificate " + righe + " riga/righe");

			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void esempio06(String nome) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/World", "root", "");
			String sql = "DELETE FROM city WHERE name = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			int righe = stmt.executeUpdate();

			System.out.println("Eliminate " + righe + " riga/righe");

			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
