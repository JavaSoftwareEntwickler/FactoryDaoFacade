package com.azienda.mydbapp;

//questa dovrebbe essere una classe astratta perché non serve istanziarla
public abstract class Config {

	protected String nome;
	protected int version;
	protected int subVersion;
	protected int revision;
	protected int build;
	protected String license;
	protected String url;

	{
		nome = "NorthWind";
		version = 1;
		subVersion = 0;
		revision = 0;
		build = 1;
		license = "GPL v1";
		url = "https://www.azienda.com/NorthWindApp";
	}

}
