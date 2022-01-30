package com.azienda.mydbapp;

public class Init extends Config {

	public Init() {
		welcomeApp();
		MainApp.menuPrincipale();
	}

	public void welcomeApp() {
		System.out.printf("Benvenuto in %1$s (Versione: %2$s.%3$s.%4$s.%5$s)%n", nome, version, subVersion, revision,
				build);
		System.out.printf("Rilasciato con licenza %1$s. %2$s %n", license, url);
	}

}
