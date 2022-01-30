package com.azienda.mydbapp.db;

public abstract class DbConfig {

	protected String driver;
	protected String conStr;
	protected String user;
	protected String passw;

	{
		driver = "com.mysql.jdbc.Driver";
		conStr = "jdbc:mysql://localhost/Northwind";
		user = "root";
		passw = "";
	}

}
